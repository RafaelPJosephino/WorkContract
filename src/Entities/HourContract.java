package Entities;

import java.util.Date;

public class HourContract {
    private Date data;
    private double valuePerHour;
    private int  hour;

    public void setData(Date data) {
        this.data = data;
    }

    public Date getData() {
        return data;
    }
    
    public void setHour(int hour) {
        this.hour = hour;
    }

    public void setValuePerHour(double valuePerHour) {
        this.valuePerHour = valuePerHour;
    }

    public double totalValue(){
     return valuePerHour*hour;    
    }
    
    
    
}
