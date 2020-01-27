package com.tztechs.student.ui.fees;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tztechs.student.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FeesFragment extends Fragment {


    public FeesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fees, container, false);
    }

}
