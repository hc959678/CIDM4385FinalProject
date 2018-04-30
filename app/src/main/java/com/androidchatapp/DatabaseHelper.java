package com.androidchatapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "messagesManager.db";
    private static final String TABLE_PROFILE = "profile";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_USERID = "userid";
    private static final String COLUMN_PASS = "pass";

    private static final String TABLE_MESSAGES = "messages";
    private static final String COLUMN_MESSAGE = "message";
    private static final String COLUMN_STATUS = "status";

    SQLiteDatabase db;

    private static final String CREATE_PROFILE_TABLE = "create table profile (id integer primary key not null , " +
    "userid text not null , pass text not null);";

    private static final String CREATE_TABLE_MESSAGES = "create table messages (id integer primary key not null , " +
    "userid text not null , message text not null , status text not null);";

    public DatabaseHelper(Context context){
        super(context , DATABASE_NAME , null , DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_PROFILE_TABLE);
        db.execSQL(CREATE_TABLE_MESSAGES);
    }

    public void insertProfile(Profile p){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "select * from profile";
        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount();

        values.put(COLUMN_ID, count);
        values.put(COLUMN_USERID , p.getUserid());
        values.put(COLUMN_PASS , p.getPass());

        db.insert(TABLE_PROFILE , null , values);
        db.close();
    }

    public void insertMessagesDb(MessagesDb mdb){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "select * from messages";
        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount();

        values.put(COLUMN_ID, count);
        values.put(COLUMN_USERID, mdb.getUserid());
        values.put(COLUMN_MESSAGE , mdb.getMessage());
        values.put(COLUMN_STATUS , mdb.getStatus());

        db.insert(TABLE_MESSAGES , null , values);
        db.close();
    }

    public String searchPass(String userid){
        db = this.getReadableDatabase();
        String query = "select userid, pass from "+TABLE_PROFILE;
        Cursor cursor = db.rawQuery(query, null);
        String a , b;
        b = "not found";
        if(cursor.moveToFirst()){
            do{
                a = cursor.getString(0);


                if(a.equals(userid)){
                    b = cursor.getString(1);
                    break;
                }
            }
            while(cursor.moveToNext());
        }
        return b;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PROFILE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MESSAGES);
        onCreate(db);
    }
}
