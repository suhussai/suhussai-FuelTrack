package com.example.suhussai.as1.model;

import com.example.suhussai.as1.model.Entry;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by suhussai on 25/01/16.
 */
public class FuelUsageEntry extends Entry {
    private String station, fuelGrade;
    private BigDecimal odometerReading, fuelAmount, fuelUnitCost, fuelCost;

    public FuelUsageEntry() {
        this.odometerReading = new BigDecimal(0);
        this.fuelAmount = new BigDecimal(0);
        this.fuelUnitCost = new BigDecimal(0);
        this.fuelCost = new BigDecimal(0);

        messageID = 0;
    }

    @Override
    public int getMessageID() {
        return messageID;
    }

    @Override
    protected void setMessageID(){
        messageID = fuelGrade.hashCode() + station.hashCode();
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
        messageID += this.station.hashCode();
    }

    public String getFuelGrade() {
        return fuelGrade;
    }

    public void setFuelGrade(String fuelGrade) {
        this.fuelGrade = fuelGrade;
        messageID += this.fuelGrade.hashCode();
    }

    public BigDecimal getOdometerReading() {
        return odometerReading;
    }

    public void setOdometerReading(BigDecimal odometerReading) {
        this.odometerReading = odometerReading;
        this.odometerReading = this.odometerReading.setScale(1, RoundingMode.FLOOR);

    }

    public BigDecimal getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(BigDecimal fuelAmount) {
        this.fuelAmount = fuelAmount;
        this.fuelAmount = this.fuelAmount.setScale(3, RoundingMode.FLOOR);
    }

    public BigDecimal getFuelUnitCost() {
        return fuelUnitCost;
    }

    public void setFuelUnitCost(BigDecimal fuelUnitCost) {
        this.fuelUnitCost = fuelUnitCost;
        this.fuelUnitCost = this.fuelUnitCost.setScale(1, RoundingMode.FLOOR);
        messageID += this.fuelUnitCost.hashCode();
    }

    public BigDecimal getFuelCost() {
        return fuelCost;
    }

    public void setFuelCost(BigDecimal fuelCost) {
        this.fuelCost = fuelCost;
        this.fuelCost = this.fuelCost.setScale(2, RoundingMode.FLOOR);
    }

    @Override
    public void setDate(String date) {
        super.setDate(date);
        this.messageID += this.getDate().hashCode();
    }

    @Override
    public String toString(){
        return "Date: "+ date.toString() + " \n" +
                "Station: "+ station + " \n" +
                "Odometer Reading: "+ odometerReading + " \n" +
                "Fuel Grade: "+ fuelGrade + " \n" +
                "Fuel Amount: "+ fuelAmount + " \n" +
                "Fuel Unit Cost: "+ fuelUnitCost + " \n" +
                "Fuel Cost: "+ fuelCost + " \n";
    }

}
