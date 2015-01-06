package maths;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Evan on 05/01/2015.
 */
public class EquationControl {

    public static Data Dataset = new Data();

    public List<Double> TLSolver(double SteelWeight, double HLDensity, double FoamThickness, double BMThickness) {
        Dataset.BMThickness = BMThickness;

        TransmissionLoss Solver = new TransmissionLoss();

        System.out.println(Dataset.BMThickness);

        for(double i : Dataset.Freq) {
            Dataset.TLSolverResults.add(Solver.NewSolver(SteelWeight, HLDensity, FoamThickness, i));
        }

        return Dataset.TLSolverResults;
    }

    public double[] CoincidenceFactor() {
        CoincidenceCalc Solver = new CoincidenceCalc();
        System.out.println(Dataset.BMThickness);
        Dataset.CritFreq = Solver.CritFreqCalc(Dataset.BMThickness, 5000.0);
        Dataset.CritFreqBand = Solver.CritFreqBandCalc(Dataset.CritFreq);
        Dataset.CoincAddFactor = Solver.CoincidenceAddFactorCalc(Dataset.CritFreq, Dataset.CritFreqBand, 0.05);
        return Dataset.CoincAddFactor;
    }

    public List<Double> AddResults() {
        System.out.println(Arrays.toString(Dataset.CoincAddFactor));
        for(int i = 0; i<Dataset.FreqIndex.length; i++) {
            Dataset.Results.add(Dataset.CoincAddFactor[i] + Dataset.TLSolverResults.get(i));
        }

        return Dataset.Results;
    }

}
