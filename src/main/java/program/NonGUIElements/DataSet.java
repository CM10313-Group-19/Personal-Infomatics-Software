package program.NonGUIElements;

import java.util.Date;
import java.util.List;

public class DataSet{
    private List<DataPoint> dataPoints;
    private String seriesName;

    public DataSet(List<DataPoint> dataPoints, String seriesName){
        this.dataPoints = dataPoints;
        this.seriesName = seriesName;
    }

    public List<DataPoint> getDataPoints(){
        return dataPoints;
    }
    public String getSeriesName(){
        return seriesName;
    }
    public static class DataPoint{
        private Date date;
        private double value;
        private double dataID;
        public DataPoint(Date date, double value){
            this.date = date;
            this.value = value;
        }
        public DataPoint(int dataID, Date date, double value){
            this.date = date;
            this.value = value;
            this.dataID = dataID;
        }
        public double getValue(){
            return value;
        }
        public Date getDate(){return date; }
        public double getDataID(){ return dataID; }
    }
}