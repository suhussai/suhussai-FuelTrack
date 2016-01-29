package com.example.suhussai.as1;

import android.test.ActivityInstrumentationTestCase2;

import com.example.suhussai.as1.model.FuelLog;
import com.example.suhussai.as1.model.FuelUsageEntry;
import com.example.suhussai.as1.model.Log;

/**
 * Created by suhussai on 29/01/16.
 */
public class FuelLogTest extends ActivityInstrumentationTestCase2 {
    public FuelLogTest() {
        super(FuelLog.class);
    }

    public void testGetTotalFuelCost(){
        String dateValue = "2016/11/11";
        String stationName = "Costco";
        String fuelGrade = "Supreme";
        float fuelAmount = 23;
        double fuelUnitCost = 2.13;
        double fuelCost1 = 39.13;


        FuelUsageEntry fuelUsageEntry = new FuelUsageEntry();
        fuelUsageEntry.setDate(dateValue);
        fuelUsageEntry.setStation(stationName);
        fuelUsageEntry.setFuelGrade(fuelGrade);
        fuelUsageEntry.setFuelAmount(fuelAmount);
        fuelUsageEntry.setFuelUnitCost(fuelUnitCost);
        fuelUsageEntry.setFuelCost(fuelCost1);


        dateValue = "2016/11/11";
        stationName = "Costco";
        fuelGrade = "Supreme";
        fuelAmount = 23;
        fuelUnitCost = 2.13;
        double fuelCost2 = 39.13;

        FuelUsageEntry fuelUsageEntry2 = new FuelUsageEntry();
        fuelUsageEntry2.setDate(dateValue);
        fuelUsageEntry2.setStation(stationName);
        fuelUsageEntry2.setFuelGrade(fuelGrade);
        fuelUsageEntry2.setFuelAmount(fuelAmount);
        fuelUsageEntry2.setFuelUnitCost(fuelUnitCost);
        fuelUsageEntry2.setFuelCost(fuelCost2);

        FuelLog fuelLog = new FuelLog();
        fuelLog.addEntry(fuelUsageEntry);
        fuelLog.addEntry(fuelUsageEntry2);

        assertTrue(fuelLog.getTotalFuelCost() == fuelCost1 + fuelCost2);

        fuelLog.removeEntry(fuelUsageEntry.getMessageID());

        assertTrue(fuelLog.getTotalFuelCost() == fuelCost2);

        fuelLog.removeEntry(fuelUsageEntry2.getMessageID());

        assertTrue(fuelLog.getTotalFuelCost() == 0);

    }

}

