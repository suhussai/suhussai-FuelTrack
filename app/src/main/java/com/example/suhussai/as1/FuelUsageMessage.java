package com.example.suhussai.as1;

/**
 * Created by suhussai on 25/01/16.
 */
public class FuelUsageMessage extends Message {
    private String station, fuelGrade;
    private float odometerReading, fuelAmount, fuelUnitCost, fuelCost;

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String getFuelGrade() {
        return fuelGrade;
    }

    public void setFuelGrade(String fuelGrade) {
        this.fuelGrade = fuelGrade;
    }

    public float getOdometerReading() {
        return odometerReading;
    }

    public void setOdometerReading(float odometerReading) {
        this.odometerReading = odometerReading;
    }

    public float getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(float fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public float getFuelUnitCost() {
        return fuelUnitCost;
    }

    public void setFuelUnitCost(float fuelUnitCost) {
        this.fuelUnitCost = fuelUnitCost;
    }

    public float getFuelCost() {
        return fuelCost;
    }

    public void setFuelCost(float fuelCost) {
        this.fuelCost = fuelCost;
    }

    @Override
    public String getMessageAsString() {
        return null;
    }

}
