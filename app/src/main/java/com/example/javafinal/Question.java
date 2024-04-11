package com.example.javafinal;

public class Question {
    public String questionText;
    public String[] options;
    public int correctAnswerIndex;

    Question(String questionText, String[] options, int correctAnswerIndex){
        this.questionText = questionText;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }
}
