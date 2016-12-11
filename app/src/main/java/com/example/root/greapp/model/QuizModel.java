package com.example.root.greapp.model;

/**
 * Created by root on 12/11/16.
 */
public class QuizModel {
    private int score = 0;
    private int correct_answers_count = 0;
    private int wrong_answers_count = 0;

    public void incrementCorrectCount(){
        correct_answers_count++;
    }

    public void incrementWrongCount(){
        wrong_answers_count++;
    }

    public int getScore(){
        this.score = this.correct_answers_count;
        return this.score;
    }

    public int getCorrect_answers_count(){
        return correct_answers_count;
    }

    public int getWrong_answers_count(){
        return wrong_answers_count;
    }

}
