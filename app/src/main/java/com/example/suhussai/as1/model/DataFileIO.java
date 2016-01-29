package com.example.suhussai.as1.model;

import android.content.Context;
import android.content.ContextWrapper;

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
 * Created by suhussai on 29/01/16.
 */
public class DataFileIO <T> extends ContextWrapper{
    private static final String FILENAME = "file2.sav"; // from lonelyTwitter

    public DataFileIO(Context base) {
        super(base);
    }

    public ArrayList<T> loadFromFile() {
        /*
            Function taken from lonelyTwitter Project.
            https://github.com/shidahe/lonelyTwitter
         */
        try {
            FileInputStream fis = openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));

            Gson gson = new Gson();
            // Took from https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/Gson.html Jan-21-2016
            Type listType = new TypeToken<ArrayList<T>>() {}.getType();
            return gson.fromJson(in, listType);

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            return new ArrayList<T>();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        }

    }

    public void saveInFile(ArrayList<T> logs) {
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
}
