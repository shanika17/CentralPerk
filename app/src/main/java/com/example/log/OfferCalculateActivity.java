package com.example.log;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class OfferCalculateActivity extends AppCompatActivity {

    EditText et_room, et_event, et_spar, et_food;
    Button btn_calculate;
    TextView tv_answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer_claculate);

        et_room = findViewById(R.id.et_room);
        et_event = findViewById(R.id.et_event);
        et_spar = findViewById(R.id.et_spar);
        et_food = findViewById(R.id.et_food);

        btn_calculate = findViewById(R.id.btn_calculate);
        tv_answer = findViewById(R.id.tv_answer);

    }
    @Override
    protected void onResume() {
        super.onResume();
        btn_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateDiscount();
            }
        });
    }

    public void calculateDiscount() {
        String room, event, spar, food;
        int Room, Event, Spar, Food;

        Calculations cal = new Calculations();

        room = et_room.getText().toString();
        event = et_event.getText().toString();
        spar = et_spar.getText().toString();
        food = et_food.getText().toString();

        if(TextUtils.isEmpty(room) || TextUtils.isEmpty(event) || TextUtils.isEmpty(spar) || TextUtils.isEmpty(food)){ /////////1-4
            Toast.makeText(this, "Enter all package numbers", Toast.LENGTH_SHORT).show();
        }else{

            Food = Integer.parseInt(food);
            Event = Integer.parseInt(event);
            Spar = Integer.parseInt(spar);
            Room = Integer.parseInt(room);

            String answer = cal.calculateDiscount(Food, Room, Event, Spar);

            tv_answer.setText(answer);
        }

    }

}