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

import java.util.ArrayList;

public class logView extends Activity{

    private ArrayAdapter<Entry<FuelUsageMessage>> adapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_view);
        Log log = new Log();
        listView = (ListView) findViewById(R.id.listView);
        adapter = new ArrayAdapter<Entry<FuelUsageMessage>>(this, R.layout.activity_log_view, log.getLogs());
        listView.setAdapter(adapter);

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
                intent.putExtra("Date", selectedItem.getDate());
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
    }

}

