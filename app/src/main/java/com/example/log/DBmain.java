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

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { //public void onUpgrade(SQLiteDatabase db, int i, int i1)
        //db.execSQL("drop table if exists users");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_USER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_EVENT);
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
        if(result == -1){
            Toast.makeText(context, "Failed to update", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Successfully updated", Toast.LENGTH_SHORT).show();
        }
    }

    void deleteOneEvent(String row_id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME_EVENT, "event_id=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Failed to delete", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Successfully deleted", Toast.LENGTH_SHORT).show();
        }

    }

    void deleteAllEvents(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME_EVENT);
    }
}
