package ui;

import maths.TransmissionLoss;
import org.jfree.data.xy.XYSeries;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
}
