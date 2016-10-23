package com.example.root.greapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by root on 10/2/16.
 */
public class MyDatabase  extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "vocab.db";
    private static final int DATABASE_VERSION = 1;
    private SQLiteDatabase db = getReadableDatabase();

    public MyDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public Cursor getWords() {


        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String [] sqlSelect = {"id", "word", "meaning"};
        String sqlTables = "words";

        qb.setTables(sqlTables);
        Cursor c = qb.query(db, sqlSelect, null, null,
                null, null, null);

        c.moveToFirst();
        return c;

    }

    public Cursor getQuizQuestion(){
        Cursor c = db.rawQuery("SELECT id, word, meaning FROM words ORDER BY RANDOM() LIMIT 4", null);
        c.moveToFirst();
        return c;

    }
}
