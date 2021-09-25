package com.example.log;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DBmain extends SQLiteOpenHelper {

    private Context context; //added
    private static final String DATABASE_NAME = "CentralPerkR.db";//added
    private static final int DATABASE_VERSION = 1;//added

    //event
    private static final String TABLE_NAME_EVENT = "my_events";
    private static final String COLUMN_ID = "event_id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_PHONENO = "phoneNo";
    private static final String COLUMN_NOGUESTS = "noGuests";
    private static final String COLUMN_EVENTDATE = "eventDate";
    private static final String COLUMN_EVENTTYPE = "eventType";
    private static final String COLUMN_NOOFROOMS= "roomNo";
    private static final String COLUMN_REQUIREMENTS = "requirements";
    //



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

    //private Context context; //added
    //private static final String DATABASE_NAME = "CentralPerkR.db";//added
    //private static final int DATABASE_VERSION = 1;//added

//food
    private static final String TABLE_NAME_FOOD = "food";
    //private static final String COLUMN_ID = "_id"; /////***
    private static final String COLUMN_ORDERS = "orders";
    private static final String COLUMN_REQUEST = "request";
    private static final String COLUMN_ROOM_NO = "room_no";
    private static final String COLUMN_PAYMENT_METHOD = "payment_method";
////

//user
    private static final String TABLE_NAME_USER = "users";
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_PASSWORD = "password";



    DBmain(@Nullable Context context) {
        super(context,DATABASE_NAME, null, DATABASE_VERSION);

    //DBmain(@Nullable Context context) {
        //super(context, DATABASE_NAME, null, DATABASE_VERSION);


    DBmain(@Nullable Context context) {
        super(context,DATABASE_NAME, null, DATABASE_VERSION);


        this.context = context;
    }

    /*public DBmain(@Nullable Context context) {
        super(context, "CentralPerk", null, 1);
    }*/

    @Override
    public void onCreate(SQLiteDatabase db) {

        //db.execSQL("create table users(username text primary key, password text)");


        String queryUser = "CREATE TABLE " + TABLE_NAME_USER +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_USERNAME + " TEXT, " +
                COLUMN_PASSWORD + " TEXT);";

        String queryEvent = "CREATE TABLE " + TABLE_NAME_EVENT +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_EMAIL + " TEXT, " +
                COLUMN_PHONENO + " TEXT, " +
                COLUMN_NOGUESTS+ " INTEGER, " +
                COLUMN_EVENTDATE + " DATE, " +
                COLUMN_EVENTTYPE + " TEXT, " +
                COLUMN_NOOFROOMS + " INTEGER, " +
                COLUMN_REQUIREMENTS + " TEXT); " ;

        db.execSQL(queryUser);
        db.execSQL(queryEvent);


        String queryRoom = "CREATE TABLE " + TABLE_NAME_ROOM +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_DATE + " TEXT, " +
                COLUMN_FACI + " TEXT, " +
                COLUMN_ADULTS + " TEXT, " +
                COLUMN_CHILDREN + " TEXT, " +
                COLUMN_DAYS + " TEXT);";

        //db.execSQL(queryUser);
        db.execSQL(queryRoom);

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
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_EVENT);


   // public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //db.execSQL("drop table if exists users");
        //db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_USER);
       // db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_ROOM);

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { //public void onUpgrade(SQLiteDatabase db, int i, int i1)
        //db.execSQL("drop table if exists users");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_USER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_FOOD);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_ROOM);


        onCreate(db);

    }


    void addEvent(String name, String email, String phoneNo,
                 String noOfGuests, String eventDate, String eventType,
                 String noOfRooms, String requirements) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_NAME, name);
        cv.put(COLUMN_EMAIL, email);
        cv.put(COLUMN_PHONENO, phoneNo);
        cv.put(COLUMN_NOGUESTS, noOfGuests);
        cv.put(COLUMN_EVENTDATE, String.valueOf(eventDate));
        cv.put(COLUMN_EVENTTYPE, eventType);
        cv.put(COLUMN_NOOFROOMS, noOfRooms);
        cv.put(COLUMN_REQUIREMENTS, requirements);

        long result = db.insert(TABLE_NAME_EVENT, null, cv);
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Event placed successfully", Toast.LENGTH_SHORT).show();
        }
    }

    Cursor readAllEvents(){
        String query = "SELECT * FROM " + TABLE_NAME_EVENT;


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


    void updateEvent(String row_id, String name, String email,
                    String phoneNo, String noOfGuests, String eventDate,
                    String eventType, String noOfRooms, String requirements){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_NAME, name);
        cv.put(COLUMN_EMAIL, email);
        cv.put(COLUMN_PHONENO, phoneNo);
        cv.put(COLUMN_NOGUESTS, noOfGuests);
        cv.put(COLUMN_EVENTDATE, eventDate);
        cv.put(COLUMN_EVENTTYPE, eventType);
        cv.put(COLUMN_NOOFROOMS, noOfRooms);
        cv.put(COLUMN_REQUIREMENTS, requirements);

        long result = db.update(TABLE_NAME_EVENT, cv, "event_id=?", new String[]{row_id});

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


    void deleteOneEvent(String row_id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME_EVENT, "event_id=?", new String[]{row_id});

    void deleteOneFood(String row_id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME_FOOD, "_id=?", new String[]{row_id});

        if(result == -1){
            Toast.makeText(context, "Failed to delete", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Successfully deleted", Toast.LENGTH_SHORT).show();

        }

    }


        }

    }


    void deleteAllBookings() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME_ROOM);

    void deleteAllFood(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME_FOOD);


    void deleteAllEvents(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME_EVENT);
    }
}
