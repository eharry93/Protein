package ui;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.LogarithmicAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Evan on 03/12/2014.
 */
public class GraphPanel extends JFrame {
    public JPanel contentPane;
    public JFreeChart chart;
    public ChartPanel chartPanel;

    public GraphPanel() {
        contentPane = new JPanel();
        setContentPane(contentPane);
    }

    public void Graph() {

    }

    public void AddData() {

    }

//    public GraphPanel(XYSeries s1) {
//
//        final XYSeriesCollection dataset = new XYSeriesCollection();
//        dataset.addSeries(s1);
//
//        chart = ChartFactory.createXYLineChart("Test Chart", "Category", "Value", dataset, PlotOrientation.VERTICAL, false, true, false);
//
//        final XYPlot plot = chart.getXYPlot();
//        final NumberAxis rangeAxis = new NumberAxis("Transmission Loss (dB)");
//        final NumberAxis domainAxis = new LogarithmicAxis("Freq(Hz)");
//        plot.setDomainAxis(domainAxis);
//        plot.setRangeAxis(rangeAxis);
//        chart.setBackgroundPaint(Color.white);
//        plot.setOutlinePaint(Color.black);
//        chartPanel = new ChartPanel(chart);
//        chartPanel.setMouseWheelEnabled(true);
//    }
}
