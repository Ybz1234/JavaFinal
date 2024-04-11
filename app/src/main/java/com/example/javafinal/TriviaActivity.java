package com.example.javafinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TriviaActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView questionText;
    private RadioGroup answers;
    private Button nextQuestion;
    private List<Question> questions;
    private int currentQuestionIndex = 0;
    private int[] userAnswers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trivia);
        initializeViews();
        generateQuestion();
        displayCurrentQuestion();
        nextQuestion.setOnClickListener(this);
    }
    private void initializeViews(){
        questionText = findViewById(R.id.question);
        answers = findViewById(R.id.answers);
        nextQuestion = findViewById(R.id.nextBtn);
    }

    private void generateQuestion(){
        questions = new ArrayList<>();
        questions.add(new Question("What's the color of Ferrari?", new String[]{"Green", "Red", "Blue", "Orange"}, 1));
        questions.add(new Question("What's the fastest F1 team?", new String[]{"Mercedes AMG Petronas", "Oracle Red Bull Racing", "Scuderia Ferrari", "McLaren"}, 1));
        questions.add(new Question("Who is the football goat?", new String[]{"Lionel Messi", "Cristiano Ronaldo", "Johan Cruyff", "Diego Armando Maradona"}, 0));
        questions.add(new Question("Who is the basketball goat?", new String[]{"LeBron James", "Kobe Bryant", "Michael Jordan", "Kevin Durant"}, 2));
        questions.add(new Question("Which country has the most people?", new String[]{"Russia", "China", "India", "USA"}, 2));
        questions.add(new Question("Who won the FIFA world cup 2010?", new String[]{"France", "Argentina", "Germany", "Spain"}, 3));
        questions.add(new Question("What is the capital city of Italy?", new String[]{"Milano", "Napoli", "Roma", "Venezia"}, 2));
        questions.add(new Question("3 + 3 * 3 = ", new String[]{"18", "27", "12", "9"}, 2));
        questions.add(new Question("Programming languange used for react development:", new String[]{"C++", "Java", "C#", "JavaScript"}, 3));
        questions.add(new Question("Which of the following planets is known as the \"Red Planet\"?", new String[]{"Jupiter", "Mars", "Saturn", "Venus"}, 1));
        userAnswers = new int[questions.size()];
        Arrays.fill(userAnswers, -1);
    }

    private void displayCurrentQuestion(){
        Question currentQuestion = questions.get(currentQuestionIndex);
        questionText.setText(currentQuestion.questionText);
        answers.removeAllViews();
        for(int i = 0; i < currentQuestion.options.length; i++){
            RadioButton rb = new RadioButton(this);
            rb.setId(View.generateViewId());
            rb.setText(currentQuestion.options[i]);
            answers.addView(rb);
            if (userAnswers[currentQuestionIndex] == i){
                answers.check(rb.getId());
            }
        }
    }

    private void handleNextQuestion(){
        int selectedRadioButtonId = answers.getCheckedRadioButtonId();
        View radioButton = answers.findViewById(selectedRadioButtonId);
        int index = answers.indexOfChild(radioButton);
        userAnswers[currentQuestionIndex] = index;
        currentQuestionIndex++;
        if(currentQuestionIndex < questions.size()){
            displayCurrentQuestion();
        }
        else{
            showResults();
        }
    }

    private void showResults(){
        int score = 0;
        for (int i = 0; i < questions.size(); i++){
            if(userAnswers[i] == questions.get(i).correctAnswerIndex){
                score++;
            }
        }
        Toast.makeText(this, "Congratulations, score: " + score + '/' + questions.size(), Toast.LENGTH_SHORT).show();
    }

    public void onClick(View v){
        if (v.getId() == R.id.nextBtn){
            handleNextQuestion();
        }
    }
}