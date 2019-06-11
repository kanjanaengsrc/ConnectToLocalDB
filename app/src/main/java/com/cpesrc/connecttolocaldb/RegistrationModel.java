package com.cpesrc.connecttolocaldb;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class RegistrationModel {
    private DatabaseHelper dbHelper;
    private SQLiteDatabase database;
    private Context context;

    public RegistrationModel(Context c){
        context = c;
    }
    public RegistrationModel open() throws SQLException{
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }
    public void close(){
        dbHelper.close();
    }
    /*INSERT INTO Users (prefix ,fullname, studentid, major, birthdate,  note)
    VALUES("Miss","Kanjana Eiamsaard","473030000","Computer Engineering","20/10/2000","Hello exceed 2019")*/
    public void insert(String prefix, String fullname, String studentid, String major, String birthdate, String note){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.prefix, prefix);
        contentValues.put(DatabaseHelper.fullname,fullname);
        contentValues.put(DatabaseHelper.studentid,studentid);
        contentValues.put(DatabaseHelper.major,major);
        contentValues.put(DatabaseHelper.birthdate,birthdate);
        contentValues.put(DatabaseHelper.note,note);
        database.insert(DatabaseHelper.TB_NAME,null,contentValues);
    }
}
