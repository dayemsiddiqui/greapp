package com.example.root.greapp;

import android.app.Activity;
import android.database.Cursor;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class QuizCorner extends Activity {
    private String word;
    private String correct_answer;
    private String []answers = new String[4];
    private String user_answer = "";
    //Flag to check whether the user has already answered the question or not
    private boolean answered = false;
    private int [] options =  new int[4];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_corner);
        initialize();

        setQuestion();

        Button check = (Button) findViewById(R.id.check);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!answered){
                    handleCheck(view);
                    answered = true;
                }else{
                    setQuestion();
                    answered =false;
                }
            }
        });


    }

    public void setQuestion(){
        MyDatabase db  = new MyDatabase(QuizCorner.this);
        Cursor words = db.getQuizQuestion();
        TextView question_text = (TextView) findViewById(R.id.question_text);
        RadioButton rb;
        disableCheck();
        words.moveToFirst();
        word = words.getString(words.getColumnIndex("word"));
        correct_answer = words.getString(words.getColumnIndex("meaning"));
        question_text.setText(word + " means:");
        for (int i = 0; i < 4; i++){
            answers[i] = words.getString(words.getColumnIndex("meaning"));
            words.moveToNext();
        }
        answers = randomizeArray(answers);
        for (int i = 0; i < 4; i++){
            rb = (RadioButton) findViewById(options[i]);
            rb.setText(answers[i]);
        }

    }

    public void buttonOnClick(View view)
    {
        if(answered){
            return;
        }
        RadioButton rb;
        resetOptions();
        enableCheck();
        rb = (RadioButton) view;
        rb.setChecked(true);
        view.setBackgroundColor(Color.parseColor("#0aa6f0"));
        ((RadioButton) view).setTextColor(Color.WHITE);
        user_answer = ((RadioButton) view).getText().toString();

    }





    /*
    ===========================================
    * All the helper methods can be found below
    ===========================================
    * */

    public static String [] randomizeArray(String[] array){
        Random rgen = new Random();  // Random number generator

        for (int i=0; i<array.length; i++) {
            int randomPosition = rgen.nextInt(array.length);
            String temp = array[i];
            array[i] = array[randomPosition];
            array[randomPosition] = temp;
        }

        return array;
    }

    private void handleCheck(View view){

        if(user_answer.equals(correct_answer)){
            //setQuestion();

        }else {
            view.setBackgroundColor(Color.parseColor("#e74c3c"));
//            ((Button)view).setText("Wrong Answer");
        }
        ((Button)view).setText("Continue");

    }

    private void initialize(){
        options[0] = R.id.radio1;
        options[1] = R.id.radio2;
        options[2] = R.id.radio3;
        options[3] = R.id.radio4;
    }

    private void resetOptions(){
        RadioButton rb;
        for (int i=0; i < 4; i++){
            rb = (RadioButton) findViewById(options[i]);
            rb.setChecked(false);
            rb.setBackgroundColor(Color.WHITE);
            rb.setTextColor(Color.BLACK);
        }
    }

    private void disableCheck(){
        Button check = (Button) findViewById(R.id.check);
        check.setText("Check");
        check.setClickable(false);
        check.setBackgroundColor(Color.parseColor("#e2e2e2"));
        check.setTextColor(Color.parseColor("#a9a9a9"));
    }

    private void enableCheck(){
        Button check = (Button) findViewById(R.id.check);
        check.setClickable(true);
        check.setBackgroundColor(Color.parseColor("#77c924"));
        check.setTextColor(Color.WHITE);
    }
}
