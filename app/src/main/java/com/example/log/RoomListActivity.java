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
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class RoomListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton add_button;
    ImageView empty_imageview;
    TextView no_data;

    DBmain dBmain;
    ArrayList<String> room_id, date, room_faci, room_adults, room_children, room_days;
    RoomCustomAdapter roomCustomAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_list);

        recyclerView = findViewById(R.id.recyclerView);
        add_button = findViewById(R.id.add_button);
        empty_imageview = findViewById(R.id.empty_imageview);
        no_data = findViewById(R.id.no_data);
        add_button.setOnClickListener((v -> {
            Intent intent = new Intent(RoomListActivity.this, RoomAddActivity.class);
            startActivity(intent);
        }));

        dBmain = new DBmain(RoomListActivity.this);
        room_id = new ArrayList<>();
        date = new ArrayList<>();
        room_faci = new ArrayList<>();
        room_adults = new ArrayList<>();
        room_children = new ArrayList<>();
        room_days = new ArrayList<>();

        storeDataInArray();

        roomCustomAdapter = new RoomCustomAdapter(RoomListActivity.this,this, room_id, date, room_faci, room_adults, room_children, room_days);
        recyclerView.setAdapter(roomCustomAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(RoomListActivity.this));

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1) {
            recreate();
        }
    }


    void storeDataInArray() {
        Cursor cursor = dBmain.readAllBookings();
        if(cursor.getCount() == 0) {
            empty_imageview.setVisibility(View.VISIBLE);
            no_data.setVisibility(View.VISIBLE);
        }else{
            while (cursor.moveToNext()){
                room_id.add(cursor.getString(0));
                date.add(cursor.getString(1));
                room_faci.add(cursor.getString(2));
                room_adults.add(cursor.getString(3));
                room_children.add(cursor.getString(4));
                room_days.add(cursor.getString(5));
            }
            empty_imageview.setVisibility(View.GONE);
            no_data.setVisibility(View.GONE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.myroom_menu, menu);
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
                DBmain myDB = new DBmain(RoomListActivity.this);
                myDB.deleteAllBookings();
                //Refresh activity
                Intent intent = new Intent(RoomListActivity.this, RoomListActivity.class);
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