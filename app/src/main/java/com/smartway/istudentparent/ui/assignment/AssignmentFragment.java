package com.smartway.istudentparent.ui.assignment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.smartway.istudentparent.R;

public class AssignmentFragment extends Fragment {

    private AssignmentsViewModel dashboardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(AssignmentsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_assignment, container, false);

        return root;
    }
}