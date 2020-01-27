package com.tztechs.student.ui.degree;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.tztechs.student.R;

public class DegreeFragment extends Fragment {

    private DegreeViewModel degreeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        degreeViewModel =
                ViewModelProviders.of(this).get(DegreeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_degree, container, false);
        return root;
    }
}