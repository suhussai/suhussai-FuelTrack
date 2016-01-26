package com.example.suhussai.as1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class entry_config extends Activity {

    private Log log = new Log();
    private Entry<FuelUsageMessage> itemToEdit = null;
    private final DateFormat formatter = new SimpleDateFormat("yyyy");
    private static final String FILENAME = "file2.sav"; // from lonelyTwitter


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
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        itemToEdit = null;
        log.setLogs(loadFromFile());

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            itemToEdit = new Entry<FuelUsageMessage>();
            //    private String station, fuelGrade;
            String dateStr = extras.getString("Date");
            Date date = null;
            try {
                date = formatter.parse(dateStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            String station = extras.getString("Station");
            String fuelGrade = extras.getString("FuelGrade");
            float fuelAmount = extras.getFloat("FuelAmount");
            float odometerReading = extras.getFloat("OdometerReading");
            float fuelUnitCost = extras.getFloat("FuelUnitCost");
            float fuelCost = extras.getFloat("FuelCost");

            itemToEdit.setMessage(new FuelUsageMessage());
            itemToEdit.getMessage().setDate((Date) date);
            itemToEdit.getMessage().setStation(station);
            itemToEdit.getMessage().setFuelGrade(fuelGrade);
            itemToEdit.getMessage().setFuelAmount(fuelAmount);
            itemToEdit.getMessage().setOdometerReading(odometerReading);
            itemToEdit.getMessage().setFuelUnitCost(fuelUnitCost);
            itemToEdit.getMessage().setFuelCost(fuelCost);

            EditText editText;
            editText = (EditText) findViewById(R.id.editTextDate);
            editText.setText(formatter.format(date));
            editText = (EditText) findViewById(R.id.editTextStation);
            editText.setText(station);
            editText = (EditText) findViewById(R.id.editTextFuelGrade);
            editText.setText(fuelGrade);
            editText = (EditText) findViewById(R.id.editTextFuelAmount);
            editText.setText(Float.toString(fuelAmount));
            editText = (EditText) findViewById(R.id.editTextOdometerReading);
            editText.setText(Float.toString(odometerReading));
            editText = (EditText) findViewById(R.id.editTextFuelUnitCost);
            editText.setText(Float.toString(fuelUnitCost));
            editText = (EditText) findViewById(R.id.editTextFuelCost);
            editText.setText(Float.toString(fuelCost));


        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry_config);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        log.setLogs(loadFromFile());

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            //    private String station, fuelGrade;
            String dateStr = extras.getString("Date");
            Date date = null;
            try {
                date = formatter.parse(dateStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            String station = extras.getString("Station");
            String fuelGrade = extras.getString("FuelGrade");
            float fuelAmount = extras.getFloat("FuelAmount");
            float odometerReading = extras.getFloat("OdometerReading");
            float fuelUnitCost = extras.getFloat("FuelUnitCost");
            float fuelCost = extras.getFloat("FuelCost");

            itemToEdit = new Entry<FuelUsageMessage>();
            itemToEdit.setMessage(new FuelUsageMessage());
            itemToEdit.getMessage().setDate((Date) date);
            itemToEdit.getMessage().setStation(station);
            itemToEdit.getMessage().setFuelGrade(fuelGrade);
            itemToEdit.getMessage().setFuelAmount(fuelAmount);
            itemToEdit.getMessage().setOdometerReading(odometerReading);
            itemToEdit.getMessage().setFuelUnitCost(fuelUnitCost);
            itemToEdit.getMessage().setFuelCost(fuelCost);

            EditText editText;
            editText = (EditText) findViewById(R.id.editTextDate);
            editText.setText(formatter.format(date));
            editText = (EditText) findViewById(R.id.editTextStation);
            editText.setText(station);
            editText = (EditText) findViewById(R.id.editTextFuelGrade);
            editText.setText(fuelGrade);
            editText = (EditText) findViewById(R.id.editTextFuelAmount);
            editText.setText(Float.toString(fuelAmount));
            editText = (EditText) findViewById(R.id.editTextOdometerReading);
            editText.setText(Float.toString(odometerReading));
            editText = (EditText) findViewById(R.id.editTextFuelUnitCost);
            editText.setText(Float.toString(fuelUnitCost));
            editText = (EditText) findViewById(R.id.editTextFuelCost);
            editText.setText(Float.toString(fuelCost));


        }

        Button btnSaveEntryConfig = (Button) findViewById(R.id.btnSaveEntryConfig);
        btnSaveEntryConfig.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // remove entry if
                // editing
                if (itemToEdit != null) {
                    log.removeEntry(itemToEdit);
                } else {
                    itemToEdit = new Entry<FuelUsageMessage>();
                }

                // add new entry
                EditText editText;
                editText = (EditText) findViewById(R.id.editTextDate);
                String dateTaken = editText.getText().toString();
                editText = (EditText) findViewById(R.id.editTextStation);
                String station = editText.getText().toString();
                editText = (EditText) findViewById(R.id.editTextFuelGrade);
                String fuelGrade = editText.getText().toString();
                editText = (EditText) findViewById(R.id.editTextFuelAmount);
                float fuelAmount = Float.parseFloat(editText.getText().toString());
                editText = (EditText) findViewById(R.id.editTextFuelUnitCost);
                float fuelUnitCost = Float.parseFloat(editText.getText().toString());
                editText = (EditText) findViewById(R.id.editTextOdometerReading);
                float odometerReading = Float.parseFloat(editText.getText().toString());
                editText = (EditText) findViewById(R.id.editTextFuelCost);
                float fuelCost = Float.parseFloat(editText.getText().toString());


                itemToEdit.setMessage(new FuelUsageMessage());
                try {
                    if (dateTaken != null) {
                        itemToEdit.getMessage().setDate(formatter.parse(dateTaken));
                    } else {
                        itemToEdit.getMessage().setDate(formatter.parse("2012"));
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                itemToEdit.getMessage().setStation(station);
                itemToEdit.getMessage().setFuelGrade(fuelGrade);
                itemToEdit.getMessage().setFuelAmount(fuelAmount);
                itemToEdit.getMessage().setOdometerReading(odometerReading);
                itemToEdit.getMessage().setFuelUnitCost(fuelUnitCost);
                itemToEdit.getMessage().setFuelCost(fuelCost);
                log.addEntry(itemToEdit);
                saveInFile(log.getLogs());
            }

        });

        Button btnCancelEntryConfig = (Button) findViewById(R.id.btnCancelEntryConfig);
        btnCancelEntryConfig.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setResult(RESULT_OK);
                startActivity(new Intent(entry_config.this, MainActivity.class));

            }
        });




    }
}
