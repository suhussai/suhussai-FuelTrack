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
public class Log <T extends Entry> {

    protected ArrayList<T> logs;

    public ArrayList<T> getLogs() {
        return logs;
    }

    public Log() {

    }

    public void setLogs(ArrayList<T> logs){
        this.logs = logs;
    }
    public void addEntry(T t){
        this.logs.add(t);
    }
    public void removeEntry(int messageID){
        for (Entry e: this.logs){
            if (e.getMessageID() == messageID){
                this.logs.remove(e);
            }
        }
    }




}
