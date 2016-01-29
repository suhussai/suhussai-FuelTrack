package com.example.suhussai.as1;

import android.test.ActivityInstrumentationTestCase2;

import com.example.suhussai.as1.model.FuelUsageEntry;
import com.example.suhussai.as1.model.Log;

/**
 * Created by suhussai on 29/01/16.
 */
public class FuelUsageEntryTest extends ActivityInstrumentationTestCase2 {
    public FuelUsageEntryTest() {
        super(FuelUsageEntry.class);
    }

    public void testToString(){
        FuelUsageEntry fuelUsageEntry = new FuelUsageEntry();
        String dateValue = "2016/11/11";
        String stationName = "Costco";
        String fuelGrade = "Supreme";
        float fuelAmount = 23;
        double fuelUnitCost = 2.13;
        double fuelCost = 39.13;


        fuelUsageEntry.setDate(dateValue);
        fuelUsageEntry.setStation(stationName);
        fuelUsageEntry.setFuelGrade(fuelGrade);
        fuelUsageEntry.setFuelAmount(fuelAmount);
        fuelUsageEntry.setFuelUnitCost(fuelUnitCost);
        fuelUsageEntry.setFuelCost(fuelCost);

        String correctString =
                "Date: "+ dateValue + " \n" +
                        "Station: "+ stationName + " \n" +
                        "Odometer Reading: "+ Float.toString(odometerReading) + " \n" +
                        "Fuel Grade: "+ fuelGrade + " \n" +
                        "Fuel Amount: "+ Float.toString(fuelAmount) + " \n" +
                        "Fuel Unit Cost: "+ Float.toString(fuelUnitCost) + " \n" +
                        "Fuel Cost: "+ Float.toString(fuelCost) + " \n";

        assertTrue(correctString.equals(fuelUsageEntry.toString()));
    }

}

