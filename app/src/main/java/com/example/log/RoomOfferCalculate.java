package com.example.log;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RoomOfferCalculate extends AppCompatActivity {

    EditText et_room_one, et_room_two, et_room_three, et_room_four;
    Button room_btn_calculate;
    TextView room_answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_offer_calculate);
        et_room_one = findViewById(R.id.room_input_1);
        et_room_two = findViewById(R.id.room_input_2);
        et_room_three = findViewById(R.id.room_input_3);
        et_room_four = findViewById(R.id.room_input_4);

        room_btn_calculate = findViewById(R.id.room_btn_calculate);
        room_answer = findViewById(R.id.room_answer);
    }

    @Override
    protected void onResume() {
        super.onResume();
        room_btn_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateRoomDiscount();
            }
        });
    }

    public void calculateRoomDiscount() {
        String room_one, room_two, room_three, room_four;
        int Room_one, Room_two, Room_three, Room_four;

        RoomCalculation cal = new RoomCalculation();

        room_one = et_room_one.getText().toString();
        room_two = et_room_two.getText().toString();
        room_three = et_room_three.getText().toString();
        room_four = et_room_four.getText().toString();

        if(TextUtils.isEmpty(room_one) || TextUtils.isEmpty(room_two) || TextUtils.isEmpty(room_three) || TextUtils.isEmpty(room_four)){ /////////1-4
            Toast.makeText(this, "Enter all package numbers", Toast.LENGTH_SHORT).show();
        }else{

            Room_one = Integer.parseInt(room_one);
            Room_two = Integer.parseInt(room_two);
            Room_three = Integer.parseInt(room_three);
            Room_four = Integer.parseInt(room_four);

            String answer = cal.calculateRoomDiscount(Room_one, Room_two, Room_three, Room_four);

            room_answer.setText(answer);
        }

    }
}