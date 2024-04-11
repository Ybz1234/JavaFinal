package com.example.javafinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class GuessTheNumberActivity extends AppCompatActivity {

    private int secretNumber;
    private int score;
    private int level;
    private EditText editTextGuess;
    private TextView textViewResult;
    private TextView textViewScore;
    private TextView textViewLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess_the_number);
        initializeViews();
        startNewGame();
    }

    private void initializeViews() {
        editTextGuess = findViewById(R.id.editTextGuess);
        textViewResult = findViewById(R.id.textViewResult);
        textViewScore = findViewById(R.id.textViewScore);
        textViewLevel = findViewById(R.id.textViewLevel);
    }

    private void startNewGame() {
        // Reset variables
        score = 0;
        level = 1;
        updateScoreAndLevel();

        // Generate a new secret number
        secretNumber = generateRandomNumber();
    }

    private int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(10 * level) + 1; // Increase range with level
    }

    public void onCheckButtonClick(View view) {
        String guessText = editTextGuess.getText().toString();
        if (!guessText.isEmpty()) {
            int guess = Integer.parseInt(guessText);
            checkGuess(guess);
        } else {
            Toast.makeText(this, "Please enter a number", Toast.LENGTH_SHORT).show();
        }
    }

    private void checkGuess(int guess) {
        if (guess == secretNumber) {
            score += 10;
            level++;
            updateScoreAndLevel();
            textViewResult.setText("Congratulations! You guessed the number.");
            secretNumber = generateRandomNumber(); // Generate new secret number for next level
        } else {
            textViewResult.setText("Sorry, try again.");
        }
    }

    private void updateScoreAndLevel() {
        textViewScore.setText("Score: " + score);
        textViewLevel.setText("Level " + level);
    }
}
