package com.example.log;

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

public class RoomCustomAdapter extends RecyclerView.Adapter<RoomCustomAdapter.myViewHolder> {

    private Context context;
    Activity activity;
    private ArrayList room_id, date, room_faci, room_adults, room_children, room_days;

    Animation translate_room_anim;



    RoomCustomAdapter(Activity activity ,Context context,
                  ArrayList room_id,
                  ArrayList date,
                  ArrayList room_faci,
                  ArrayList room_adults,
                  ArrayList room_children,
                  ArrayList room_days){
        this.activity = activity;
        this.context = context;
        this.room_id = room_id;
        this.date = date;
        this.room_faci = room_faci;
        this.room_adults = room_adults;
        this.room_children = room_children;
        this.room_days = room_days;

    }
    @NonNull
    //@org.jetbrains.annotations.NotNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull /*@org.jetbrains.annotations.NotNull*/ ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.myroom_row, parent, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull /*@org.jetbrains.annotations.NotNull */RoomCustomAdapter.myViewHolder  holder, int position) {


        holder.room_id_txt.setText(String.valueOf(room_id.get(position)));
        holder.date_txt.setText(String.valueOf(date.get(position)));
        holder.facilities_txt.setText(String.valueOf(room_faci.get(position)));
        holder.adults_txt.setText(String.valueOf(room_adults.get(position)));
        holder.children_txt.setText(String.valueOf(room_children.get(position)));
        holder.days_txt.setText(String.valueOf(room_days.get(position)));

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, RoomUpdateActivity.class);
                intent.putExtra("id", String.valueOf(room_id.get(position)));
                intent.putExtra("date", String.valueOf(date.get(position)));
                intent.putExtra("faci", String.valueOf(room_faci.get(position)));
                intent.putExtra("adults", String.valueOf(room_adults.get(position)));
                intent.putExtra("children", String.valueOf(room_children.get(position)));
                intent.putExtra("days", String.valueOf(room_days.get(position)));
                activity.startActivityForResult(intent, 1);

            }
        });


    }

    @Override
    public int getItemCount() {
        return room_id.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder{

        TextView room_id_txt, date_txt,facilities_txt, adults_txt, children_txt, days_txt;
        LinearLayout mainLayout;

        public myViewHolder(@NonNull /* @org.jetbrains.annotations.NotNull*/ View itemView) {
            super(itemView);
            room_id_txt = itemView.findViewById(R.id.room_id_txt);
            date_txt = itemView.findViewById(R.id.date_txt);
            facilities_txt = itemView.findViewById(R.id.facilities_txt);
            adults_txt = itemView.findViewById(R.id.adults_txt);
            children_txt = itemView.findViewById(R.id.children_txt);
            days_txt = itemView.findViewById(R.id.days_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);
            translate_room_anim = AnimationUtils.loadAnimation(context,R.anim.translate_room_anim);
            mainLayout.setAnimation(translate_room_anim);

        }
    }
}
