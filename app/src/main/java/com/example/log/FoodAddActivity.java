package com.example.log;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



public class FoodAddActivity extends AppCompatActivity {

    EditText orders_input, request_input, room_no_input, payment_method_input;
    Button add_button;
    String orders, request, roomNo, paymentMethod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_add);

        orders_input = findViewById(R.id.orders_input);
        request_input = findViewById(R.id.request_input);
        room_no_input = findViewById(R.id.room_no_input);
        payment_method_input = findViewById(R.id.payment_method_input);
        add_button = findViewById(R.id.add_food_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                orders = orders_input.getText().toString().trim();
                request = request_input.getText().toString().trim();
                roomNo = room_no_input.getText().toString().trim();
                paymentMethod = payment_method_input.getText().toString().trim();

                if(orders.isEmpty())
                    orders_input.setError("Fill Order");
                else if(request.isEmpty())
                    request_input.setError("Fill Request");
                else if(request.length() > 20)
                    request_input.setError("20 characters only");
                else if(roomNo.isEmpty())
                    room_no_input.setError("Fill room No");
                else if(!roomNo.matches("[0-9]+"))
                    room_no_input.setError("Numbers only");
                else if(paymentMethod.isEmpty())
                    payment_method_input.setError("Fill payment method");

                else {
                    DBmain myDB = new DBmain(FoodAddActivity.this);
                    myDB.addFood(orders, request, roomNo, paymentMethod);
                }
            }
        });
    }

}