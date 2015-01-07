package dataManagement;

import java.io.*;
import java.util.Scanner;

import maths.EquationControl;

/**
 * Created by Evan on 07/01/2015.
 */
public class DatabaseReader extends EquationControl {

    public File BMData = new File("res/BM Data.txt");

    public void FileReader() throws FileNotFoundException {
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
}
