package com.example.javafinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button trivia;
    private Button guessTheNumber;
    private Button camera;
    private Button calculator;
    private Button sevenBoom;
    private Button ticTacToe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();
    }
    private void initializeViews(){
        trivia = findViewById(R.id.triviaBtn);
        guessTheNumber = findViewById(R.id.guessBtn);
        camera = findViewById(R.id.cameraBtn);
        calculator = findViewById(R.id.calculatorBtn);
        sevenBoom = findViewById(R.id.sevenBoomBtn);
        ticTacToe = findViewById(R.id.tictactoe);

        trivia.setOnClickListener(this);
        guessTheNumber.setOnClickListener(this);
        camera.setOnClickListener(this);
        calculator.setOnClickListener(this);
        sevenBoom.setOnClickListener(this);
        ticTacToe.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        if (v.getId() == trivia.getId())
            intent = new Intent(MainActivity.this, TriviaActivity.class);
        else if (v.getId() == guessTheNumber.getId())
            intent = new Intent(MainActivity.this, GuessTheNumberActivity.class);
        else if (v.getId() == camera.getId())
            intent = new Intent(MainActivity.this, CameraActivity.class);
        else if (v.getId() == calculator.getId())
            intent = new Intent(MainActivity.this, CalculatorActivity.class);
        else if (v.getId() == sevenBoom.getId())
            intent = new Intent(MainActivity.this, SevenBoomActivity.class);
        else if (v.getId() == ticTacToe.getId())
            intent = new Intent(MainActivity.this, AddPlayers.class);
        else
            return;
        startActivity(intent);
    }
}