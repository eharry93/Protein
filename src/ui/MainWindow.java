package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.jfree.chart.ChartPanel;
import org.jfree.data.xy.XYSeries;

/**
 * Created by Evan on 24/11/2014.
 */
public class MainWindow extends JFrame  {
    private JPanel contentPane;
    private JPanel CardPanel;
    private JPanel JP1, JP2;
    private JLabel JL1, JL2;
    private CardLayout cardLayout;

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
                newModel();
            }
        });
//        Open Model
        JMenuItem mnitmOpen = new JMenuItem("Open Model");
        mnFile.add(mnitmOpen);
//        Save Model
        JMenuItem mnitmSave = new JMenuItem("Save Model");
        mnFile.add(mnitmSave);

//        Window Menu
        JMenu mnWindow = new JMenu("Window");
        menuBar.add(mnWindow);
//        Model
        JMenuItem mnitmModel = new JMenuItem("Model");
        mnWindow.add(mnitmModel);
        mnitmModel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showModel();
            }
        });
//        Graph
        JMenuItem mnitmGraph = new JMenuItem("Graph");
        mnWindow.add(mnitmGraph);
        mnitmGraph.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showGraph();
            }
        });
    }

    public static void main(String[] args) {
        MainWindow Window = new MainWindow();
        Window.setTitle("Protein Modelling Suite");
        Window.setBounds(0,0,400,450);
        Window.setLocationRelativeTo(null);
        Window.setVisible(true);
    }

    private void newModel() {
        SolverWindow.main(null);
    }

    private void showModel() {
        cardLayout.show(CardPanel, "1");
    }

    private void showGraph() {
        cardLayout.show(CardPanel, "2");
    }

    private void createUIComponents() {
        CardPanel = new JPanel();
        cardLayout  = new CardLayout();
        CardPanel.setLayout(cardLayout);
        JP1 = new JPanel();
        JP2 = new JPanel();
        final XYSeries s1 = new XYSeries("");
        TLGraph Diagram = new TLGraph(s1);
        JL1 = new JLabel("Card 1");
        JP2.add(Diagram.chartPanel);
        CardPanel.add(JP1, "1");
        CardPanel.add(JP2, "2");
    }
}
