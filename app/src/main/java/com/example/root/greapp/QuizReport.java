package com.example.root.greapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;

public class QuizReport extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_report);

        PieChartView chart = (PieChartView) findViewById(R.id.chart);
        PieChartData data = new PieChartData();
        List<SliceValue> sliceValues = new ArrayList<SliceValue>();
        SliceValue sliceValue = new SliceValue();
        sliceValue.setLabel("Correct Answers");
        sliceValue.setValue(5);
        sliceValue.setColor(Color.RED);
        sliceValues.add(sliceValue);
        SliceValue sliceValue2 = new SliceValue();
        sliceValue2.setLabel("Correct Answers");
        sliceValue2.setValue(5);
        sliceValue2.setColor(Color.BLUE);
        sliceValues.add(sliceValue2);
        data.setValues(sliceValues);
        chart.setPieChartData(data);
    }
}
