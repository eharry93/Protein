package dataManagement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Evan on 05/01/2015.
 */
public class Data {

//    Database Arrays - Bare Metal
    public List<String> BMNameArray = new ArrayList<String>();
    public List<Double> BMThicknessArray = new ArrayList<Double>();
    public List<Double> BMDensityArray = new ArrayList<Double>();
    public List<Double> BMDLFArray = new ArrayList<Double>();
    public List<Double> BMWavespeedArray = new ArrayList<Double>();
    public List<Boolean> BMGlassArray = new ArrayList<Boolean>();
//    Database Arrays - Decoupler
    public List<String> DecouplerNameArray = new ArrayList<String>();
    public List<Double> DecouplerDensityArray = new ArrayList<Double>();
//    Database Arrays - Barrier
    public List<String> BarrierNameArray = new ArrayList<String>();
    public List<Double> BarrierDensityArray = new ArrayList<Double>();

    public double Factorial, Bessel;

    public double[] Freq = {
            100, 125, 160, 200, 250, 315, 400, 500, 630, 800, 1000, 1250, 1600, 2000, 2500, 3150, 4000, 5000, 6300, 8000, 10000
    };
    public int[] FreqIndex = new int[21];

//    TL Solver Variables
    public double TLResult, EquivMass, WallResHz, UpperResHz, MLTor, TransRegion, DoubleRegion, FirstSolve, SecondSolve, SteelTL, MaterialIL;

//    Bare Metal Properties
    public double BMThickness, BMWavespeed, BMDensity, BMArea;
//    Barrier Properties
    public double BarrierThickness, BarrierDensity;
//    Decoupler Properties
    public double DecouplerThickness;

//    Coincidence Variables
    public double CritFreq;
    public int CritFreqBand;
    public double SpeedOfSound = 340.0;
    public double[] CoincAddFactor = new double[23];

//    Low Frequency Radiation Efficiency
    public double LowFreqRad;
    public double[] LowFreqRadFactor = new double[21];

//    Result Arrays
    public List<Double> Results = new ArrayList<Double>();
    public List<Double> TLSolverResults = new ArrayList<Double>();

    public void setBMThickness(double value) {
        BMThickness = value;
    }

    public double getBMThickness() {
        return BMThickness;
    }

}
