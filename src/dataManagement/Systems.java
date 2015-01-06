package dataManagement;

/**
 * Created by Evan on 12/12/2014.
 */
public class Systems {

    String name;
    int a, b, c;

    public Systems(String name) {
        this.name = name;
    }

    public void SystemsA(int SystemsA) {
        a = SystemsA;
    }

    public void SystemsB(int SystemsB) {
        b = SystemsB;
    }

    public void SystemsC(int SystemsC) {
        c = SystemsC;
    }

    public void PrintSystems() {
        System.out.println("Name" + name);
        System.out.println("A" + a);
        System.out.println("B" + b);
        System.out.println("C" + c);
    }

    public Object ModelSubSystem(String name) {
        this.name = name;
        Double thickness;
        Double density;
        return null;
    }


}