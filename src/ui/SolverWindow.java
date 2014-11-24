package ui;

import javax.swing.*;
import java.awt.event.*;

import maths.TransmissionLoss;

public class SolverWindow extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;

    public SolverWindow() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

// call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

// call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        TransmissionLoss.SteelWeight = Double.parseDouble(textField1.getText());
        TransmissionLoss.HLDensity = Double.parseDouble(textField2.getText());
        TransmissionLoss.FoamThickness = Double.parseDouble(textField3.getText());
        TransmissionLoss.main(null);
//        dispose();
    }

    private void onCancel() {
// add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        SolverWindow dialog = new SolverWindow();
        dialog.setTitle("New Model");
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
//        System.exit(0);
    }
}
