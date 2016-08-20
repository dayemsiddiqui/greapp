package com.example.root.greapp;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ScreenSlidePageFragment extends Fragment {

    private int count = 0;

    public ScreenSlidePageFragment(){
        // Required empty public constructor
    }

    public void setCount(int count){
        this.count = count;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_screen_slide_page, container, false);
        TextView view_text = (TextView) rootView.findViewById(R.id.fragment_text);
        view_text.setText("" + this.count);
        ScrollView main_view = (ScrollView) rootView.findViewById(R.id.content);
        String my_color = "#2ecc71";
        switch (this.count){
            case 0:
                my_color = "#2ecc71";
                break;
            case 1:
                my_color = "#e67e22";
                break;
            case 2:
                my_color = "#34495e";
                break;
        }
        main_view.setBackgroundColor(Color.parseColor(my_color));

        return rootView;
    }

}
