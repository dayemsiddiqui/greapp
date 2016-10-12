package com.example.root.greapp;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntro2;
import com.github.paolorotolo.appintro.AppIntroFragment;

public class MainActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);
        // Instead of fragments, you can also use our default slide
        // Just set a title, description, background and image. AppIntro will do the rest.


//        getSupportActionBar().hide();
//
        Button start_flashcard = (Button) findViewById(R.id.start_flashcard);
        Button quiz_corner = (Button) findViewById(R.id.start_quiz);

        start_flashcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startFlashCard();
            }
        });

        quiz_corner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startQuizCorner();
            }
        });



    }



    public void startFlashCard(){
        Intent intent = new Intent(MainActivity.this, BaseFlashCard.class);
        startActivity(intent);
    }

    public void startQuizCorner(){
        Intent intent = new Intent(MainActivity.this, QuizCorner.class);
        startActivity(intent);
    }




}
