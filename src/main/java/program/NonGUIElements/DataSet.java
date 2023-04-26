package program.NonGUIElements;

import program.DataTypes.WeightData;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class DataSet {
    private final List<DataPoint> dataPoints;
    private final String seriesName;

    public DataSet(List<DataPoint> dataPoints, String seriesName) {
        this.dataPoints = dataPoints;
        this.seriesName = seriesName;
    }

    public DataSet fromWeights(List<WeightData> weightData, String seriesName) {
        return new DataSet(weightData.stream().map(DataPoint::new).collect(Collectors.toList()),
                seriesName);
    }

    public List<DataPoint> getDataPoints() {
        return dataPoints;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public static class DataPoint {
        private final Date date;
        private final double value;

        public DataPoint(Date date, double value) {
            this.date = date;
            this.value = value;
        }

        public DataPoint(WeightData data) {
            this.date = data.day_measured;
            this.value = data.value;
        }

        public double getValue() {
            return value;
        }

        public Date getDate() {
            return date;
        }
    }
}