package com.example.root.greapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.root.greapp.model.QuizModel;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;

public class QuizReport extends AppCompatActivity {
    public static QuizModel scoreboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_report);
        Button done  = (Button) findViewById(R.id.check);

        initialize();
        setScore();

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuizReport.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }

    private void setScore(){
        TextView score = (TextView) findViewById(R.id.score);
        score.setText("Score: " + scoreboard.getScore());

    }

    private void initialize(){
        PieChartView chart = (PieChartView) findViewById(R.id.chart);
        PieChartData data = new PieChartData();
        List<SliceValue> sliceValues = new ArrayList<SliceValue>();
        SliceValue sliceValue = new SliceValue();
        sliceValue.setLabel(("Wrong Answers " + scoreboard.getWrong_answers_count()).toCharArray());
        sliceValue.setValue(scoreboard.getWrong_answers_count());
        sliceValue.setColor(Color.parseColor("#FF4444"));
        sliceValues.add(sliceValue);
        SliceValue sliceValue2 = new SliceValue();
        sliceValue2.setLabel(("Correct Answers " +  scoreboard.getCorrect_answers_count()).toCharArray());
        sliceValue2.setValue(scoreboard.getCorrect_answers_count());
        sliceValue2.setColor(Color.parseColor("#99CC00"));
        sliceValues.add(sliceValue2);
        data.setHasLabels(true);
        data.setValues(sliceValues);
        chart.setPieChartData(data);
    }
}
