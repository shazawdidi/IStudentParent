package com.tztechs.student.ui.degree;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tztechs.student.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TermsFragment extends Fragment {
    public static final String ARG_OBJECT = "term";


    public TermsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_terms, container, false);
    }

}
