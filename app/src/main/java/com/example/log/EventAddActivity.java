package com.example.log;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EventAddActivity extends AppCompatActivity {

    EditText name_input, email_input, phoneNo_input, noOfGuests_input, eventDate_input, eventType_input, roomNo_input, requirements_input;
    Button add_event_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_add);

        name_input = findViewById(R.id.name_input);
        email_input = findViewById(R.id.email_input);
        phoneNo_input = findViewById(R.id.phoneNo_input);
        noOfGuests_input = findViewById(R.id.noOfGuests_input);
        eventDate_input = findViewById(R.id.eventDate_input);
        eventType_input = findViewById(R.id.eventType_input);
        roomNo_input = findViewById(R.id.roomNo_input);
        requirements_input = findViewById(R.id.requirements_input);
        add_event_button = findViewById(R.id.add_event_button);
        add_event_button.setOnClickListener(v -> {
            DBmain myDatabaseHelper = new DBmain(EventAddActivity.this);
            myDatabaseHelper.addEvent(name_input.getText().toString().trim(),
                    email_input.getText().toString().trim(),
                    phoneNo_input.getText().toString().trim(),
                    noOfGuests_input.getText().toString().trim(),
                    eventDate_input.getText().toString().trim(),
                    eventType_input.getText().toString().trim(),
                    roomNo_input.getText().toString().trim(),
                    requirements_input.getText().toString().trim());
        });
    }
}
