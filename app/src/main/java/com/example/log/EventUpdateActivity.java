package com.example.log;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EventUpdateActivity extends AppCompatActivity {


    EditText name_input;
    EditText email_input;
    EditText phoneNo_input;
    EditText noOfGuests_input;
    EditText eventDate_input;
    EditText eventType_input;
    EditText roomNo_input;
    EditText requirements_input;

    Button update_event_button, delete_event_button;

    String event_id, name, email, phoneNo, noOfGuests, eventDate, eventType, roomNo, requirements;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_update);

        name_input = findViewById(R.id.name_input2);
        email_input = findViewById(R.id.email_input2);
        phoneNo_input = findViewById(R.id.phoneNo_input2);
        noOfGuests_input = findViewById(R.id.noOfGuests_input2);
        eventDate_input = findViewById(R.id.eventDate_input2);
        eventType_input = findViewById(R.id.eventType_input2);
        roomNo_input = findViewById(R.id.roomNo_input2);
        requirements_input = findViewById(R.id.requirements_input2);
        update_event_button = findViewById(R.id.update_event_button);
        delete_event_button = findViewById(R.id.delete_event_button);

        //First we call this
        getAndSetIntentData();

        //set actionbar title after getAndSetIntentData method
        ActionBar ab = getSupportActionBar();
        if(ab != null) {
            ab.setTitle(eventType);
        }

        update_event_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DBmain myDatabaseHelper = new DBmain(EventUpdateActivity.this);
                name = name_input.getText().toString().trim();
                email = email_input.getText().toString().trim();
                phoneNo = phoneNo_input.getText().toString().trim();
                noOfGuests = noOfGuests_input.getText().toString().trim();
                eventDate = eventDate_input.getText().toString().trim();
                eventType = eventType_input.getText().toString().trim();
                roomNo = roomNo_input.getText().toString().trim();
                requirements = requirements_input.getText().toString().trim();

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
                else if (!phoneNo.matches(phonePattern)) {
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
                else if (phoneNo.isEmpty()) {
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
                else {
                    myDatabaseHelper.updateEvent(event_id, name, email, phoneNo, noOfGuests, eventDate, eventType, roomNo, requirements);
                }
            }
        });

        delete_event_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmDialog();


            }
        });


    }

    void getAndSetIntentData(){
        if(getIntent().hasExtra("event_id") && getIntent().hasExtra("name") && getIntent().hasExtra("email")
                && getIntent().hasExtra("phoneNo") && getIntent().hasExtra("noOfGuests")
                && getIntent().hasExtra("eventDate") && getIntent().hasExtra("eventType")
                && getIntent().hasExtra("roomNo") && getIntent().hasExtra("requirements")){
            //Getting data from intent
            event_id = getIntent().getStringExtra("event_id");
            name = getIntent().getStringExtra("name");
            email = getIntent().getStringExtra("email");
            phoneNo = getIntent().getStringExtra("phoneNo");
            noOfGuests = getIntent().getStringExtra("noOfGuests");
            eventDate = getIntent().getStringExtra("eventDate");
            eventType = getIntent().getStringExtra("eventType");
            roomNo = getIntent().getStringExtra("roomNo");
            requirements = getIntent().getStringExtra("requirements");

            //Setting Intent data
            name_input.setText(name);
            email_input.setText(email);
            phoneNo_input.setText(phoneNo);
            noOfGuests_input.setText(noOfGuests);
            eventDate_input.setText(eventDate);
            eventType_input.setText(eventType);
            roomNo_input.setText(roomNo);
            requirements_input.setText(requirements);


        }else{
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + eventType + "_" + eventDate + " ?");
        builder.setMessage("Are you sure you want to delete " +  eventType + "_" + eventDate  + " ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                DBmain myDB = new DBmain(EventUpdateActivity.this);
                myDB.deleteOneEvent(event_id);
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
