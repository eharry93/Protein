package maths;

import org.jfree.data.xy.XYSeries;
import ui.TLGraph;

/**
 * Created by Evan on 07/11/2014.
 */
public class TransmissionLoss implements Data{
    public static double EquivMass, WallResHz, UpperResHz, MLTor, TransRegion, DoubleRegion, FirstSolve, SecondSolve, TLResult, SteelTL, MaterialIL;
    public static double[] Freq = {
            100, 125, 160, 200, 250, 315, 400, 500, 630, 800, 1000, 1250, 1600, 2000, 2500, 3150, 4000, 5000, 6300, 8000, 10000
    };
    public static double[] GraphData = new double[21];
    public static double[] SteelTLData = new double [21];
    public static double[] MaterialILData = new double [21];
    public static double SteelWeight, HLDensity, FoamThickness;

    public static void main(String[] args)  {
//        Data data = new Data();

        int i;
        double TotalMass;
        TotalMass = SteelWeight + HLDensity;
        for (i=0; i<Freq.length; i++)	{
            MLTor(Freq[i], TotalMass);
            MassLawArray[i] = MLTor;
        }

        for (i=0; i<Freq.length; i++)	{
            TransRegion(Freq[i], SteelWeight, HLDensity, FoamThickness);
            TransRegionArray[i] = TransRegion;
        }

        for (i=0; i<Freq.length; i++)	{
            DoubleRegion(Freq[i], SteelWeight, HLDensity);
            DoubleRegionArray[i] = DoubleRegion;
        }

        for (i=0; i<Freq.length; i++)	{
            SteelTL(Freq[i], SteelWeight);
            SteelTLArray[i] = SteelTL;
            SteelTLData[i] = SteelTL;
        }

        EquivMass(SteelWeight, HLDensity);
        DoubleWallResonance(FoamThickness);
        UpperResonantFrequency(FoamThickness);

        //Solve Iterations
        //First Iteration
        for (i=0; i<Freq.length; i++)	{
            FirstSolve(Freq[i], WallResHz, MassLawArray[i], TransRegionArray[i]);
            FirstSolveArray[i] = FirstSolve;
        }
        //Second Iteration
        for (i=0; i<Freq.length; i++)	{
            SecondSolve(Freq[i], UpperResHz, DoubleRegionArray[i]);
            SecondSolveArray[i] = SecondSolve;
        }
        //Final Result
        for (i=0; i<Freq.length; i++)	{
            TLResult(FirstSolveArray[i], SecondSolveArray[i]);
            TLResultArray[i] = TLResult;
            GraphData[i] = TLResult;
        }
        //IL of System
        for (i=0; i<Freq.length; i++)	{
            MaterialIL(TLResultArray[i], SteelTLArray[i]);
            MaterialILArray[i] = MaterialIL;
            MaterialILData[i] = MaterialIL;
//            Bug tracking use - answer check
//            System.out.println(MaterialILArray[i]);
        }
    }

    public static Double DoubleWallResonance(double FoamThick)	{
        double a, b, c;
        a = FoamThick / 1000;
        b = a * EquivMass;
        c = Math.pow(b,0.5);
        WallResHz = 42/c;
        return WallResHz;
    }

    public static Double EquivMass (double Weight, double Density)	{
        double a, b;
        a = Weight * Density;
        b = Density + Weight;
        EquivMass = a / b;
        return EquivMass;
    }

    public static Double UpperResonantFrequency (double FoamThick)	{
        double a, b;
        a = 12 * (FoamThick/1000);
        b = 340/a;
        UpperResHz = b;
        return UpperResHz;
    }

    public static Double MLTor (double Frequency, double Mass)	{
        MLTor = (20 * (Math.log10(Mass * Frequency)) - 47.2);
        return MLTor;
    }

    public static Double TransRegion (double Frequency, double Mass, double Density, double FoamThick)	{
        double a, b, c;
        a = (20 * (Math.log10(Mass * Frequency)) - 47.2);
        b = (20 * (Math.log10(Density * Frequency)) - 47.2);
        c = (20 * (Math.log10((FoamThick/1000) * Frequency)) - 28.7);
        TransRegion = a + b + c;
        return TransRegion;
    }

    public static Double DoubleRegion (double Frequency, double Mass, double Density)	{
        double a, b;
        a = (20 * (Math.log10(Mass * Frequency)) - 47.2);
        b = (20 * (Math.log10(Density * Frequency)) - 47.2);
        DoubleRegion = a + b;
        return DoubleRegion;
    }

    public static Double FirstSolve (double Frequency, double DoubleWallRes, double MassLaw, double TransRegion)	{
        if (Frequency <= DoubleWallRes)	{
            FirstSolve = MassLaw;
        } else {
            FirstSolve = TransRegion;
        }
        return FirstSolve;
    }

    public static Double SecondSolve (double Frequency, double UpperResHz, double DoubleRegion)	{
        if (Frequency > UpperResHz)	{
            SecondSolve = DoubleRegion;
        } else {
            SecondSolve = 0;
        }
        return SecondSolve;
    }

    public static Double TLResult (double FirstSolve, double SecondSolve)	{
        if (SecondSolve > 0)	{
            TLResult = SecondSolve;
        } else {
            TLResult = FirstSolve;
        }
        return TLResult;
    }

    public static Double SteelTL (double Frequency, double SteelWeight)	{
        SteelTL = (20 * (Math.log10(SteelWeight * Frequency)) - 47.2);
        return SteelTL;
    }

    public static Double MaterialIL (double Trim, double Bare)	{
        MaterialIL = Trim - Bare;
        return MaterialIL;
    }
}