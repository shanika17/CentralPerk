package com.example.log;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SpaOfferCalculate extends AppCompatActivity {

    EditText et_spa_one, et_spa_two, et_spa_three, et_spa_four;
    Button spa_btn_calculate;
    TextView spa_answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spa_offer_calculate);
        et_spa_one = findViewById(R.id.spa_input_1);
        et_spa_two = findViewById(R.id.spa_input_2);
        et_spa_three = findViewById(R.id.spa_input_3);
        et_spa_four = findViewById(R.id.spa_input_4);

        spa_btn_calculate = findViewById(R.id.spa_btn_calculate);
        spa_answer = findViewById(R.id.spa_answer);
    }

    @Override
    protected void onResume() {
        super.onResume();
        spa_btn_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateSpaDiscount();
            }
        });
    }

    public void calculateSpaDiscount() {
        String spa_one, spa_two, spa_three, spa_four;
        int Spa_one, Spa_two, Spa_three, Spa_four;

        SpaCalculation cal = new SpaCalculation();

        spa_one = et_spa_one.getText().toString();
        spa_two = et_spa_two.getText().toString();
        spa_three = et_spa_three.getText().toString();
        spa_four = et_spa_four.getText().toString();

        if(TextUtils.isEmpty(spa_one) || TextUtils.isEmpty(spa_two) || TextUtils.isEmpty(spa_three) || TextUtils.isEmpty(spa_four)){ /////////1-4
            Toast.makeText(this, "Enter all package numbers", Toast.LENGTH_SHORT).show();
        }else{

            Spa_one = Integer.parseInt(spa_one);
            Spa_two = Integer.parseInt(spa_two);
            Spa_three = Integer.parseInt(spa_three);
            Spa_four = Integer.parseInt(spa_four);

            String answer = cal.calculateSpaDiscount(Spa_one, Spa_two, Spa_three, Spa_four);

            spa_answer.setText(answer);
        }

    }
}