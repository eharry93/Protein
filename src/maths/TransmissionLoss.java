package maths;

/**
 * Created by Evan on 07/11/2014.
 */
public class TransmissionLoss extends EquationControl {

    public double NewSolver(double freq) {
        double TotalMass;
        TotalMass = (Dataset.BMThickness * Dataset.BMDensity) + Dataset.BarrierDensity;
        double BMMass = Dataset.BMThickness * Dataset.BMDensity;

        MLTor(freq, TotalMass);
        TransRegion(freq, BMMass, Dataset.BarrierDensity, Dataset.DecouplerThickness);
        DoubleRegion(freq, BMMass, Dataset.BarrierDensity);
        SteelTL(freq, BMMass);

        EquivMass(BMMass, Dataset.BarrierDensity);
        DoubleWallResonance(Dataset.DecouplerThickness);
        UpperResonantFrequency(Dataset.DecouplerThickness);

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