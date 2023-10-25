package com.example.elearningapp;

public class QuizModel {

    String Correct;
    String wrong;

    public QuizModel(String correct, String wrong) {
        Correct = correct;
        this.wrong = wrong;
    }

    public String getCorrect() {
        return Correct;
    }

    public void setCorrect(String correct) {
        Correct = correct;
    }

    public String getWrong() {
        return wrong;
    }

    public void setWrong(String wrong) {
        this.wrong = wrong;
    }
}
