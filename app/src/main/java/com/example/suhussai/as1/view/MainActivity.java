package com.example.suhussai.as1.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.suhussai.as1.R;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnViewLog = (Button) findViewById(R.id.btnViewLog);
        Button btnGoToEntryPage = (Button) findViewById(R.id.btnGoToEntryPage);

        btnViewLog.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setResult(RESULT_OK);
                startActivity(new Intent(MainActivity.this, logView.class));
            }
        });

        btnGoToEntryPage.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                setResult(RESULT_OK);
                startActivity(new Intent(MainActivity.this, entry_config.class));
            }
        });

    }

    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
    }


}
