package com.example.suhussai.as1.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.suhussai.as1.R;
import com.example.suhussai.as1.controller.AppController;
import com.example.suhussai.as1.controller.AppControllerHandler;

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

public class logView extends Activity{

    private ListView listView;
    private AppController appController = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_view);
        appController = AppControllerHandler.getAppController(this);
        listView = (ListView) findViewById(R.id.listView);

        Button btnBack = (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setResult(RESULT_OK);
                startActivity(new Intent(logView.this, MainActivity.class));
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                appController.setMessageIDToEdit(listView.getItemAtPosition(position));
                startActivity(new Intent(logView.this, entry_config.class));

            }
        });

    }

    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.list_item, appController.getLogs());
        listView.setAdapter(adapter);
        TextView textView = (TextView) findViewById(R.id.textViewTotalCost);
        appController = AppControllerHandler.getAppController(this);
        textView.setText("Total Cost: $"+Float.toString(appController.getTotalCost()));
    }

}

