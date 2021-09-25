package com.example.log;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class EventActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton add_event_button;
    ImageView empty_imageview;
    TextView no_data;

    DBmain myDatabaseHelper;
    ArrayList<String> event_id, name, email, phoneNo, noOfGuests, eventDate, eventType, noOfRooms, requirements;
    EventCustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        recyclerView = findViewById(R.id.recyclerView);
        empty_imageview = findViewById(R.id.empty_imageview);
        add_event_button = findViewById(R.id.add_event_button);
        no_data = findViewById(R.id.no_data);
        add_event_button.setOnClickListener((v -> {
            Intent intent = new Intent(EventActivity.this, EventAddActivity.class);
            startActivity(intent);
        }));

        myDatabaseHelper = new DBmain(EventActivity.this);
        event_id = new ArrayList<>();
        name = new ArrayList<>();
        email = new ArrayList<>();
        phoneNo = new ArrayList<>();
        noOfGuests = new ArrayList<>();
        eventDate = new ArrayList<>();
        eventType = new ArrayList<>();
        noOfRooms = new ArrayList<>();
        requirements = new ArrayList<>();

        storeDataInArray();

        //this**
        customAdapter = new EventCustomAdapter(EventActivity.this, this, event_id, name, email, phoneNo, noOfGuests, eventDate, eventType, noOfRooms, requirements);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(EventActivity.this));

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1) {
            recreate();
        }

    }

    void storeDataInArray() {
        Cursor cursor = myDatabaseHelper.readAllEvents();
        if(cursor.getCount() == 0) {
            empty_imageview.setVisibility(View.VISIBLE);
            no_data.setVisibility(View.VISIBLE);
        }else{
            while (cursor.moveToNext()){
                event_id.add(cursor.getString(0));
                name.add(cursor.getString(1));
                email.add(cursor.getString(2));
                phoneNo.add(cursor.getString(3));
                noOfGuests.add(cursor.getString(4));
                eventDate.add(cursor.getString(5));
                eventType.add(cursor.getString(6));
                noOfRooms.add(cursor.getString(7));
                requirements.add(cursor.getString(8));


            }
            empty_imageview.setVisibility(View.GONE);
            no_data.setVisibility(View.GONE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.event_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.delete_all){
            //Toast.makeText(this, "Delete", Toast.LENGTH_SHORT).show();
            confirmDialog();

        }
        return super.onOptionsItemSelected(item);
    }


    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete All?");
        builder.setMessage("Are you sure you want to delete all Data?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                DBmain myDB = new DBmain(EventActivity.this);
                myDB.deleteAllEvents();
                //Refresh activity
                Intent intent = new Intent(EventActivity.this, EventActivity.class);
                startActivity(intent);
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }


}