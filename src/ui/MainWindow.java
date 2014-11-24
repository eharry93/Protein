package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Evan on 24/11/2014.
 */
public class MainWindow {
    private JPanel contentPane;

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
    }

    private static void newModel() {
        SolverWindow.main(null);
    }
}
