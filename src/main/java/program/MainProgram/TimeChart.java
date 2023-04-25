package program.MainProgram;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.data.category.DefaultCategoryDataset;
import program.NonGUIElements.DataSet;

import java.util.List;

public class TimeChart extends JFrame {

    private static final long serialVersionUID = 1L;

    public TimeChart(List<DataSet> dataSets, String title, String xAxisLabel, String yAxisLabel, int scaleIncrement) {
        super(title);
        // Create dataset
        DefaultCategoryDataset dataset = createDataset(dataSets);
        // Create chart
        JFreeChart chart = ChartFactory.createLineChart(
                title, // Chart title
                xAxisLabel, // X-Axis Label
                yAxisLabel, // Y-Axis Label
                dataset
        );

        // Set the range of the y-axis
        ValueAxis yAxis = chart.getCategoryPlot().getRangeAxis();
        double minY = getRangeBounds(dataSets.get(0).getDataPoints(), false);
        double maxY = getRangeBounds(dataSets.get(0).getDataPoints(), true);
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

    private DefaultCategoryDataset createDataset(List<DataSet> dataSetIn) {

        String series1 = dataSetIn.get(0).getSeriesName();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (DataSet.DataPoint dataPoint : dataSetIn.get(0).getDataPoints()) {
            //print date in format dd/mm/yyyy
            String dateFormated = dataPoint.getDate().getDate()+"/"+(dataPoint.getDate().getMonth()+1)+"/"+(dataPoint.getDate().getYear()+1900);
            dataset.addValue(dataPoint.getValue(), series1, dateFormated);
        }
        return dataset;
    }
    private double getRangeBounds(List<DataSet.DataPoint> dataPoints , boolean max) {
        //if max is true, returns the max value in the list of datapoint.weight, otherwise returns the min value
        double value = dataPoints.get(0).getValue();
        for (DataSet.DataPoint dataPoint : dataPoints) {
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