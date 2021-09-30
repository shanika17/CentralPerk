package com.example.log;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EventOfferCalculate extends AppCompatActivity {

    EditText et_event_one, et_event_two, et_event_three, et_event_four;
    Button event_btn_calculate;
    TextView event_answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_offer_calculate);

        et_event_one = findViewById(R.id.event_input_1);
        et_event_two = findViewById(R.id.event_input_2);
        et_event_three = findViewById(R.id.event_input_3);
        et_event_four = findViewById(R.id.event_input_4);

        event_btn_calculate = findViewById(R.id.event_btn_calculate);
        event_answer = findViewById(R.id.event_answer);
    }

    @Override
    protected void onResume() {
        super.onResume();
        event_btn_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateEventDiscount();
            }
        });
    }

    public void calculateEventDiscount() {
        String event_one, event_two, event_three, event_four;
        int Event_one, Event_two, Event_three, Event_four;

        EventCalculation cal = new EventCalculation();

        event_one = et_event_one.getText().toString();
        event_two = et_event_two.getText().toString();
        event_three = et_event_three.getText().toString();
        event_four = et_event_four.getText().toString();

        if(TextUtils.isEmpty(event_one) || TextUtils.isEmpty(event_two) || TextUtils.isEmpty(event_three) || TextUtils.isEmpty(event_four)){ /////////1-4
            Toast.makeText(this, "Enter all package numbers", Toast.LENGTH_SHORT).show();
        }else{

            Event_one = Integer.parseInt(event_one);
            Event_two = Integer.parseInt(event_two);
            Event_three = Integer.parseInt(event_three);
            Event_four = Integer.parseInt(event_four);

            String answer = cal.calculateEventDiscount(Event_one, Event_two, Event_three, Event_four);

            event_answer.setText(answer);
        }

    }
}