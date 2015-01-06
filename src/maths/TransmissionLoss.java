package maths;

/**
 * Created by Evan on 07/11/2014.
 */
public class TransmissionLoss extends EquationControl {
//    public static double[] Freq = {
//            100, 125, 160, 200, 250, 315, 400, 500, 630, 800, 1000, 1250, 1600, 2000, 2500, 3150, 4000, 5000, 6300, 8000, 10000
//    };
//    public static double[] GraphData = new double[21];
//    public static double[] SteelTLData = new double [21];
//    public static double[] MaterialILData = new double [21];

//    First Solver - New one implemented below
//    public void Solve(Double SteelWeight, Double HLDensity, Double FoamThickness)  {
//
//        int i;
//        double TotalMass;
//        TotalMass = SteelWeight + HLDensity;
//        for (i=0; i<Freq.length; i++)	{
//            MLTor(Freq[i], TotalMass);
//            MassLawArray[i] = MLTor;
//        }
//
//        for (i=0; i<Freq.length; i++)	{
//            TransRegion(Freq[i], SteelWeight, HLDensity, FoamThickness);
//            TransRegionArray[i] = TransRegion;
//        }
//
//        for (i=0; i<Freq.length; i++)	{
//            DoubleRegion(Freq[i], SteelWeight, HLDensity);
//            DoubleRegionArray[i] = DoubleRegion;
//        }
//
//        for (i=0; i<Freq.length; i++)	{
//            SteelTL(Freq[i], SteelWeight);
//            SteelTLArray[i] = SteelTL;
//            SteelTLData[i] = SteelTL;
//        }
//
//        EquivMass(SteelWeight, HLDensity);
//        DoubleWallResonance(FoamThickness);
//        UpperResonantFrequency(FoamThickness);
//
//        //Solve Iterations
//        //First Iteration
//        for (i=0; i<Freq.length; i++)	{
//            FirstSolve(Freq[i], WallResHz, MassLawArray[i], TransRegionArray[i]);
//            FirstSolveArray[i] = FirstSolve;
//        }
//        //Second Iteration
//        for (i=0; i<Freq.length; i++)	{
//            SecondSolve(Freq[i], UpperResHz, DoubleRegionArray[i]);
//            SecondSolveArray[i] = SecondSolve;
//        }
//        //Final Result
//        for (i=0; i<Freq.length; i++)	{
//            TLResult(FirstSolveArray[i], SecondSolveArray[i]);
//            TLResultArray[i] = TLResult;
//            GraphData[i] = TLResult;
//        }
//        //IL of System
//        for (i=0; i<Freq.length; i++)	{
//            MaterialIL(TLResultArray[i], SteelTLArray[i]);
//            MaterialILArray[i] = MaterialIL;
//            MaterialILData[i] = MaterialIL;
////            Bug tracking use - answer check
////            System.out.println(MaterialILArray[i]);
//        }
//    }

    public double NewSolver(double SteelWeight, double HLDensity, double FoamThickness, double freq) {
        double TotalMass;
        TotalMass = SteelWeight + HLDensity;

        MLTor(freq, TotalMass);
        TransRegion(freq, SteelWeight, HLDensity, FoamThickness);
        DoubleRegion(freq, SteelWeight, HLDensity);
        SteelTL(freq, SteelWeight);

        EquivMass(SteelWeight, HLDensity);
        DoubleWallResonance(FoamThickness);
        UpperResonantFrequency(FoamThickness);

        FirstSolve(freq, Dataset.WallResHz, Dataset.MLTor, Dataset.TransRegion);
        SecondSolve(freq, Dataset.UpperResHz, Dataset.DoubleRegion);
        TLResult(Dataset.FirstSolve, Dataset.SecondSolve);

        return Dataset.TLResult;
    }

    public double DoubleWallResonance(double FoamThick)	{
        double a, b, c;
        a = FoamThick / 1000;
        b = a * Dataset.EquivMass;
        c = Math.pow(b,0.5);
        Dataset.WallResHz = 42/c;
        return Dataset.WallResHz;
    }

    public double EquivMass (double Weight, double Density)	{
        double a, b;
        a = Weight * Density;
        b = Density + Weight;
        Dataset.EquivMass = a / b;
        return Dataset.EquivMass;
    }

    public double UpperResonantFrequency (double FoamThick)	{
        double a, b;
        a = 12 * (FoamThick/1000);
        b = 340/a;
        Dataset.UpperResHz = b;
        return Dataset.UpperResHz;
    }

    public double MLTor (double Frequency, double Mass)	{
        Dataset.MLTor = (20 * (Math.log10(Mass * Frequency)) - 47.2);
        return Dataset.MLTor;
    }

    public double TransRegion (double Frequency, double Mass, double Density, double FoamThick)	{
        double a, b, c;
        a = (20 * (Math.log10(Mass * Frequency)) - 47.2);
        b = (20 * (Math.log10(Density * Frequency)) - 47.2);
        c = (20 * (Math.log10((FoamThick/1000) * Frequency)) - 28.7);
        Dataset.TransRegion = a + b + c;
        return Dataset.TransRegion;
    }

    public double DoubleRegion (double Frequency, double Mass, double Density)	{
        double a, b;
        a = (20 * (Math.log10(Mass * Frequency)) - 47.2);
        b = (20 * (Math.log10(Density * Frequency)) - 47.2);
        Dataset.DoubleRegion = a + b;
        return Dataset.DoubleRegion;
    }

    public double FirstSolve (double Frequency, double DoubleWallRes, double MassLaw, double TransRegion)	{
        if (Frequency <= DoubleWallRes)	{
            Dataset.FirstSolve = MassLaw;
        } else {
            Dataset.FirstSolve = TransRegion;
        }
        return Dataset.FirstSolve;
    }

    public double SecondSolve (double Frequency, double UpperResHz, double DoubleRegion)	{
        if (Frequency > UpperResHz)	{
            Dataset.SecondSolve = DoubleRegion;
        } else {
            Dataset.SecondSolve = 0;
        }
        return Dataset.SecondSolve;
    }

    public double TLResult (double FirstSolve, double SecondSolve)	{
        if (SecondSolve > 0)	{
            Dataset.TLResult = SecondSolve;
        } else {
            Dataset.TLResult = FirstSolve;
        }
        return Dataset.TLResult;
    }

    public double SteelTL (double Frequency, double SteelWeight)	{
        Dataset.SteelTL = (20 * (Math.log10(SteelWeight * Frequency)) - 47.2);
        return Dataset.SteelTL;
    }

    public double MaterialIL (double Trim, double Bare)	{
        Dataset.MaterialIL = Trim - Bare;
        return Dataset.MaterialIL;
    }
}