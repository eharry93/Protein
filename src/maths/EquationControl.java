package maths;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Evan on 05/01/2015.
 */
public class EquationControl {

    Data Dataset = new Data();

    public List<Double> Results = new ArrayList<Double>();

    public List<Double> TLSolver(double SteelWeight, double HLDensity, double FoamThickness) {
        TransmissionLoss Solver = new TransmissionLoss();

        for(double i : Dataset.Freq) {
            Solver.NewSolver(SteelWeight, HLDensity, FoamThickness, i);
            Results.add(Dataset.TLResult);
        }

        return Results;
    }

    public void Test() {
        CoincidenceCalc Solver = new CoincidenceCalc();
        Dataset.CritFreq = Solver.CritFreqCalc(1.0, 5000.0);
        Dataset.CritFreqBand = Solver.CritFreqBandCalc(Dataset.CritFreq);

    }
}
