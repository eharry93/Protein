package maths;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Evan on 05/01/2015.
 */
public class EquationControl {

    public static Data Dataset = new Data();

    public List<Double> TLSolver(double SteelWeight, double HLDensity, double FoamThickness, double BMThickness) {
        Dataset.BMThickness = BMThickness;
        Dataset.BMDensity = SteelWeight;
        Dataset.BarrierDensity = HLDensity;
        Dataset.DecouplerThickness = FoamThickness;

        TransmissionLoss Solver = new TransmissionLoss();

        for (double i : Dataset.Freq) {
            Dataset.TLSolverResults.add(Solver.NewSolver(i));
        }

        return Dataset.TLSolverResults;
    }

    public double[] CoincidenceFactor() {
        CoincidenceCalc Solver = new CoincidenceCalc();
        Dataset.CritFreq = Solver.CritFreqCalc(Dataset.BMThickness, 5000.0);
        Dataset.CritFreqBand = Solver.CritFreqBandCalc(Dataset.CritFreq);
        Dataset.CoincAddFactor = Solver.CoincidenceAddFactorCalc(Dataset.CritFreq, Dataset.CritFreqBand, 0.01);
        return Dataset.CoincAddFactor;
    }

    public List<Double> AddResults() {
        for (int i = 0; i < Dataset.FreqIndex.length; i++) {
            Dataset.Results.add(Dataset.CoincAddFactor[i] + Dataset.TLSolverResults.get(i));
        }

        return Dataset.Results;
    }

    public void ResetArrays() {
        Dataset.TLSolverResults.clear();
        Dataset.Results.clear();
    }

    public void MLTest() {
        TransmissionLoss Solver = new TransmissionLoss();
        List<Double> Result = new ArrayList<Double>();
        for (int i = 0; i<Dataset.Freq.length; i++) {
            Result.add(Solver.SteelTL(Dataset.Freq[i], (7.8 * 1.0)));
        }
        System.out.println(Result);
    }
}
