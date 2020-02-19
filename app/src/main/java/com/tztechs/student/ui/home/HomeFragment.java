package com.tztechs.student.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tztechs.student.R;
import com.tztechs.student.data.DataInterface;
import com.tztechs.student.data.RetrofitClient;
import com.tztechs.student.models.Events;
import com.tztechs.student.models.response.AttendanceResponse;
import com.tztechs.student.models.response.EventsResponse;
import com.tztechs.student.ui.attendance.AttendanceAdapter;
import com.tztechs.student.ui.home.adapter.EventsAdapteer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {
    public static final String TAG = "HomeFragment";


    @BindView(R.id.child_vector)
    CircleImageView childVector;
    @BindView(R.id.text_student_name)
    TextView textStudentName;
    @BindView(R.id.text_grade)
    TextView textGrade;
    @BindView(R.id.text_grade_name)
    TextView textGradeName;
    @BindView(R.id.timeTable)
    TextView timeTable;
    @BindView(R.id.bus)
    TextView bus;
    @BindView(R.id.text_fees)
    TextView textFees;
    @BindView(R.id.recycler_event)
    RecyclerView recyclerEvent;
    @BindView(R.id.recycler_note)
    RecyclerView recyclerNote;
    private HomeViewModel homeViewModel;
    private EventsAdapteer adapter;
    private List<Events> data;
    Context mContext;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, root);
        initEvents();
        return root;
    }

    private void initEvents() {
        DataInterface api = RetrofitClient.getClient(RetrofitClient.BASE_URL).create(DataInterface.class);
        Call<EventsResponse> attendanceCall = api.getEvents();
        attendanceCall.enqueue(new Callback<EventsResponse>() {
            @Override
            public void onResponse(Call<EventsResponse> call, Response<EventsResponse> response) {
                if (response.isSuccessful()) {
//                    progress.setVisibility(View.GONE);
                    Log.i(TAG, response.body().toString());
                    ArrayList dataa = new ArrayList<Events>();
                    dataa= (ArrayList) response.body().getData();
                    LinearLayoutManager manager = new LinearLayoutManager(mContext);
                    recyclerEvent.setLayoutManager(manager);
                    recyclerEvent.setHasFixedSize(true);
                    adapter = new EventsAdapteer(dataa);
                    recyclerEvent.setAdapter(adapter);;

                }

            }

            @Override
            public void onFailure(Call<EventsResponse> call, Throwable t) {
//                progress.setVisibility(View.GONE);
            }
        });
    }
}