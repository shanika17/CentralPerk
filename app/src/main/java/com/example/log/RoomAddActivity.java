package com.example.log;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class RoomAddActivity extends AppCompatActivity {

    EditText date_input,facilities_input, adults_input, children_input, days_input;
    Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_add);

        date_input = findViewById(R.id.date_input);
        facilities_input = findViewById(R.id.facilities_input);
        adults_input = findViewById(R.id.adults_input);
        children_input = findViewById(R.id.children_input);
        days_input = findViewById(R.id.days_input);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(v -> {
            DBmain dBmain = new DBmain(RoomAddActivity.this);
            dBmain.addBooking(date_input.getText().toString().trim(),
                    facilities_input.getText().toString().trim(), adults_input.getText().toString().trim(), children_input.getText().toString().trim(),days_input.getText().toString().trim()
            );
        });
    }
}