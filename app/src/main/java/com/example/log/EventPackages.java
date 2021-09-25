package com.example.log;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EventPackages extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_packages);

        Button event_list_button = findViewById(R.id.event_list_button);
        event_list_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),EventActivity.class);
                v.getContext().startActivity(intent);
            }
        });

        Button add_event_packages_event = findViewById(R.id.add_event_packages_event);
        add_event_packages_event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),EventAddActivity.class);
                v.getContext().startActivity(intent);
            }
        });


    }


}