package com.example.suhussai.as1;

import java.util.ArrayList;

/**
 * Created by suhussai on 25/01/16.
 */
public class Log implements totalFuelCalculator{

    private ArrayList<Entry<FuelUsageMessage>> logs;

    public Log() {
        this.logs = new ArrayList<Entry<FuelUsageMessage>>();
    }

    public void addEntry(Entry entry){
        this.logs.add(entry);
    }

    @Override
    public float getTotalFuelCost() {
        float total = 0;
        for (Entry<FuelUsageMessage> e: this.logs){
            total += e.getMessage().getFuelCost();
        }
        return total;
    }
}
