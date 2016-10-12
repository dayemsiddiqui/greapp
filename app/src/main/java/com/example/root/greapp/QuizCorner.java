package com.example.root.greapp;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;

public class QuizCorner extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_corner);

    }

    public void buttonOnClick(View view)
    {
        RadioButton rb;
        Button check = (Button) findViewById(R.id.check);
        rb = (RadioButton) findViewById(R.id.radio1);
        rb.setChecked(false);
        rb.setBackgroundColor(Color.WHITE);
        rb.setTextColor(Color.BLACK);
        rb = (RadioButton) findViewById(R.id.radio2);
        rb.setChecked(false);
        rb.setBackgroundColor(Color.WHITE);
        rb.setTextColor(Color.BLACK);
        rb = (RadioButton) findViewById(R.id.radio3);
        rb.setChecked(false);
        rb.setBackgroundColor(Color.WHITE);
        rb.setTextColor(Color.BLACK);
        rb = (RadioButton) findViewById(R.id.radio4);
        rb.setChecked(false);
        rb.setBackgroundColor(Color.WHITE);
        rb.setTextColor(Color.BLACK);

        rb = (RadioButton) view;
        rb.setChecked(true);



        check.setClickable(true);
        check.setBackgroundColor(Color.parseColor("#77c924"));
        check.setTextColor(Color.WHITE);
        view.setBackgroundColor(Color.parseColor("#0aa6f0"));
        ((RadioButton) view).setTextColor(Color.WHITE);


    }
}
