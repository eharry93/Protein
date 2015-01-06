package maths;

import java.lang.Math;

/**
 * Created by Evan on 05/01/2015.
 */
public class CoincidenceCalc extends EquationControl {

    public double CritFreqCalc(double BMThickness, double BMWavespeed) {
        double a, b, c;
        a = Math.pow(Dataset.SpeedOfSound,2);
        b = 1.8 * (BMThickness / 1000) * BMWavespeed;
        c = a / b;
        Dataset.CritFreq = c;
        return Dataset.CritFreq;
    }

    public double[] CoincidenceAddFactorCalc(double CritFreq, int Freq, int FreqBandIndex, double DLF, boolean GlassCoinc) {
        for (int i = FreqBandIndex; i<)

        return Dataset.CoincAddFactor;
    }

    public int CritFreqBandCalc(double CritFreq) {
        if(CritFreq > 8800) {
            Dataset.CritFreqBand = 20;
            }
        else if(CritFreq > 7070) {
            Dataset.CritFreqBand = 19;
        }
        else if(CritFreq > 5650) {
            Dataset.CritFreqBand = 18;
        }
        else if(CritFreq > 4400) {
            Dataset.CritFreqBand = 17;
        }
        else if(CritFreq > 3530) {
            Dataset.CritFreqBand = 16;
        }
        else if(CritFreq > 2825) {
            Dataset.CritFreqBand = 15;
        }
        else if(CritFreq > 2250) {
            Dataset.CritFreqBand = 14;
        }
        else if(CritFreq > 1760) {
            Dataset.CritFreqBand = 13;
        }
        else if(CritFreq > 1414) {
            Dataset.CritFreqBand = 12;
        }
        else if(CritFreq > 1130) {
            Dataset.CritFreqBand = 11;
        }
        else if(CritFreq > 880) {
            Dataset.CritFreqBand = 10;
        }
        else if(CritFreq > 707) {
            Dataset.CritFreqBand = 9;
        }
        else if(CritFreq > 565) {
            Dataset.CritFreqBand = 8;
        }
        else if(CritFreq > 440) {
            Dataset.CritFreqBand = 7;
        }
        else if(CritFreq > 353) {
            Dataset.CritFreqBand = 6;
        }
        else if(CritFreq > 283) {
            Dataset.CritFreqBand = 5;
        }
        else if(CritFreq > 225) {
            Dataset.CritFreqBand = 4;
        }
        else if(CritFreq > 176) {
            Dataset.CritFreqBand = 3;
        }
        else if(CritFreq > 141) {
            Dataset.CritFreqBand = 2;
        }
        else if(CritFreq > 113) {
            Dataset.CritFreqBand = 1;
        }
        else if(CritFreq > 88) {
            Dataset.CritFreqBand = 0;
        }
        return Dataset.CritFreqBand;
    }

}
