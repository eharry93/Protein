package maths;

/**
 * Created by Evan on 06/01/2015.
 */
public class LowFreqRadCalc extends EquationControl {

    public double LowFreqCalc(double Freq) {
        double a;
        Dataset.BMArea = 1;
        a = 2 * Math.PI * Freq * Math.sqrt(Dataset.BMArea) / Dataset.SpeedOfSound;
        if(a > 0.85) {
            Dataset.LowFreqRad = 0.5 * (0.2 + Math.log(a));
        } else {
            Dataset.LowFreqRad = 0.01;
        }

        if (Dataset.LowFreqRad > 1) {
            Dataset.LowFreqRad= 1;
        }

        Dataset.LowFreqRad = 1 / Dataset.LowFreqRad;

        return Dataset.LowFreqRad;
    }
}
