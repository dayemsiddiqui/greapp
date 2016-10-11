package com.example.root.greapp;

import android.app.ActionBar;
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

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntro2;
import com.github.paolorotolo.appintro.AppIntroFragment;

public class MainActivity extends AppIntro2 {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Instead of fragments, you can also use our default slide
        // Just set a title, description, background and image. AppIntro will do the rest.


        getSupportActionBar().hide();


        int imageResource = getResources().getIdentifier("@drawable/weather", null, getPackageName());
        addSlide(new ScreenSlidePageFragment().setCount(0));
        addSlide(new ScreenSlidePageFragment().setCount(1));
        addSlide(new ScreenSlidePageFragment().setCount(2));



        // Hide Skip/Done button.
        setProgressButtonEnabled(true);


    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        // Do something when users tap on Skip button.
        startFlashCard();
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        // Do something when users tap on Done button.
        startFlashCard();
    }

    public void startFlashCard(){
        Intent intent = new Intent(MainActivity.this, BaseFlashCard.class);
        startActivity(intent);
    }






}
