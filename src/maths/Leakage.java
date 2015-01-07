package maths;

/**
 * Created by Evan on 07/01/2015.
 */
public class Leakage extends EquationControl {

    public double Factorial(double value) {

        double Temp = 1;
        int Counter;

        if(value == 1) {
            Dataset.Factorial = 1;
        } else {
            for(Counter = 1; Counter <= value; Counter++) {
                Temp = Temp * Counter;
            }
        }
        Dataset.Factorial = Temp;
        System.out.println(Dataset.Factorial);

        return Dataset.Factorial;
    }

    public double BesselFunction(int n, double x) {
        double a, b, c;

        b = 0;

        for(a = 0; a <= 10; a++) {
            c = n + a;
            b = b + ((Math.pow(-1, a) * (Math.pow((x / 2),2 * a))) / (Factorial(a) * Factorial(c)));
        }

        Dataset.Bessel = b * (Math.pow(x / 2, n));

        return Dataset.Bessel;
    }
}