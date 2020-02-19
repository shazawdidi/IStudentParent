package com.tztechs.student.ui.home.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tztechs.student.R;
import com.tztechs.student.models.Events;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EventsAdapteer extends RecyclerView.Adapter<EventsAdapteer.EventsViewHolder> {
    private Context mContext;
    private ArrayList<Events> mEvents;
     public EventsAdapteer(ArrayList<Events> events) {
//        this.mContext = context;
        this.mEvents = events;
    }

    @NonNull
    @Override
    public EventsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.events_items, parent, false);
        return new EventsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventsViewHolder holder, int position) {
        holder.tvEventTitle.setText(mEvents.get(position).getTitle());
        holder.tvEventDate.setText(mEvents.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return mEvents.size();
    }

     class EventsViewHolder extends RecyclerView.ViewHolder {
         TextView tvEventDate,tvEventTitle;


          EventsViewHolder(@NonNull View view) {
            super(view);
              tvEventDate=view.findViewById(R.id.tv_event_date);
              tvEventTitle=view.findViewById(R.id.tv_event_title);
        }
    }
}
