package program.NonGUIElements;

import java.util.Date;

public class DataPoint{
    private Date date;
    private double value;
    public DataPoint(Date date, double value){
        this.date = date;
        this.value = value;
    }
    public double getValue(){
        return value;
    }
    public Date getDate(){
        return date;
    }
}