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

public class RoomUpdateActivity extends AppCompatActivity {

    EditText date_input,  facilities_input,adults_input,  children_input, days_input ;
    Button update_button, delete_button;

    String id, date, faci,adults ,children, days;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_update);

        date_input = findViewById(R.id.date_input2);
        facilities_input = findViewById(R.id.facilities_input2);
        adults_input = findViewById(R.id.adults_input2);
        children_input = findViewById(R.id.children_input2);
        days_input = findViewById(R.id.days_input2);
        update_button = findViewById(R.id.update_button);
        delete_button = findViewById(R.id.delete_button);

        //First we call this
        getAndSetIntentData();

        //set actionbar title after getAndSetIntentData method
        ActionBar ab = getSupportActionBar();
        if(ab != null) {
            ab.setTitle(date);
        }

        update_button.setOnClickListener(v -> {
            //and only then we call this
            DBmain dBmain = new DBmain(RoomUpdateActivity.this);
            date= date_input.getText().toString().trim();
            faci= facilities_input.getText().toString().trim();
            adults= adults_input.getText().toString().trim();
            children= children_input.getText().toString().trim();
            days= days_input.getText().toString().trim();
            dBmain.updateBooking(id, date, faci, adults,children,days);

        });

        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmDialog();


            }
        });


    }

    void getAndSetIntentData(){
        if(getIntent().hasExtra("id") && getIntent().hasExtra("date") && getIntent().hasExtra("faci") && getIntent().hasExtra("adults") && getIntent().hasExtra("children") && getIntent().hasExtra("days")){
            //Getting data from intent
            id = getIntent().getStringExtra("id");
            date = getIntent().getStringExtra("date");
            faci = getIntent().getStringExtra("faci");
            adults = getIntent().getStringExtra("adults");
            children = getIntent().getStringExtra("children");
            days = getIntent().getStringExtra("days");


            //Setting Intent data
            date_input.setText(date);
            facilities_input.setText(faci);
            adults_input.setText(adults);
            children_input.setText(children);
            days_input.setText(days);

        }else{
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete this booking ?" );
        builder.setMessage("Are you sure you want to delete this booking ? ");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                DBmain myDB = new DBmain(RoomUpdateActivity.this);
                myDB.deleteOneBooking(id);
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