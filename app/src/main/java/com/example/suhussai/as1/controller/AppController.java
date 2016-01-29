package com.example.suhussai.as1.controller;

import android.content.Context;
import android.content.ContextWrapper;

import com.example.suhussai.as1.model.FuelLog;
import com.example.suhussai.as1.model.FuelUsageEntry;
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
import java.util.ArrayList;

/**
 * Created by suhussai on 27/01/16.
 */
public class AppController extends ContextWrapper{
    private FuelLog log = null;
    private int messageIDToEdit = -1;

    public AppController(Context base) {
        super(base);
        log = new FuelLog(base);
    }

    public void saveData(){
        log.save();
    }

    public void removeEntry(int ID) {
        log.removeEntry(ID);
    }

    public FuelUsageEntry getEntry(int ID) {
        return log.getEntry(ID);
    }

    public float getTotalCost(){
        return log.getTotalFuelCost();
    }

    public void addEntry(String dateTaken, String station, String fuelGrade,
                         float fuelAmount, float odometerReading, float fuelUnitCost,
                         float fuelCost){
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
