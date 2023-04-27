package program.MainProgram;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.data.category.DefaultCategoryDataset;
import program.NonGUIElements.DataSet;
import program.NonGUIElements.Validation;

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
        double minY = getRangeBounds(dataSets, false);
        double maxY = getRangeBounds(dataSets, true);
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

    private DefaultCategoryDataset createDataset(List<DataSet> dataSetsIn) {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for(DataSet dataSetIn : dataSetsIn) {
            for (DataSet.DataPoint dataPoint : dataSetIn.getDataPoints()) {
                //print date in format dd/mm/yyyy
                String dateFormated = Validation.dateToddmmyyyySlash(dataPoint.getDate());
                dataset.addValue(dataPoint.getValue(), dataSetIn.getSeriesName(), dateFormated);
            }
        }
        return dataset;
    }
    private double getRangeBounds(List<DataSet> dataSets , boolean max) {
        //if max is true, returns the max value in the list of datapoint.weight, otherwise returns the min value
        double value = 0;
        for(int i=0;i<dataSets.size();i++) {
            if (dataSets.get(i).getDataPoints().size() > 0) {
                value = dataSets.get(i).getDataPoints().get(0).getValue();
                break;
            }
        }
        for (DataSet dataSet : dataSets){
            if (dataSet.getDataPoints().size() > 0) {
                for (DataSet.DataPoint dataPoint : dataSet.getDataPoints()) {
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
            }
        }
        return value;
    }
}  