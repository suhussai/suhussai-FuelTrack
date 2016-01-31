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
import java.math.RoundingMode;

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

        }
    }

    private void displayError(EditText editText, String errorMessage){
        editText.setError(errorMessage);
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
                String dateTaken = null;
                if (editText.getText().toString().matches("\\d+-\\d+-\\d+")) {
                    // "...yyyy-mm-dd format, e.g., 2016-01-18..."
                    dateTaken = editText.getText().toString();
                }
                else {
                    displayError(editText, "Inappropriate format!");
                    return;
                }

                editText = (EditText) findViewById(R.id.editTextStation);
                String station = null;
                if (editText.getText().toString().matches("^\\w+$")) {
                    // "...textual, e.g., regular..."
                    station = editText.getText().toString();
                }
                else {
                    displayError(editText, "Inappropriate format!");
                    return;
                }

                editText = (EditText) findViewById(R.id.editTextFuelGrade);
                String fuelGrade = null;
                if (editText.getText().toString().matches("^\\w+$")) {
                    // "...textual, e.g., Costco..."
                    fuelGrade = editText.getText().toString();
                }
                else {
                    displayError(editText, "Inappropriate format!");
                    return;
                }


                editText = (EditText) findViewById(R.id.editTextFuelAmount);
                BigDecimal fuelAmount = null;
                if (editText.getText().toString().matches("^\\d+\\.\\d{3}$")) {
                    // "...numeric to 3 decimal places..."
                    fuelAmount = new BigDecimal(editText.getText().toString());
                }
                else {
                    displayError(editText, "Inappropriate format!");
                    return;
                }


                editText = (EditText) findViewById(R.id.editTextFuelUnitCost);
                BigDecimal fuelUnitCost = null;
                if (editText.getText().toString().matches("^\\d+\\.\\d{1}$")) {
                    // "...numeric to 1 decimal place..."
                    fuelUnitCost = new BigDecimal(editText.getText().toString());
                }
                else {
                    displayError(editText, "Inappropriate format!");
                    return;
                }


                editText = (EditText) findViewById(R.id.editTextOdometerReading);
                BigDecimal odometerReading = null;
                if (editText.getText().toString().matches("^\\d+\\.\\d{1}$")) {
                    // "...km, numeric to 1 decimal place..."
                    odometerReading = new BigDecimal(editText.getText().toString());
                }
                else {
                    displayError(editText, "Inappropriate format!");
                    return;
                }


                BigDecimal fuelCost = fuelAmount.multiply(fuelUnitCost).setScale(2, RoundingMode.CEILING);
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

