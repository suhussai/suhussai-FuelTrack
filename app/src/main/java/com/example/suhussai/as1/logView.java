package com.example.suhussai.as1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

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
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class logView extends Activity{

    private ListView listView;
    private static final String FILENAME = "file2.sav"; // from lonelyTwitter
    private Log log = new Log();


    private ArrayList loadFromFile() {
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
            return gson.fromJson(in, listType);

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            return new ArrayList<Entry<FuelUsageMessage>>();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        }

    }

    private void saveInFile(ArrayList logs) {
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_view);
        log.setLogs(loadFromFile());

        listView = (ListView) findViewById(R.id.listView);

        Button btnBack = (Button) findViewById(R.id.btnBack);
        Button btnSelect = (Button) findViewById(R.id.btnSelect);
        btnBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setResult(RESULT_OK);
                startActivity(new Intent(logView.this, MainActivity.class));
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Entry<FuelUsageMessage> selectedItem = (Entry<FuelUsageMessage>) listView.getItemAtPosition(position);
                Intent intent = new Intent(logView.this, entry_config.class);
                Format formatter = new SimpleDateFormat("yyyy");
                intent.putExtra("Date", formatter.format(selectedItem.getMessage().getDate()));
                intent.putExtra("Station", selectedItem.getMessage().getStation());
                intent.putExtra("OdometerReading", selectedItem.getMessage().getOdometerReading());
                intent.putExtra("FuelGrade", selectedItem.getMessage().getFuelGrade());
                intent.putExtra("FuelUnitCost", selectedItem.getMessage().getFuelUnitCost());
                intent.putExtra("FuelCost", selectedItem.getMessage().getFuelCost());
                startActivity(intent);

            }
        });

    }

    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        log.setLogs(loadFromFile());
        ArrayAdapter<Entry<FuelUsageMessage>> adapter = new ArrayAdapter<Entry<FuelUsageMessage>>(this, R.layout.list_item, log.getLogs());
        listView.setAdapter(adapter);

    }

}

