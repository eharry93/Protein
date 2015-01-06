package ui;

import maths.EquationControl;
import maths.TransmissionLoss;
import dataManagement.Systems;
import org.jfree.data.xy.XYSeries;
import dataManagement.NewFile;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static sun.reflect.annotation.AnnotationParser.toArray;

/**
 * Created by Evan on 12/12/2014.
 */
public class MainWindow extends JFrame {
    private JPanel contentPane;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton solveButton;
    private JButton exportResultsButton;
    private JButton graphButton;
    private JComboBox<String> comboBox1;
    private JButton okayButton;
    private JButton loadButton;
    private JTextField textField4;
    public static String[] array = new String[]{"Model 1"};

    public static String newModelName;

    public static List<String> ModelNameList = new ArrayList<String>();
    public List<Double> MetalWeightList = new ArrayList<Double>();
    public List<Double> HLDensityList = new ArrayList<Double>();
    public List<Double> FoamThicknessList = new ArrayList<Double>();
    public List<Double> Results = new ArrayList<Double>();
    Double GraphResults[];

    public double[] Freq = {
            100, 125, 160, 200, 250, 315, 400, 500, 630, 800, 1000, 1250, 1600, 2000, 2500, 3150, 4000, 5000, 6300, 8000, 10000
    };

    public MainWindow() {
        setContentPane(contentPane);

        //        Menu Bar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

//        File Menu
        JMenu mnFile = new JMenu("File");
        menuBar.add(mnFile);
//        New Model
        JMenuItem mnitmNew = new JMenuItem("New Model");
        mnFile.add(mnitmNew);
        mnitmNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NewModel.main(null);
                NewModel(newModelName);
            }
        });
//        Open Model
        JMenuItem mnitmOpen = new JMenuItem("Open Model");
        mnFile.add(mnitmOpen);
//        Save Model
        JMenuItem mnitmSave = new JMenuItem("Save Model");
        mnFile.add(mnitmSave);
        mnitmSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NewFile createFile = new NewFile();
                try {
                    createFile.CreateFile(new File("test.txt"));
                } catch (IOException e1) {
                    e1.printStackTrace();
                }


            }
        });

//        Button Action Listeners
        solveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Solve();
            }
        });

        exportResultsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ExportResults();
            }
        });

        graphButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Graph();
            }
        });

        okayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SaveSystem();
            }
        });

        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoadSystem();
            }
        });

    }

    public static void main(String[] args) {
        MainWindow Window = new MainWindow();
        Window.setTitle("Protein Modelling Suite");
//        Window.setBounds(0,0,400,300);
        Window.pack();
        Window.setLocationRelativeTo(null);
        Window.setVisible(true);
    }

    public void Solve() {
        EquationControl Solver = new EquationControl();
        Solver.TLSolver(Double.parseDouble(textField1.getText()), Double.parseDouble(textField2.getText()), Double.parseDouble(textField3.getText()), Double.parseDouble(textField4.getText()));
        Solver.CoincidenceFactor();
        Results = Solver.AddResults();
        GraphResults = Results.toArray(new Double[Results.size()]);
        Solver.ResetArrays();
    }

    public void ExportResults() {

    }

    public void Graph() {
        final XYSeries s1 = new XYSeries("Material TL");
        int i;
        for (i = 0; i < Freq.length; i++) {
            s1.add(Freq[i], GraphResults[i]);
        }
        TLGraph diagram = new TLGraph(s1);
        diagram.pack();
        diagram.setVisible(true);
        diagram.setLocationRelativeTo(null);
    }

    private void createUIComponents() {
        comboBox1 = new JComboBox<String>(array);
        // TODO: place custom component creation code here
    }

    public void NewModel(String ModelName) {
        System.out.println("New Model Created!");
        comboBox1.addItem(ModelName);
        comboBox1.setSelectedItem(ModelName);
        Systems newModel = new Systems(ModelName);
        int i = (comboBox1.getSelectedIndex());
        ModelNameList.add(ModelName);
    }

    public void SaveSystem() {
        int i = (comboBox1.getSelectedIndex());
        System.out.println(comboBox1.getSelectedIndex());
        MetalWeightList.add(Double.parseDouble(textField1.getText()));
        HLDensityList.add(Double.parseDouble(textField2.getText()));
        FoamThicknessList.add(Double.parseDouble(textField3.getText()));
    }

    public void LoadSystem() {
        int i = (comboBox1.getSelectedIndex());
        textField1.setText(String.valueOf(MetalWeightList.get(i)));
        textField2.setText(String.valueOf(HLDensityList.get(i)));
        textField3.setText(String.valueOf(FoamThicknessList.get(i)));
    }
}