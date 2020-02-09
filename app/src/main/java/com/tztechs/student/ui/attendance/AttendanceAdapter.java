package com.tztechs.student.ui.attendance;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tztechs.student.R;
import com.tztechs.student.models.Attend;

import java.util.ArrayList;
import java.util.List;

public class AttendanceAdapter extends RecyclerView.Adapter<AttendanceAdapter.ViewHolder> {
    private final List<Attend> attendances;
    private final Context mContext;

    public AttendanceAdapter( Context mContext,List<Attend>  attendances) {
        this.mContext = mContext;
        this.attendances = attendances;

    }

    @NonNull
    @Override
    public AttendanceAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.attendance_items, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        holder.attend.setText(attendances.get(i).getAttend());
        holder.attendDate.setText(attendances.get(i).getAttendDate());
    }

    @Override
    public int getItemCount() {
        return attendances.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView attend,attendDate;
        public ViewHolder(View view) {
            super(view);
            attend =  view.findViewById(R.id.attend);
            attendDate =  view.findViewById(R.id.attend_date);

        }
    }

}
