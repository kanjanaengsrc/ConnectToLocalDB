package com.cpesrc.connecttolocaldb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    //Database configuration
    private static final String DB_NAME = "Registration.db";
    private static final int DB_VERSION = 1;
    private static final String TB_NAME = "Users";

    //Table schema
    private static final String uid = "uid";
    private static final String prefix = "prefix";
    private static final String fullname = "fullname";
    private static final String studentid = "studentid";
    private static final String major = "major";
    private static final String birthdate = "birthdate";
    private static final String note = "note";

/*    CREATE TABLE Users (
      uid INTEGER PRIMARY KEY,
      prefix text NULL,
      fullname text NULL,
      studentid text NULL,
      major text NULL,
      birthdate text NULL,
      note text NULL
    )*/
    //create table query
    public final String create_sql = "CREATE TABLE " + TB_NAME +
            "(" +
            uid + " integer primary key," +
            prefix + " text, " +
            fullname + " text, " +
            studentid + " text, " +
            major + " text, " +
            birthdate + " text, " +
            note + " text " +
            ")";

    public DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, Integer version) {
        super(context, DB_NAME, null, DB_VERSION);
        SQLiteDatabase db = this.getReadableDatabase();
        db.beginTransaction();
    }

    @Override
    public void onCreate(SQLiteDatabase db) { //it's called when there is no db and the app needs one.
        Log.d("QUERY",create_sql);
        db.execSQL(create_sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TB_NAME);
        onCreate(db);
    }
}
