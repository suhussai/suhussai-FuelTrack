package com.example.suhussai.as1;

import java.util.Date;

/**
 * Created by suhussai on 25/01/16.
 */
public class Entry <T extends Message>{
    private T FuelUsageMessage;

    public Entry() {}

    public T getMessage() {
        return this.FuelUsageMessage;
    }

    public void setMessage(T message) {
        this.FuelUsageMessage = message;
    }

    @Override
    public String toString(){
        return FuelUsageMessage.toString();
    }

}
