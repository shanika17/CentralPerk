package com.example.log;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Button btn_room = findViewById(R.id.btn_room);
        btn_room.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),RoomActivity.class);
                v.getContext().startActivity(intent);
            }
        });

        Button btn_event = findViewById(R.id.btn_event);
        btn_event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),EventActivity.class);
                v.getContext().startActivity(intent);
            }
        });

        Button btn_food = findViewById(R.id.btn_food);
        btn_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),FoodActivity.class);
                v.getContext().startActivity(intent);
            }
        });

        Button btn_spa = findViewById(R.id.btn_spa);
        btn_spa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),SpaActivity.class);
                v.getContext().startActivity(intent);
            }
        });

        Button btn_calc = findViewById(R.id.btn_calc);
        btn_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),OfferActivity.class);
                v.getContext().startActivity(intent);
            }
        });
    }

}