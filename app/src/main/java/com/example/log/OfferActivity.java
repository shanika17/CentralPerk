package com.example.log;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OfferActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer);


        Button btn_eventDiscount = findViewById(R.id.btn_eventDiscount);
        btn_eventDiscount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), EventOfferCalculate.class);
                v.getContext().startActivity(intent);
            }
        });

        Button btn_roomDiscount = findViewById(R.id.btn_roomDiscount);
        btn_roomDiscount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), RoomOfferCalculate.class);
                v.getContext().startActivity(intent);
            }
        });

        Button btn_foodDiscount = findViewById(R.id.btn_foodDiscount);
        btn_foodDiscount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), FoodOfferCalculate.class);
                v.getContext().startActivity(intent);
            }
        });

        Button btn_spaDiscount = findViewById(R.id.btn_spaDiscount);
        btn_spaDiscount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), SpaOfferCalculate.class);
                v.getContext().startActivity(intent);
            }
        });
    }
}