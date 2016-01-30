package com.example.suhussai.as1;

import android.test.ActivityInstrumentationTestCase2;

import com.example.suhussai.as1.model.FuelUsageEntry;
import com.example.suhussai.as1.model.Log;

import java.math.BigDecimal;
import java.math.RoundingMode;

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
        BigDecimal odometerReading = new BigDecimal(13043.21).setScale(1, RoundingMode.FLOOR);
        BigDecimal fuelAmount = new BigDecimal(2.3).setScale(3, RoundingMode.FLOOR);
        BigDecimal fuelUnitCost = new BigDecimal(33.3).setScale(1, RoundingMode.FLOOR);
        BigDecimal fuelCost = new BigDecimal(122.3).setScale(2, RoundingMode.FLOOR);


        fuelUsageEntry.setDate(dateValue);
        fuelUsageEntry.setStation(stationName);
        fuelUsageEntry.setFuelGrade(fuelGrade);
        fuelUsageEntry.setFuelAmount(fuelAmount);
        fuelUsageEntry.setFuelUnitCost(fuelUnitCost);
        fuelUsageEntry.setFuelCost(fuelCost);
        fuelUsageEntry.setOdometerReading(odometerReading);

        String correctString =
                "Date: "+ dateValue + " \n" +
                        "Station: "+ stationName + " \n" +
                        "Odometer Reading: "+ odometerReading + " \n" +
                        "Fuel Grade: "+ fuelGrade + " \n" +
                        "Fuel Amount: "+ fuelAmount + " \n" +
                        "Fuel Unit Cost: "+ fuelUnitCost + " \n" +
                        "Fuel Cost: "+ fuelCost + " \n";

        assertTrue(correctString.equals(fuelUsageEntry.toString()));
    }

}

