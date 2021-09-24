package com.example.log;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FoodCustomAdaptor extends RecyclerView.Adapter<FoodCustomAdaptor.MyViewHolder>{
    private Context context;
    private Activity activity;
    private ArrayList food_id, food_orders, food_request, food_room_no, food_payment_method;
    Animation translate_anim;

    FoodCustomAdaptor(Activity activity, Context context, ArrayList food_id, ArrayList food_orders, ArrayList food_request, ArrayList food_room_no, ArrayList food_payment_method){
        this.activity = activity;
        this.context = context;
        this.food_id =food_id;
        this.food_orders = food_orders;
        this.food_request = food_request;
        this.food_room_no = food_room_no;
        this.food_payment_method = food_payment_method;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.food_my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") final int position) { //@suppreeLint("recy..")
        holder.food_id_txt.setText(String.valueOf(food_id.get(position)));
        holder.food_orders_txt.setText(String.valueOf(food_orders.get(position)));
        holder.food_request_txt.setText(String.valueOf(food_request.get(position)));
        holder.food_room_no_txt.setText(String.valueOf(food_room_no.get(position)));
        holder.food_payment_method_txt.setText(String.valueOf(food_payment_method.get(position)));
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, FoodUpdateActivity.class);
                intent.putExtra("foodId", String.valueOf(food_id.get(position)));
                intent.putExtra("orders", String.valueOf(food_orders.get(position)));
                intent.putExtra("request", String.valueOf(food_request.get(position)));
                intent.putExtra("roomNo", String.valueOf(food_room_no.get(position)));
                intent.putExtra("paymentMethod", String.valueOf(food_payment_method.get(position)));
                activity.startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return food_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView food_id_txt, food_orders_txt, food_request_txt, food_room_no_txt, food_payment_method_txt;
        LinearLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            food_id_txt = itemView.findViewById(R.id.food_id_txt);
            food_orders_txt = itemView.findViewById(R.id.food_orders_txt);
            food_request_txt = itemView.findViewById(R.id.food_request_txt);
            food_room_no_txt = itemView.findViewById(R.id.food_room_no_txt);
            food_payment_method_txt = itemView.findViewById(R.id.food_payment_method_txt);

            mainLayout = itemView.findViewById(R.id.foodMainLayout);
            translate_anim = AnimationUtils.loadAnimation(context, R.anim.food_translate_anim);
            mainLayout.setAnimation(translate_anim);
        }
    }
}
