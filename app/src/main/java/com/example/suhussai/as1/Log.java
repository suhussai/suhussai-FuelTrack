package com.example.suhussai.as1;

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
    private static final String FILENAME = "file.sav"; // from lonelyTwitter

    public ArrayList<Entry<FuelUsageMessage>> getLogs() {
        return logs;
    }

    public Log() {
        this.loadFromFile();
    }

    public void addEntry(Entry entry){
        this.logs.add(entry);
        this.saveInFile();
    }


    @Override
    public float getTotalFuelCost() {
        float total = 0;
        for (Entry<FuelUsageMessage> e: this.logs){
            total += e.getMessage().getFuelCost();
        }
        return total;
    }

    private void loadFromFile() {
        /*
            Function taken from lonelyTwitter Project.
            https://github.com/shidahe/lonelyTwitter
         */
        try {
            FileInputStream fis = openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));

            Gson gson = new Gson();
            // Took from https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/Gson.html Jan-21-2016
            Type listType = new TypeToken<ArrayList<Entry<FuelUsageMessage>>>() {}.getType();
            this.logs = gson.fromJson(in, listType);

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            this.logs = new ArrayList<Entry<FuelUsageMessage>>();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        }

    }

    private void saveInFile() {
        /*
            Function taken from lonelyTwitter Project.
            https://github.com/shidahe/lonelyTwitter
         */
        try {
            FileOutputStream fos = openFileOutput(FILENAME,
                    0);

            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));
            Gson gson = new Gson();
            gson.toJson(this.logs, out);
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

}
