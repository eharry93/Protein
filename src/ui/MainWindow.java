package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Evan on 24/11/2014.
 */
public class MainWindow {
    private JPanel contentPane;
    private JPanel CardPanel;
    final static String BUTTONPANEL = "Card with JButtons";
    final static String TEXTPANEL = "Card with JTextField";

    public static void main(String[] args) {
        JFrame frame = new JFrame("Protein Modelling Suite");
        frame.setContentPane(new MainWindow().contentPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.pack();
        frame.setBounds(0,0,450,400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
//        Menu Bar
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

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
//        Graph
        JMenuItem mnitmGraph = new JMenuItem("Graph");
        mnWindow.add(mnitmGraph);
    }

    private static void newModel() {
        SolverWindow.main(null);
    }

    private void createUIComponents() {
        JPanel card1 = new JPanel();
        card1.add(new JButton("Button 1"));
        card1.add(new JButton("Button 2"));
        card1.add(new JButton("Button 3"));

        JPanel card2 = new JPanel();
        card2.add(new JTextField("TextField", 20));

        CardPanel.add(card1, BUTTONPANEL);
        CardPanel.add(card2, TEXTPANEL);
    }
}
