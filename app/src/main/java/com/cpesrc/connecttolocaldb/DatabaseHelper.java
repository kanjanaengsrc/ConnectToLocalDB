package com.cpesrc.connecttolocaldb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "Test.db";
    private static final int DB_VERSION = 1;
    private static final String TB_NAME = "Users";

    private static final String USER_ID = "userID";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String PHOTO_PATH = "photoPath";

    public DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, Integer version) {
        super(context, DB_NAME, null, DB_VERSION);
        SQLiteDatabase db = this.getReadableDatabase();
        db.beginTransaction();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_sql = "CREATE TABLE " + TB_NAME +
                "(" +
                    USER_ID + " integer primary key," +
                    USERNAME + " text, " +
                    PASSWORD + " text, " +
                    PHOTO_PATH + " text" +
                ")";
        Log.d("QUERY",create_sql);
        db.execSQL(create_sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
