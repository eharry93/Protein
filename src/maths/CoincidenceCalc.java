package maths;

import java.lang.Math;
import java.util.Arrays;

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

    public double[] CoincidenceAddFactorCalc(double CritFreq, int FreqBandIndex, double DLF) {//}, boolean GlassCoinc) {
        int a = FreqBandIndex - 2;
        int i;
//        Coincidence has no effect - add 0
        for (i=0; i<Dataset.CoincAddFactor[a]; i++) {
            Dataset.CoincAddFactor[a] = 0;
        }
//
        double b = 0.15 * ((10 * Math.log10(DLF * Dataset.Freq[a] / CritFreq)) + 3.2);
        Dataset.CoincAddFactor[a] = b;
//
        double c = 0.5 * ((10 * Math.log10(DLF * Dataset.Freq[a] / CritFreq)) + 3.2);
        a = FreqBandIndex - 1;
        Dataset.CoincAddFactor[a] = c;
//
        double d = (10 * Math.log10(DLF * Dataset.Freq[a] / CritFreq)) + 3.2;
        for(a = FreqBandIndex; a < Dataset.CoincAddFactor.length; a++) {
            Dataset.CoincAddFactor[a] = d;
        }

        System.out.println(Arrays.toString(Dataset.CoincAddFactor));

        return Dataset.CoincAddFactor;
    }

    public int CritFreqBandCalc(double CritFreq) {
        if (CritFreq > 17818) {
            Dataset.CritFreqBand = 23;
        }
        else if (CritFreq > 14254) {
            Dataset.CritFreqBand = 22;
        }
        else if (CritFreq > 11136) {
            Dataset.CritFreqBand = 21;
        }
        else if(CritFreq > 8800) {
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
