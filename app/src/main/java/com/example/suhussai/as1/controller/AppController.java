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
    private static final String FILENAME = "file.sav"; // from lonelyTwitter
    private FuelLog log = new FuelLog();
    private int messageIDToEdit = -1;

    public AppController(Context base) {
        super(base);
        this.log.setLogs(loadFromFile());
    }

    public void saveData(){
        saveInFile(this.log.getLogs());
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
        FuelUsageEntry fuelUsageEntry = new FuelUsageEntry();
        fuelUsageEntry.setDate(dateTaken);
        fuelUsageEntry.setStation(station);
        fuelUsageEntry.setFuelGrade(fuelGrade);
        fuelUsageEntry.setFuelAmount(fuelAmount);
        fuelUsageEntry.setOdometerReading(odometerReading);
        fuelUsageEntry.setFuelUnitCost(fuelUnitCost);
        fuelUsageEntry.setFuelCost(fuelCost);

        if (log.has(fuelUsageEntry.getMessageID())) {
            // do nothing
        }else {
            log.addEntry(fuelUsageEntry);
        }
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


    private ArrayList<FuelUsageEntry> loadFromFile() {
        /*
            Function taken from lonelyTwitter Project.
            https://github.com/shidahe/lonelyTwitter
         */
        try {
            FileInputStream fis = openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));

            Gson gson = new Gson();
            // Took from https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/Gson.html Jan-21-2016
            Type listType = new TypeToken<ArrayList<FuelUsageEntry>>() {}.getType();
            return gson.fromJson(in, listType);

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            return new ArrayList<FuelUsageEntry>();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        }

    }

    private void saveInFile(ArrayList<FuelUsageEntry> logs) {
        /*
            Function taken from lonelyTwitter Project.
            https://github.com/shidahe/lonelyTwitter
         */
        try {
            FileOutputStream fos = openFileOutput(FILENAME,
                    0);

            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));
            Gson gson = new Gson();
            gson.toJson(logs, out);
            out.flush();

            fos.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        }
    }


    public ArrayList getLogs() {
        return log.getLogs();
    }
}
