package com.example.suhussai.as1;

import android.test.ActivityInstrumentationTestCase2;

import com.example.suhussai.as1.model.FuelLog;
import com.example.suhussai.as1.model.FuelUsageEntry;
import com.example.suhussai.as1.model.Log;

import java.math.BigDecimal;
import java.math.RoundingMode;

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
        BigDecimal odometerReading = new BigDecimal(13043.21);
        BigDecimal fuelAmount = new BigDecimal(2.3);
        BigDecimal fuelUnitCost = new BigDecimal(33.3);
        BigDecimal fuelCost1 = new BigDecimal(122.33).setScale(2, RoundingMode.FLOOR);


        FuelUsageEntry fuelUsageEntry = new FuelUsageEntry();
        fuelUsageEntry.setDate(dateValue);
        fuelUsageEntry.setStation(stationName);
        fuelUsageEntry.setFuelGrade(fuelGrade);
        fuelUsageEntry.setFuelAmount(fuelAmount);
        fuelUsageEntry.setFuelUnitCost(fuelUnitCost);
        fuelUsageEntry.setFuelCost(fuelCost1);
        fuelUsageEntry.setOdometerReading(odometerReading);


        dateValue = "2016/11/11";
        stationName = "Costco";
        fuelGrade = "Supreme";
        odometerReading = new BigDecimal(13043.21);
        fuelAmount = new BigDecimal(12.3);
        fuelUnitCost = new BigDecimal(833.3);
        BigDecimal fuelCost2 = new BigDecimal(522.33).setScale(2, RoundingMode.FLOOR);

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

        BigDecimal bd = fuelCost1.add(fuelCost2);
        BigDecimal bd2 = fuelLog.getTotalFuelCost();
        assertTrue(bd2.compareTo(bd) == 0);

        fuelLog.removeEntry(fuelUsageEntry.getMessageID());

        assertTrue(fuelLog.getTotalFuelCost() == fuelCost2);

        fuelLog.removeEntry(fuelUsageEntry2.getMessageID());

        assertTrue(fuelLog.getTotalFuelCost().compareTo(new BigDecimal(0)) == 0);

    }

}

