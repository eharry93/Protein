package maths;

/**
 * Created by Evan on 05/01/2015.
 */
public class Data {
    public double TLResult, EquivMass, WallResHz, UpperResHz, MLTor, TransRegion, DoubleRegion, FirstSolve, SecondSolve, SteelTL, MaterialIL;
    public double BMThickness, BMWavespeed, BMDensity;
    public double CritFreq, CoincAddFactor[];
    public int CritFreqBand;
    public double SpeedOfSound = 340.0;
    public double[] Freq = {
            100, 125, 160, 200, 250, 315, 400, 500, 630, 800, 1000, 1250, 1600, 2000, 2500, 3150, 4000, 5000, 6300, 8000, 10000
    };
}
