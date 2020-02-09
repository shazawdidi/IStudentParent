package com.tztechs.student.ui.attendance;


import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tztechs.student.R;
import com.tztechs.student.data.DataInterface;
import com.tztechs.student.data.RetrofitClient;
import com.tztechs.student.models.Attend;
import com.tztechs.student.models.AttendanceResponse;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class AttendanceFragment extends Fragment {

    public static final String TAG = "AttendanceFragment";
    @BindView(R.id.progress)
    ProgressBar progress;
    private List<Attend> data;
    private AttendanceAdapter attendanceAdapter;
    Context mContext;
    @BindView(R.id.child_vector)
    ImageView childVector;
    @BindView(R.id.card_profile)
    CardView cardProfile;
    @BindView(R.id.attend_recycler)
    RecyclerView attendRecycler;
    int count = 0;
    public AttendanceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_attendance, container, false);
        ButterKnife.bind(this, root);
        attendRecycler.setHasFixedSize(true);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        attendRecycler.setLayoutManager(manager);
        attendRecycler.setHasFixedSize(true);
        manager.setOrientation(LinearLayoutManager.VERTICAL);

        initAttendance();
        return root;
    }


    private void initAttendance() {
        DataInterface api = RetrofitClient.getClient(RetrofitClient.BASE_URL).create(DataInterface.class);
        Call<AttendanceResponse> attendanceCall = api.getservice();
        attendanceCall.enqueue(new Callback<AttendanceResponse>() {
            @Override
            public void onResponse(Call<AttendanceResponse> call, Response<AttendanceResponse> response) {
                if (response.isSuccessful()){
                    progress.setVisibility(View.GONE);
                Log.i(TAG, response.body().toString());
                data = response.body().getAttends();
                attendanceAdapter = new AttendanceAdapter(getActivity(),data);
                attendRecycler.setAdapter(attendanceAdapter);
                    attendanceAdapter.notifyDataSetChanged();

                }

            }

            @Override
            public void onFailure(Call<AttendanceResponse> call, Throwable t) {
                progress.setVisibility(View.GONE);
            }
        });
    }

}
