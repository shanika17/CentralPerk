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


public class EventCustomAdapter extends RecyclerView.Adapter<EventCustomAdapter.myViewHolder>{

    private Context context;
    Activity activity;
    private ArrayList event_id,name, email, phoneNo, noOfGuests, eventDate, eventType, roomNo, requirements;

    Animation event_translate_anim;

    EventCustomAdapter(Activity activity ,Context context,
                  ArrayList event_id,
                  ArrayList name,
                  ArrayList email,
                  ArrayList phoneNo,
                  ArrayList noOfGuests,
                  ArrayList eventDate,
                  ArrayList eventType,
                  ArrayList roomNo,
                  ArrayList requirements){
        this.activity = activity;
        this.context = context;
        this.event_id = event_id;
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.noOfGuests = noOfGuests;
        this.eventDate = eventDate;
        this.eventType = eventType;
        this.roomNo = roomNo;
        this.requirements = requirements;

    }

    @NonNull
    //@org.jetbrains.annotations.NotNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull /*@org.jetbrains.annotations.NotNull*/ ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.event_my_row, parent, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull /*@org.jetbrains.annotations.NotNull */EventCustomAdapter.myViewHolder  holder, @SuppressLint("RecyclerView") int position) {


        holder.event_id_txt.setText(String.valueOf(event_id.get(position)));
        holder.name_txt.setText(String.valueOf(name.get(position)));
        holder.email_txt.setText(String.valueOf(email.get(position)));
        holder.phoneNo_txt.setText(String.valueOf(phoneNo.get(position)));
        holder.noOfGuests_txt.setText(String.valueOf(noOfGuests.get(position)));
        holder.eventDate_txt.setText(String.valueOf(eventDate.get(position)));
        holder.eventType_txt.setText(String.valueOf(eventType.get(position)));
        holder.roomNo_txt.setText(String.valueOf(roomNo.get(position)));
        holder.requirements_txt.setText(String.valueOf(requirements.get(position)));

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, EventUpdateActivity.class);
                intent.putExtra("event_id", String.valueOf(event_id.get(position)));
                intent.putExtra("name", String.valueOf(name.get(position)));
                intent.putExtra("email", String.valueOf(email.get(position)));
                intent.putExtra("phoneNo", String.valueOf(phoneNo.get(position)));
                intent.putExtra("noOfGuests", String.valueOf(noOfGuests.get(position)));
                intent.putExtra("eventDate", String.valueOf(eventDate.get(position)));
                intent.putExtra("eventType", String.valueOf(eventType.get(position)));
                intent.putExtra("roomNo", String.valueOf(roomNo.get(position)));
                intent.putExtra("requirements", String.valueOf(requirements.get(position)));

                activity.startActivityForResult(intent, 1);

            }
        });


    }

    @Override
    public int getItemCount() {
        return event_id.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder{

        TextView event_id_txt, name_txt, email_txt, phoneNo_txt, noOfGuests_txt, eventDate_txt, eventType_txt, roomNo_txt, requirements_txt;
        LinearLayout mainLayout;

        public myViewHolder(@NonNull /* @org.jetbrains.annotations.NotNull*/ View itemView) {
            super(itemView);
            event_id_txt = itemView.findViewById(R.id.event_id_txt);
            name_txt = itemView.findViewById(R.id.name_txt);
            email_txt = itemView.findViewById(R.id.email_txt);
            phoneNo_txt = itemView.findViewById(R.id.phoneNo_txt);
            noOfGuests_txt = itemView.findViewById(R.id.noOfGuests_txt);
            eventDate_txt = itemView.findViewById(R.id.eventDate_txt);
            eventType_txt = itemView.findViewById(R.id.eventType_txt);
            roomNo_txt = itemView.findViewById(R.id.roomNo_txt);
            requirements_txt = itemView.findViewById(R.id.requirements_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);
            event_translate_anim = AnimationUtils.loadAnimation(context,R.anim.event_translate_anim);
            mainLayout.setAnimation(event_translate_anim);

        }
    }

}
