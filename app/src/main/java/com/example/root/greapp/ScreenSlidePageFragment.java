package com.example.root.greapp;


import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;



/**
 * A simple {@link Fragment} subclass.
 */
public class ScreenSlidePageFragment extends Fragment {

    private int count = 0;

    public ScreenSlidePageFragment(){
        // Required empty public constructor
    }

    public ScreenSlidePageFragment setCount(int count){
        this.count = count;
        return this;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_screen_slide_page, container, false);
        TextView view_text = (TextView) rootView.findViewById(R.id.fragment_text);

        String uri = "@drawable/notepad";


        String title = "";


        LinearLayout main_view = (LinearLayout) rootView.findViewById(R.id.content);
        String my_color = "#2ecc71";


        switch (this.count){
            case 0:
                my_color = "#ff694c";
                uri = "@drawable/notepad";
                title = "GRE Vocab App";
                break;
            case 1:
                my_color = "#FF5E5E";
                uri = "@drawable/timer";
                title = "Time Allocation";
                break;
            case 2:
                my_color = "#76C2AF";
                uri = "@drawable/check";
                title = "Get Started";
                break;
        }
        view_text.setText(title);
        main_view.setBackgroundColor(Color.parseColor(my_color));
        setImage(uri, rootView);
        return rootView;
    }

    private void setImage(String uri, View rootView){
        int imageResource = getResources().getIdentifier(uri, null, getActivity().getPackageName());

        ImageView imageview = (ImageView) rootView.findViewById(R.id.intro_image);
        Drawable res = getResources().getDrawable(imageResource);
        imageview.setImageDrawable(res);
    }

}
