package com.example.suhussai.as1.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.suhussai.as1.R;
import com.example.suhussai.as1.controller.AppController;
import com.example.suhussai.as1.controller.AppControllerHandler;

import java.math.BigDecimal;

public class entry_config extends Activity {

    private AppController appController = null;

    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        Bundle extras = getIntent().getExtras();
        if (appController.getMessageIDToEdit() != -1) {
            int messageID = appController.getMessageIDToEdit();

            EditText editText;
            editText = (EditText) findViewById(R.id.editTextDate);
            editText.setText(appController.getEntry(messageID).getDate());
            editText = (EditText) findViewById(R.id.editTextStation);
            editText.setText(appController.getEntry(messageID).getStation());
            editText = (EditText) findViewById(R.id.editTextFuelGrade);
            editText.setText(appController.getEntry(messageID).getFuelGrade());
            editText = (EditText) findViewById(R.id.editTextFuelAmount);
            editText.setText((appController.getEntry(messageID).getFuelAmount()).toString());
            editText = (EditText) findViewById(R.id.editTextOdometerReading);
            editText.setText((appController.getEntry(messageID).getOdometerReading()).toString());
            editText = (EditText) findViewById(R.id.editTextFuelUnitCost);
            editText.setText((appController.getEntry(messageID).getFuelUnitCost()).toString());
            editText = (EditText) findViewById(R.id.editTextFuelCost);
            editText.setText((appController.getEntry(messageID).getFuelCost()).toString());

        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        appController = AppControllerHandler.getAppController(this);
        setContentView(R.layout.activity_entry_config);

        Button btnSaveEntryConfig = (Button) findViewById(R.id.btnSaveEntryConfig);
        btnSaveEntryConfig.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // remove entry if
                // editing
                if (appController.getMessageIDToEdit() != -1) {
                    appController.removeEntry(appController.getMessageIDToEdit());
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
                BigDecimal fuelAmount = new BigDecimal(editText.getText().toString());
                editText = (EditText) findViewById(R.id.editTextFuelUnitCost);
                BigDecimal fuelUnitCost = new BigDecimal(editText.getText().toString());
                editText = (EditText) findViewById(R.id.editTextOdometerReading);
                BigDecimal odometerReading = new BigDecimal(editText.getText().toString());
                editText = (EditText) findViewById(R.id.editTextFuelCost);
                BigDecimal fuelCost = new BigDecimal(editText.getText().toString());

                appController.addEntry(dateTaken, station, fuelGrade,
                        fuelAmount, odometerReading, fuelUnitCost, fuelCost);

                startActivity(new Intent(entry_config.this, logView.class));

            }

        });

        Button btnCancelEntryConfig = (Button) findViewById(R.id.btnCancelEntryConfig);
        btnCancelEntryConfig.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setResult(RESULT_OK);
                appController.setMessageIDToEdit(-1);
                startActivity(new Intent(entry_config.this, MainActivity.class));
            }
        });
    }

    @Override
    public void onStop() {
        // ref: http://stackoverflow.com/questions/18361719/android-activity-ondestroy-is-not-always-called-and-if-called-only-part-of-th
        appController.saveData();
        super.onStop();
    }

}

