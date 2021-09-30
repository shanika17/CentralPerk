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


        add_event_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = name_input.getText().toString().trim();
                String email = email_input.getText().toString().trim();
                String phone = phoneNo_input.getText().toString().trim();
                String noOfGuests = noOfGuests_input.getText().toString().trim();
                String eventDate = eventDate_input.getText().toString().trim();
                String eventType = eventType_input.getText().toString().trim();
                String roomNo = roomNo_input.getText().toString().trim();
                String requirements = requirements_input.getText().toString().trim();

                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                String phonePattern = "^[0-9]{10}$";


                //name
                if (name.isEmpty()) {
                    name_input.setError("Name is required");
                }
                //for email
                else if (!email.matches(emailPattern)) {
                    email_input.setError("Invalid email address");
                }

                //for phone
                else if (!phone.matches(phonePattern)) {
                    phoneNo_input.setError("Invalid phone number");
                }

                //empty fields for each and other validations
                //name
                else if (name.isEmpty()) {
                    name_input.setError("Name is required");
                }

                //email
                else if (email.isEmpty()) {
                    email_input.setError("Email address is required");
                }

                //phone
                else if (phone.isEmpty()) {
                    phoneNo_input.setError("Phone number is required");
                }

                //NoOfGuests
                else if (noOfGuests.isEmpty()) {
                    noOfGuests_input.setError("Number of guests is required");
                }

                //EventDate
                else if (eventDate.isEmpty()) {
                    eventDate_input.setError("Event date is required");
                }

                //EventType
                else if (eventType.isEmpty()) {
                    eventType_input.setError("Event type is required");
                }

                //Room No
                else if (roomNo.isEmpty()) {
                    roomNo_input.setError("Room number is required");
                }

                //or otherwise
                else{
                    DBmain myDatabaseHelper = new DBmain(EventAddActivity.this);
                    myDatabaseHelper.addEvent(name, email,phone, noOfGuests, eventDate,eventType,roomNo,requirements );
                }
            }
        });

    }
}
