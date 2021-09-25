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


        Button btn_viewDiscount = findViewById(R.id.btn_viewDiscount);
        btn_viewDiscount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), OfferCalculateActivity.class);
                v.getContext().startActivity(intent);
            }
        });
    }
}