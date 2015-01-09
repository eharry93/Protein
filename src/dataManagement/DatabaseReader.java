package dataManagement;

import java.io.*;
import java.util.Scanner;

import maths.EquationControl;

/**
 * Created by Evan on 07/01/2015.
 */
public class DatabaseReader extends EquationControl {

    public File BMData = new File("res/BM Data.txt");
    public File BarrierData = new File("res/Barrier Data.txt");
    public File DecouplerData = new File("res/Decoupler Data.txt");

    public void BMDataReader() throws FileNotFoundException {
        Scanner scan = new Scanner(BMData);
        scan.useDelimiter(",|" + System.getProperty("line.separator"));

        while (scan.hasNext()) {
            Dataset.BMNameArray.add(scan.next());
            Dataset.BMDensityArray.add(Double.valueOf(scan.next()));
            Dataset.BMDLFArray.add(Double.valueOf(scan.next()));
            Dataset.BMWavespeedArray.add(Double.valueOf(scan.next()));
            Dataset.BMGlassArray.add(Boolean.valueOf(scan.next()));
        }
    }

    public void BarrierDataRead() throws FileNotFoundException {
        Scanner scan = new Scanner(BarrierData);
        scan.useDelimiter(",|" + System.getProperty("line.separator"));

        while (scan.hasNext()) {
            Dataset.BarrierNameArray.add(scan.next());
            Dataset.BarrierDensityArray.add(Double.valueOf(scan.next()));
        }
    }

    public void DecouplerDataRead() throws FileNotFoundException {
        Scanner scan = new Scanner(DecouplerData);
        scan.useDelimiter(",|" + System.getProperty("line.separator"));

        while (scan.hasNext()) {
            Dataset.DecouplerNameArray.add(scan.next());
            Dataset.DecouplerDensityArray.add(Double.valueOf(scan.next()));
        }
    }
}
