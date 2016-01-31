package com.example.suhussai.as1.model;

import com.example.suhussai.as1.model.Entry;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by suhussai on 25/01/16.
 */
public class FuelUsageEntry extends Entry {
    private String station="", fuelGrade= "";
    private BigDecimal odometerReading, fuelAmount, fuelUnitCost, fuelCost;

    public FuelUsageEntry() {
        this.odometerReading = new BigDecimal(0).setScale(1, RoundingMode.FLOOR);;
        this.fuelAmount = new BigDecimal(0).setScale(3, RoundingMode.FLOOR);;
        this.fuelUnitCost = new BigDecimal(0).setScale(1, RoundingMode.FLOOR);;
        this.fuelCost = new BigDecimal(0).setScale(2, RoundingMode.FLOOR);;

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
        messageID -= this.station.hashCode();
        this.station = station;
        messageID += this.station.hashCode();
    }

    public String getFuelGrade() {
        return fuelGrade;
    }

    public void setFuelGrade(String fuelGrade) {
        messageID -= this.fuelGrade.hashCode();
        this.fuelGrade = fuelGrade;
        messageID += this.fuelGrade.hashCode();
    }

    public BigDecimal getOdometerReading() {
        return odometerReading;
    }

    public void setOdometerReading(BigDecimal odometerReading) {
        messageID -= this.odometerReading.setScale(1, RoundingMode.FLOOR).hashCode();
        this.odometerReading = odometerReading;
        this.odometerReading = this.odometerReading.setScale(1, RoundingMode.FLOOR);
        messageID += this.odometerReading.hashCode();

    }

    public BigDecimal getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(BigDecimal fuelAmount) {
        messageID -= this.fuelAmount.setScale(3, RoundingMode.FLOOR).hashCode();
        this.fuelAmount = fuelAmount;
        this.fuelAmount = this.fuelAmount.setScale(3, RoundingMode.FLOOR);
        messageID += this.fuelAmount.hashCode();
    }

    public BigDecimal getFuelUnitCost() {
        return fuelUnitCost;
    }

    public void setFuelUnitCost(BigDecimal fuelUnitCost) {
        messageID -= this.fuelUnitCost.setScale(1, RoundingMode.FLOOR).hashCode();
        this.fuelUnitCost = fuelUnitCost;
        this.fuelUnitCost = this.fuelUnitCost.setScale(1, RoundingMode.FLOOR);
        messageID += this.fuelUnitCost.hashCode();
    }

    public BigDecimal getFuelCost() {
        return fuelCost;
    }

    public void setFuelCost(BigDecimal fuelCost) {
        messageID -= this.fuelCost.setScale(2, RoundingMode.FLOOR).hashCode();
        this.fuelCost = fuelCost;
        this.fuelCost = this.fuelCost.setScale(2, RoundingMode.FLOOR);
        messageID += this.fuelCost.hashCode();
    }

    @Override
    public void setDate(String date) {
        this.messageID -= this.getDate().hashCode();
        this.date = date;
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
