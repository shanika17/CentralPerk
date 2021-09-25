package com.example.log;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RoomAddActivity extends AppCompatActivity {

    EditText date_input,facilities_input, adults_input, children_input, days_input;
    Button add_button;
    String date, faci, adults, children, days;

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
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date = date_input.getText().toString().trim();
                faci = facilities_input.getText().toString().trim();
                adults = adults_input.getText().toString().trim();
                children = children_input.getText().toString().trim();
                days = days_input.getText().toString().trim();

                if(date.equals("") || faci.equals("") || adults.equals("") || children.equals("") || days.equals("") || (date.length()>10)){
                    if(date.length() > 10)
                        Toast.makeText(RoomAddActivity.this, "Type date 2020.01.01 like this", Toast.LENGTH_SHORT).show();
                    else
                    Toast.makeText(RoomAddActivity.this, "All fields should be filled. ", Toast.LENGTH_SHORT).show();

            }else{
                    DBmain dBmain = new DBmain(RoomAddActivity.this);
                    dBmain.addBooking(date, faci, adults, children, days);

            }
        }
            /*DBmain dBmain = new DBmain(RoomAddActivity.this);
            dBmain.addBooking(date_input.getText().toString().trim(),
                    facilities_input.getText().toString().trim(), adults_input.getText().toString().trim(), children_input.getText().toString().trim(),days_input.getText().toString().trim()
            );
        }); */
    });
}
}
