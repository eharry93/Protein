package ui;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.LogarithmicAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Evan on 12/12/2014.
 */
public class TLGraph extends JFrame {

    public TLGraph(XYSeries s1) {

        super("Model Results");

        final XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(s1);

        JFreeChart chart = ChartFactory.createXYLineChart("Model Results", "Category", "Value", dataset, PlotOrientation.VERTICAL, false, true, false);

        final XYPlot plot = chart.getXYPlot();
        final NumberAxis rangeAxis = new NumberAxis("Transmission Loss (dB)");
        final NumberAxis domainAxis = new LogarithmicAxis("Freq(Hz)");
        plot.setDomainAxis(domainAxis);
        plot.setRangeAxis(rangeAxis);
        chart.setBackgroundPaint(Color.white);
        plot.setOutlinePaint(Color.black);
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(chartPanel);
    }
}
