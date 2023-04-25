package program.MainProgram;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.data.category.DefaultCategoryDataset;
import program.NonGUIElements.DataPoint;

import java.util.List;

public class TimeChart extends JFrame {

    private static final long serialVersionUID = 1L;

    public TimeChart(List<DataPoint> dataPoints, String title, String xAxisLabel, String yAxisLabel, int scaleIncrement) {
        super(title);
        // Create dataset
        DefaultCategoryDataset dataset = createDataset(dataPoints);
        // Create chart
        JFreeChart chart = ChartFactory.createLineChart(
                title, // Chart title
                xAxisLabel, // X-Axis Label
                yAxisLabel, // Y-Axis Label
                dataset
        );

        // Set the range of the y-axis
        ValueAxis yAxis = chart.getCategoryPlot().getRangeAxis();
        double minY = getRangeBounds(dataPoints, false);
        double maxY = getRangeBounds(dataPoints, true);
        minY = Math.floor(minY / scaleIncrement) * scaleIncrement;
        maxY = Math.ceil(maxY / scaleIncrement) * scaleIncrement;
        if (minY == maxY) {
            maxY += scaleIncrement;
        }
        yAxis.setRange(minY - 0.1 * (maxY - minY), maxY + 0.1 * (maxY - minY));


        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
        SwingUtilities.invokeLater(() -> {
            this.setAlwaysOnTop(true);
            this.pack();
            this.setSize(600, 400);
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            this.setVisible(true);
        });
    }

    private DefaultCategoryDataset createDataset(List<DataPoint> dataPoints) {

        String series1 = "Weight recorded";

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (DataPoint dataPoint : dataPoints) {
            //print date in format dd/mm/yyyy
            String dateFormated = dataPoint.getDate().getDate()+"/"+(dataPoint.getDate().getMonth()+1)+"/"+(dataPoint.getDate().getYear()+1900);
            dataset.addValue(dataPoint.getValue(), series1, dateFormated);
        }
        return dataset;
    }
    private double getRangeBounds(List<DataPoint> dataPoints , boolean max) {
        //if max is true, returns the max value in the list of datapoint.weight, otherwise returns the min value
        double value = dataPoints.get(0).getValue();
        for (DataPoint dataPoint : dataPoints) {
            if (max) {
                if (dataPoint.getValue() > value) {
                    value = dataPoint.getValue();
                }
            } else {
                if (dataPoint.getValue() < value) {
                    value = dataPoint.getValue();
                }
            }
        }
        return value;
    }
}  