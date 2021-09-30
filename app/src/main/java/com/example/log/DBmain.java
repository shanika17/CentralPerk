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

//food
    private static final String TABLE_NAME_FOOD = "food";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_ORDERS = "orders";
    private static final String COLUMN_REQUEST = "request";
    private static final String COLUMN_ROOM_NO = "room_no";
    private static final String COLUMN_PAYMENT_METHOD = "payment_method";

//user
    private static final String TABLE_NAME_USER = "users";
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_PASSWORD = "password";


    DBmain(@Nullable Context context) {
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //db.execSQL("create table users(username text primary key, password text)");


        String queryUser = "CREATE TABLE " + TABLE_NAME_USER +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_USERNAME + " TEXT, " +
                COLUMN_PASSWORD + " TEXT);";

        String queryFood = "CREATE TABLE " + TABLE_NAME_FOOD +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_ORDERS + " TEXT, " +
                COLUMN_REQUEST + " TEXT, " +
                COLUMN_ROOM_NO + " TEXT, " +
                COLUMN_PAYMENT_METHOD + " TEXT);";

        db.execSQL(queryUser);
        db.execSQL(queryFood);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { //public void onUpgrade(SQLiteDatabase db, int i, int i1)
        //db.execSQL("drop table if exists users");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_USER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_FOOD);
        onCreate(db);

    }

    void addFood(String orders, String request, String room_no, String payment_method){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_ORDERS, orders);
        cv.put(COLUMN_REQUEST, request);
        cv.put(COLUMN_ROOM_NO, room_no);
        cv.put(COLUMN_PAYMENT_METHOD, payment_method);

        long result = db.insert(TABLE_NAME_FOOD, null, cv);
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Order placed successfully", Toast.LENGTH_SHORT).show();
        }
    }

    Cursor readAllFood(){
        String query = "SELECT * FROM " + TABLE_NAME_FOOD;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }

        return cursor;
    }

    void updateFood(String row_id, String orders, String request, String room_no, String payment_method){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_ORDERS, orders);
        cv.put(COLUMN_REQUEST, request);
        cv.put(COLUMN_ROOM_NO, room_no);
        cv.put(COLUMN_PAYMENT_METHOD, payment_method);

        long result = db.update(TABLE_NAME_FOOD, cv, "_id=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Failed to update", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Successfully updated", Toast.LENGTH_SHORT).show();
        }
    }

    void deleteOneFood(String row_id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME_FOOD, "_id=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Failed to delete", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Successfully deleted", Toast.LENGTH_SHORT).show();
        }

    }

    void deleteAllFood(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME_FOOD);
    }
}
