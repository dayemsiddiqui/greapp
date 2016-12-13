package com.example.root.greapp;

import android.content.Context;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.daprlabs.aaron.swipedeck.SwipeDeck;


import java.util.ArrayList;
import java.util.List;

public class BaseFlashCard extends AppCompatActivity {
    ArrayList testData;
    SwipeDeckAdapter adapter;
    SwipeDeck cardStack;
    boolean marked;
    DataHandler datahandle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_flash_card);
        cardStack = (SwipeDeck) findViewById(R.id.swipe_deck);
        Button bookmark = (Button) findViewById(R.id.bookmark);
        getSupportActionBar().hide();
        datahandle = new DataHandler(new MyDatabase(this).getWords());

        testData = new ArrayList<>();
        for(int i = 0; i < 3; i++){
           testData.add(datahandle.nextWord());
        }


        adapter = new SwipeDeckAdapter(testData, this);
        if(cardStack != null){
            cardStack.setAdapter(adapter);
        }


        marked = false;




    }


    @Override
    public boolean onTouchEvent(MotionEvent e) {

        /*This condition adds a new card if the remaining cards is
          less than or equal to 1*/
        if((adapter.getCount() - adapter.getCurrentItem()) <= 1){
            testData.add(datahandle.nextWord());
            adapter.notifyDataSetChanged();
        }
        return true;

    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        onTouchEvent(event);
        return super.dispatchTouchEvent(event);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
    }

    //This is the inner class for SwipeDeck
    public class SwipeDeckAdapter extends BaseAdapter {

        private List<String> data;
        private Context context;
        private int currentItem=-1;
        private boolean meaning = false;
        private int pos;

        public SwipeDeckAdapter(List<String> data, Context context) {
            this.data = data;
            this.context = context;
        }

        public int getCurrentItem(){
            return currentItem;
        }

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Object getItem(int position) {

            return data.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

            View v = convertView;
            currentItem = position;
            if (v == null) {
                LayoutInflater inflater = getLayoutInflater();
                // normally use a viewholder
                v = inflater.inflate(R.layout.mycard, parent, false);
            }


            TextView textView = (TextView) v.findViewById(R.id.sample_text);
            String item = (String)getItem(position);
            pos = position;
            textView.setText(item);

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("Layer type: ", Integer.toString(v.getLayerType()));
                    Log.i("Hardware Accel type:", Integer.toString(View.LAYER_TYPE_HARDWARE));
                    TextView textView = (TextView) v.findViewById(R.id.sample_text);
                    if(!meaning){
                        textView.setText(datahandle.getMeaning(textView.getText().toString()));
                        meaning = true;
                    }else{
                        textView.setText((String)getItem(pos-2));
                        meaning = false;
                    }

                }

            });





            return v;
        }
    }

}

