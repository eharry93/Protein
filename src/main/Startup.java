package main;

//import ui.MainWindow;
//import maths.*;
import dataManagement.*;

import java.io.FileNotFoundException;

/**
 * Created by Evan on 07/11/2014.
 */
public class Startup {

    public static void main(String[] args) {
//        MainWindow.main(null);
//        EquationControl Tester = new EquationControl();
//        Tester.LowFreqRadCalc();
//        Tester.MLTest();
        DatabaseReader reader = new DatabaseReader();
        try {
            reader.FileReader();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }}
