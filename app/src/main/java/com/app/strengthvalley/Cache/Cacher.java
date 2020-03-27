package com.app.strengthvalley.Cache;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Cacher extends SQLiteOpenHelper {

    public Cacher(@Nullable Context context) {
        super(context, "cache.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
         db.execSQL("CREATE TABLE USERS("+"ID PRIMARY KEY AUTOINCREMENT," +
                 "FIRST_NAME," + "LAST_NAME," + "USERNAME," +
                 "GENDER," +
                 "WEIGHT DECIMAL,"+
                 "BIRTH_DATE DATE," +
                 "CREATION_DATE DATE" +
                 ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
