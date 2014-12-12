package ui;

import maths.TransmissionLoss;
import dataManagement.Systems;
import org.jfree.data.xy.XYSeries;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

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
    public static String[] array = new String[]{"Model 1"};

    public static String newModelName;

    public List<String> ModelNameList = new ArrayList<String>();
    public List<Double> MetalWeightList = new ArrayList<Double>();
    public List<Double> HLDensityList = new ArrayList<Double>();
    public List<Double> FoamThicknessList = new ArrayList<Double>();

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
        TransmissionLoss.SteelWeight = Double.parseDouble(textField1.getText());
        TransmissionLoss.HLDensity = Double.parseDouble(textField2.getText());
        TransmissionLoss.FoamThickness = Double.parseDouble(textField3.getText());
        TransmissionLoss.main(null);
    }

    public void ExportResults() {

    }

    public void Graph() {
        final XYSeries s1 = new XYSeries("Material TL");
        int i;
        for (i = 0; i < TransmissionLoss.Freq.length; i++) {
            s1.add(TransmissionLoss.Freq[i], TransmissionLoss.GraphData[i]);
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
