package com.example.log;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FoodActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        Button btn_orders = findViewById(R.id.btn_orders);
        btn_orders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),FoodList.class);
                view.getContext().startActivity(intent);
            }
        });

        Button btn_addOrder = findViewById(R.id.btn_addOrder);
        btn_addOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),FoodAddActivity.class);
                view.getContext().startActivity(intent);
            }
        });
    }
}