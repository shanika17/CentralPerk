package com.example.log;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FoodOfferCalculate extends AppCompatActivity {

    EditText et_food_one, et_food_two, et_food_three;
    Button food_btn_calculate;
    TextView food_answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_offer_calculate);
        et_food_one = findViewById(R.id.food_input_1);
        et_food_two = findViewById(R.id.food_input_2);
        et_food_three = findViewById(R.id.food_input_3);

        food_btn_calculate = findViewById(R.id.food_btn_calculate);
        food_answer = findViewById(R.id.food_answer);


        ///
    }

    @Override
    protected void onResume() {
        super.onResume();
        food_btn_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateFoodDiscount();
            }
        });
    }

    public void calculateFoodDiscount() {
        String food_one, food_two, food_three;
        int Food_one, Food_two, Food_three;

        FoodCalculation cal = new FoodCalculation();

        food_one = et_food_one.getText().toString();
        food_two = et_food_two.getText().toString();
        food_three = et_food_three.getText().toString();

        if(TextUtils.isEmpty(food_one) || TextUtils.isEmpty(food_two) || TextUtils.isEmpty(food_three)){
            Toast.makeText(this, "Enter all inputs", Toast.LENGTH_SHORT).show();
        }else{

            Food_one = Integer.parseInt(food_one);
            Food_two = Integer.parseInt(food_two);
            Food_three = Integer.parseInt(food_three);

            String answer = cal.calculateFoodDiscount(Food_one, Food_two, Food_three);

            food_answer.setText(answer);
        }

    }
}