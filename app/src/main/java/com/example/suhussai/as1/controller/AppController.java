package com.example.suhussai.as1.controller;

import android.content.Context;
import android.content.ContextWrapper;

import com.example.suhussai.as1.model.DataFileIO;
import com.example.suhussai.as1.model.FuelLog;
import com.example.suhussai.as1.model.FuelUsageEntry;
import com.example.suhussai.as1.model.Log;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by suhussai on 27/01/16.
 */
public class AppController{
    private FuelLog log = null;
    private int messageIDToEdit = -1;
    private DataFileIO dataFileIO;

    public AppController(Context base) {
        this.log = new FuelLog();
        dataFileIO= new DataFileIO(base);
        this.log.setLogs(dataFileIO.loadFromFile());
    }

    public void saveData(){
        dataFileIO.saveInFile(this.log.getLogs());
    }

    public void removeEntry(int ID) {
        log.removeEntry(ID);
    }

    public FuelUsageEntry getEntry(int ID) {
        return log.getEntry(ID);
    }

    public BigDecimal getTotalCost(){
        return log.getTotalFuelCost();
    }

    public void addEntry(String dateTaken, String station, String fuelGrade,
                         BigDecimal fuelAmount, BigDecimal odometerReading, BigDecimal fuelUnitCost,
                         BigDecimal fuelCost){
        log.addEntry(dateTaken, station, fuelGrade,
                fuelAmount, odometerReading, fuelUnitCost,
                fuelCost);
    }

    public int getMessageIDToEdit() {
        return messageIDToEdit;
    }

    public void setMessageIDToEdit(int messageIDToEdit) {
        this.messageIDToEdit = messageIDToEdit;
    }

    public void setMessageIDToEdit(Object fuelUsageEntry) {
        FuelUsageEntry fuelUsageEntry1 = (FuelUsageEntry) fuelUsageEntry;
        this.messageIDToEdit = fuelUsageEntry1.getMessageID();
    }




    public ArrayList getLogs() {
        return log.getLogs();
    }
}
