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

        db.execSQL("CREATE TABLE USER("+"ID BIGINT PRIMARY KEY AUTOINCREMENT," +
                 "FIRST_NAME," + "LAST_NAME," + "USERNAME," +
                 "GENDER," +
                 "WEIGHT DECIMAL,"+
                 "BIRTH_DATE DATE," +
                 "CREATION_DATE DATE" +
                 ")");

        db.execSQL("CREATE TABLE EXERCISE("+"ID BIGINT PRIMARY KEY AUTOINCREMENT," +
                "NAME," +
                "TYPE,"+
                "MUSCLE_CATEGORY,"+
                "CREATION_DATE DATE" +
                ")");

        db.execSQL("CREATE TABLE MUSCELE_CATEGORY("+"ID BIGINT PRIMARY KEY AUTOINCREMENT," +
                "EID BIGINT," +
                "MUSCLE_CATEGORY," +
                "FOREIGN KEY (EID) REFERENCES EXERCISE(ID)" +
                ")");

        db.execSQL("CREATE TABLE DUMBELL("+"ID BIGINT PRIMARY KEY AUTOINCREMENT," +
                "WEIGHT DECIMAL"+
                ")");

        db.execSQL("CREATE TABLE BARBELL("+"ID BIGINT PRIMARY KEY AUTOINCREMENT," +
                "NAME," +
                "WEIGHT DECIMAL"+
                ")");

        db.execSQL("CREATE TABLE PLATE("+"ID BIGINT PRIMARY KEY AUTOINCREMENT," +
                "WEIGHT DECIMAL"+
                ")");

        db.execSQL("CREATE TABLE WORKOUT("+"ID BIGINT PRIMARY KEY AUTOINCREMENT," +
                "NAME," +
                "UID BIGINT," +
                "TOTAL_VOLUME DECIMAL," +
                "PR_COUNT INTEGER," +
                "START_DATE DATETIME," +
                "END_DATE DATETIME,"+
                "FOREIGN KEY (UID) REFERENCES USER(ID)" +
                ")");

        db.execSQL("CREATE TABLE WORKOUT_EXERCISE("+"ID BIGINT PRIMARY KEY AUTOINCREMENT," +
                "NAME," +
                "EID BIGINT," +
                "WID BIGINT," +
                "TOTAL_VOLUME DECIMAL," +
                "PR_COUNT INTEGER," +
                "START_DATE DATETIME," +
                "END_DATE DATETIME,"+
                "E1RM DECIMAL,"+
                "E1RM_POSITION INTEGER,"+
                "E_ORDER INTEGER,"+
                "COMMENT TEXT,"+
                "FOREIGN KEY (UID) REFERENCES USER(ID)," +
                "FOREIGN KEY (WID) REFERENCES WORKOUT(ID)" +
                ")");

        db.execSQL("CREATE TABLE WORKOUT_EXERCISE_SET("+"ID BIGINT PRIMARY KEY AUTOINCREMENT," +
                "WEID BIGINT," +
                "VOLUME DECIMAL," +
                "PR BOOLEAN," +
                "WEIGHT DECIMAL," +
                "REPS INTEGER," +
                "E1RM DECIMAL," +
                "COMMENT TEXT," +
                "STATUS," +
                "FOREIGN KEY (WEID) REFERENCES WORKOUT_EXERCISE(ID)" +
                ")");

        db.execSQL("CREATE TABLE WORKOUT_SET_DUMBELL("+"ID BIGINT PRIMARY KEY AUTOINCREMENT," +
                "WESID BIGINT," +
                "DID BIGINT," +
                "WEIGHT DECIMAL," +
                "FOREIGN KEY (WESID) REFERENCES WORKOUT_EXERCISE_SET(ID)," +
                "FOREIGN KEY (DID) REFERENCES DUMBELL(ID)" +
                ")");

        db.execSQL("CREATE TABLE WORKOUT_SET_BARBELL("+"ID BIGINT PRIMARY KEY AUTOINCREMENT," +
                "WESID BIGINT," +
                "BID BIGINT," +
                "WEIGHT DECIMAL," +
                "FOREIGN KEY (WESID) REFERENCES WORKOUT_EXERCISE_SET(ID)," +
                "FOREIGN KEY (BID) REFERENCES BARBELL(ID)" +
                ")");

        db.execSQL("CREATE TABLE WORKOUT_SET_PLATES("+"ID BIGINT PRIMARY KEY AUTOINCREMENT," +
                "WESID BIGINT," +
                "PID BIGINT," +
                "WEIGHT DECIMAL," +
                "FOREIGN KEY (WESID) REFERENCES WORKOUT_EXERCISE_SET(ID)," +
                "FOREIGN KEY (PID) REFERENCES PLATE(ID)" +
                ")");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
