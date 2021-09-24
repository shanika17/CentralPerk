package com.example.log;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RoomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        Button btn_myBookings = findViewById(R.id.btn_myBookings);
        btn_myBookings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),RoomListActivity.class);
                v.getContext().startActivity(intent);
            }
        });

        Button btn_bookRoom = findViewById(R.id.btn_bookRoom);
        btn_bookRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),RoomAddActivity.class);
                v.getContext().startActivity(intent);
            }
        });
    }
}