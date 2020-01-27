package com.tztechs.student.ui.tracKBus;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tztechs.student.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class TrackBusFragment extends Fragment {


    public TrackBusFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_track_bus, container, false);
    }

}
