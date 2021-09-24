package com.example.log;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DBmain extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "CentralPerkR.db";
    private static final int DATABASE_VERSION = 1;

    //room
    private static final String TABLE_NAME_ROOM = "rooms";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_DATE = "date";
    private static final String COLUMN_FACI = "room_faci";
    private static final String COLUMN_ADULTS = "room_adults";
    private static final String COLUMN_CHILDREN = "room_children";
    private static final String COLUMN_DAYS = "room_days";

    //user
    private static final String TABLE_NAME_USER = "users";
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_PASSWORD = "password";

    DBmain(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    /*public DBmain(@Nullable Context context) {
        super(context, "CentralPerk", null, 1);
    }*/

    @Override
    public void onCreate(SQLiteDatabase db) {
       // db.execSQL("create table users(username text primary key, password text)");

        String queryUser = "CREATE TABLE " + TABLE_NAME_USER +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_USERNAME + " TEXT, " +
                COLUMN_PASSWORD + " TEXT);";

        String queryRoom = "CREATE TABLE " + TABLE_NAME_ROOM +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_DATE + " TEXT, " +
                COLUMN_FACI + " TEXT, " +
                COLUMN_ADULTS + " TEXT, " +
                COLUMN_CHILDREN + " TEXT, " +
                COLUMN_DAYS + " TEXT);";

        db.execSQL(queryUser);
        db.execSQL(queryRoom);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //db.execSQL("drop table if exists users");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_USER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_ROOM);
        onCreate(db);

    }

    void addBooking(String date,  String faci, String adults, String children, String days) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COLUMN_DATE, date);
        contentValues.put(COLUMN_FACI, faci);
        contentValues.put(COLUMN_ADULTS, adults);
        contentValues.put(COLUMN_CHILDREN, children);
        contentValues.put(COLUMN_DAYS, days);
        long result = db.insert(TABLE_NAME_ROOM,null, contentValues);
        if(result == -1) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Booking added successfully!", Toast.LENGTH_SHORT).show();
        }
    }

    Cursor readAllBookings() {
        String query = "SELECT * FROM " + TABLE_NAME_ROOM;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null) {
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    void updateBooking(String row_id, String date, String faci, String adults, String children, String days){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_DATE, date);
        contentValues.put(COLUMN_FACI, faci);
        contentValues.put(COLUMN_ADULTS, adults);
        contentValues.put(COLUMN_CHILDREN, children);
        contentValues.put(COLUMN_DAYS, days);

        long result = db.update(TABLE_NAME_ROOM, contentValues, "_id=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Failed to Update.", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Successfully Updated.", Toast.LENGTH_SHORT).show();
        }


    }

    void deleteOneBooking(String row_id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME_ROOM, "_id=?", new String[]{row_id});

        if(result == -1){
            Toast.makeText(context, "Failed to Delete.", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Successfully Deleted.", Toast.LENGTH_SHORT).show();
        }

    }

    void deleteAllBookings() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME_ROOM);
    }
}
