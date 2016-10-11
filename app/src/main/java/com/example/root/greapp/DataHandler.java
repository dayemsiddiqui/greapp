package com.example.root.greapp;

import android.database.Cursor;

/**
 * Created by root on 10/2/16.
 */
public class DataHandler {
    private String data[][];
    private int rowIndex;
    DataHandler(Cursor words){
        words.moveToFirst();
        rowIndex = 0;
        data = new String[words.getCount()][3];
        for (int i = 0; i < data.length; i++){
            data[i] = new String[]{ words.getString(words.getColumnIndex("id")),
                                    words.getString(words.getColumnIndex("word")),
                                    words.getString(words.getColumnIndex("meaning")),};
            words.moveToNext();
        }
        words.close();
    }

    public String getWord(){
        return data[rowIndex][1];
    }
    public String getMeaning(){
        return data[rowIndex][2];
    }
    public String getMeaning(String word){
        for (int i = 0; i < data.length; i++) {
            if(data[i][1].equals(word)){

                return data[i][2];
            }
        }

        return "Word Not Found";
    }

    public String nextWord(){
        if(rowIndex >= data.length){
            rowIndex = 0;
        }
        int temp = rowIndex;
        rowIndex = rowIndex + 1;
        return data[temp][1];
    }
}
