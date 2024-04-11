package com.example.javafinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SevenBoomActivity extends AppCompatActivity {
    private TextView header;
    private Button numberUp;
    private int clickCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seven_boom);
        initializeViews();
        numberUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCounter++;
                if (clickCounter % 7 == 0 || String.valueOf(clickCounter).contains("7")) {
                    header.setText("Boom");
                } else {
                    header.setText("Click count: " + clickCounter);
                }
            }
        });
    }
    private void initializeViews(){
        header = findViewById(R.id.sevenBoomHeader);
        numberUp = findViewById(R.id.numberUp);
    }
}