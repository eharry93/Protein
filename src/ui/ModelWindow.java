package ui;

import maths.TransmissionLoss;
import org.jfree.data.xy.XYSeries;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Evan on 03/12/2014.
 */
public class ModelWindow extends JFrame {
    public JPanel contentPane;
    private JButton ButtonOK, ButtonCancel;
    private JTextField textField1, textField2, textField3;

    public ModelWindow() {
        contentPane = new JPanel();
        setContentPane(contentPane);
        ButtonOK = new JButton("Test");
        contentPane.add(ButtonOK);
        ButtonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SolveModel();
            }
        });
    }

    public void SolveModel() {
        TransmissionLoss.SteelWeight = 7.8;
        TransmissionLoss.HLDensity = 2.0;
        TransmissionLoss.FoamThickness = 20.0;
        TransmissionLoss.main(null);

        final XYSeries s1 = new XYSeries("Material TL");
        int i;
        for (i = 0; i < TransmissionLoss.Freq.length; i++) {
            s1.add(TransmissionLoss.Freq[i], TransmissionLoss.GraphData[i]);
        }
        GraphPanel Diagram = new GraphPanel(s1);
        MainWindow.JP2.add(Diagram.chartPanel);
    }
}
