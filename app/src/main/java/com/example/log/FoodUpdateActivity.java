package com.example.log;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FoodUpdateActivity extends AppCompatActivity {

    EditText orders_input, request_input, room_no_input, payment_method_input;
    Button update_button, delete_button;

    String foodId, orders, request, roomNo, paymentMethod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_update);

        orders_input = findViewById(R.id.orders_input2);
        request_input = findViewById(R.id.request_input2);
        room_no_input = findViewById(R.id.room_no_input2);
        payment_method_input = findViewById(R.id.payment_method_input2);


        update_button = findViewById(R.id.update_food_button);
        delete_button = findViewById(R.id.delete_food_button);
        //first we call this
        getAndSetIntentData();

        //set actionbar title after getAndSetIntentData method
        ActionBar ab = getSupportActionBar();
        if(ab != null){
            ab.setTitle(orders);
        }

        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBmain myDB = new DBmain(FoodUpdateActivity.this);
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
                    myDB.updateFood(foodId, orders, request, roomNo, paymentMethod);
                }
            }
        });
        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmDialog();
            }
        });
    }

    void getAndSetIntentData(){
        if(getIntent().hasExtra("foodId") && getIntent().hasExtra("orders") &&
                getIntent().hasExtra("request") && getIntent().hasExtra("roomNo") && getIntent().hasExtra("paymentMethod")){
            //getting data from intent
            foodId = getIntent().getStringExtra("foodId");
            orders = getIntent().getStringExtra("orders");
            request = getIntent().getStringExtra("request");
            roomNo = getIntent().getStringExtra("roomNo");
            paymentMethod = getIntent().getStringExtra("paymentMethod");

            //setting intent data
            orders_input.setText(orders);
            request_input.setText(request);
            room_no_input.setText(roomNo);
            payment_method_input.setText(paymentMethod);


        }else{
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }
    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + orders + " ?");
        builder.setMessage("Are you sure you want to delete " + orders + " ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {


                DBmain myDB = new DBmain(FoodUpdateActivity.this);
                myDB.deleteOneFood(foodId);
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }
}