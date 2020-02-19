package com.tztechs.student.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.tztechs.student.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class HomeFragment extends Fragment {


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
    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, root);

        return root;
    }
}