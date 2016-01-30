package com.example.suhussai.as1.model;

import android.content.Context;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by suhussai on 26/01/16.
 */
public class FuelLog extends Log<FuelUsageEntry> {

    public FuelLog() {
        super();
    }

    public void addEntry(String dateTaken, String station, String fuelGrade,
                         BigDecimal fuelAmount, BigDecimal odometerReading, BigDecimal fuelUnitCost,
                         BigDecimal fuelCost) {
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

    public BigDecimal getTotalFuelCost() {
        BigDecimal total = new BigDecimal(0);
        for (FuelUsageEntry e: this.logs){
            total = total.add(e.getFuelCost()).setScale(2, RoundingMode.FLOOR);
        }
        return total;
    }

}
