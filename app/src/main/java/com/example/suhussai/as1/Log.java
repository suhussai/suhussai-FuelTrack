package com.example.suhussai.as1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import android.app.Activity;
import android.content.Context;

/**
 * Created by suhussai on 25/01/16.
 * ref:
 * http://stackoverflow.com/questions/28242386/cannot-resolve-method-openfileoutputjava-lang-string-int
 */
public class Log extends Activity implements totalFuelCalculator{

    private ArrayList<Entry<FuelUsageMessage>> logs;

    public ArrayList<Entry<FuelUsageMessage>> getLogs() {
        return logs;
    }

    public Log() {

    }

    public void setLogs(ArrayList<Entry<FuelUsageMessage>> logs){
        this.logs = logs;
    }
    public void addEntry(Entry entry){
        this.logs.add(entry);
    }
    public void removeEntry(Entry entry){
        this.logs.remove(entry);
    }


    @Override
    public float getTotalFuelCost() {
        float total = 0;
        for (Entry<FuelUsageMessage> e: this.logs){
            total += e.getMessage().getFuelCost();
        }
        return total;
    }


}
