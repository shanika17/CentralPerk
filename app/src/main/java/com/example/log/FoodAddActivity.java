package com.example.log;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

                ///

                orders = orders_input.getText().toString().trim();
                request = request_input.getText().toString().trim();
                roomNo = room_no_input.getText().toString().trim();
                paymentMethod = payment_method_input.getText().toString().trim();

                if(orders.equals("") || request.equals("") || roomNo.equals("") || paymentMethod.equals("") || (request.length() > 20)){
                    if(request.length() > 20)
                        Toast.makeText(FoodAddActivity.this, "Please limit request to 20 characters", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(FoodAddActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();

                }else{
                    DBmain myDB = new DBmain(FoodAddActivity.this);
                    myDB.addFood(orders, request, roomNo, paymentMethod);
                }
                ///

               /* MyDatabaseHelper myDB = new MyDatabaseHelper(AddActivity.this);
                myDB.addBook(title_input.getText().toString().trim(),
                        author_input.getText().toString().trim(),
                        Integer.valueOf(pages_input.getText().toString().trim()));*/
            }
        });



    }
}