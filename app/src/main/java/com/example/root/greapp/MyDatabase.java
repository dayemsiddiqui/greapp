package com.example.root.greapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.widget.RadioButton;

import com.example.root.greapp.model.Word;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;

/**
 * Created by root on 10/2/16.
 */
public class MyDatabase  extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "vocab.db";
    private static final int DATABASE_VERSION = 1;
    private SQLiteDatabase  db;

    public MyDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public Cursor getWords() {

        db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String [] sqlSelect = {"id", "word", "meaning"};
        String sqlTables = "words";

        qb.setTables(sqlTables);
        Cursor c = qb.query(db, sqlSelect, null, null,
                null, null, null);

        c.moveToFirst();
        db.close();
        return c;

    }

    public Cursor getQuizQuestion(){
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT id, word, meaning FROM words ORDER BY RANDOM() LIMIT 4", null);
        c.moveToFirst();
        db.close();
        return c;
    }

    public ArrayList<Word> getBookmarkedWords(){
        db = getReadableDatabase();
        Cursor words = db.rawQuery("SELECT id, word, meaning FROM words WHERE bookmark=1", null);
        words.moveToFirst();

        ArrayList<Word> words_list = new ArrayList<Word>();

        for (int i = 0; i < words.getCount(); i++){
            words_list.add(new Word(
                    words.getString(words.getColumnIndex("id")),
                    words.getString(words.getColumnIndex("word")),
                    words.getString(words.getColumnIndex("meaning")),
                    true
                    ));
            words.moveToNext();
        }
        db.close();
        return words_list;
    }

    public void bookmarkWord(String word){
        db = getReadableDatabase();
        Cursor words = db.rawQuery("UPDATE words SET bookmark = 1 WHERE word = '"+word+"'", null);
        db.close();
    }
}
