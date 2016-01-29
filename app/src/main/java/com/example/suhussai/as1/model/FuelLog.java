package com.example.suhussai.as1.model;

import android.content.Context;

/**
 * Created by suhussai on 26/01/16.
 */
public class FuelLog extends Log<FuelUsageEntry> {

    public FuelLog() {
        super();
    }

    public void addEntry(String dateTaken, String station, String fuelGrade,
                         float fuelAmount, float odometerReading, float fuelUnitCost,
                         float fuelCost) {
        FuelUsageEntry fuelUsageEntry = new FuelUsageEntry();
        fuelUsageEntry.setDate(dateTaken);
        fuelUsageEntry.setStation(station);
        fuelUsageEntry.setFuelGrade(fuelGrade);
        fuelUsageEntry.setFuelAmount(fuelAmount);
        fuelUsageEntry.setOdometerReading(odometerReading);
        fuelUsageEntry.setFuelUnitCost(fuelUnitCost);
        fuelUsageEntry.setFuelCost(fuelCost);

        if (this.has(fuelUsageEntry.getMessageID())) {
            // do nothing
        }else {
            super.addEntry(fuelUsageEntry);
        }

    }

    public float getTotalFuelCost() {
        float total = 0;
        for (FuelUsageEntry e: this.logs){
            total += e.getFuelCost();
        }
        return total;
    }

}
