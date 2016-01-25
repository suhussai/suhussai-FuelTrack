package com.example.suhussai.as1;

import java.util.Date;

/**
 * Created by suhussai on 25/01/16.
 */
public class Entry <T extends Message>{

    private Date date;
    private T FuelUsageMessage;

    public T getMessage() {
        return this.FuelUsageMessage;
    }

    public void setMessage(T message) {
        this.FuelUsageMessage = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
