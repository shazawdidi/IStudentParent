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
import com.tztechs.student.models.Notes;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NoteAdapteer extends RecyclerView.Adapter<NoteAdapteer.NoteViewHolder> {
    private Context mContext;
    private List<Notes> mEvents;

    public NoteAdapteer(Context context,List<Notes> events) {
        this.mContext = context;
        this.mEvents = events;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.note_view, parent, false);
        ButterKnife.bind((Activity) mContext);
        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        holder.tvEventTitle.setText(mEvents.get(position).getTitle());
        holder.tvEventDate.setText(mEvents.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return mEvents.size();
    }

    class NoteViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_event_date)
        TextView tvEventDate;
        @BindView(R.id.tv_event_title)
        TextView tvEventTitle;
        NoteViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
