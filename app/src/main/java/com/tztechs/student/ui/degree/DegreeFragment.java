package com.tztechs.student.ui.degree;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.tztechs.student.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DegreeFragment extends Fragment {
    private  ViewPagerDegree viewPagerDegree;
    private  Resources resources;
    @BindView(R.id.child_vector)
    ImageView childVector;
    @BindView(R.id.text_degree_tip)
    TextView textDegreeTip;
    @BindView(R.id.card_profile)
    CardView cardProfile;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.vpPager)
    ViewPager vpPager;
    private DegreeViewModel degreeViewModel;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        degreeViewModel =
                ViewModelProviders.of(this).get(DegreeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_degree, container, false);
        ButterKnife.bind(this, root);

         return root;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        viewPagerDegree = new ViewPagerDegree(resources,getChildFragmentManager());
        vpPager.setAdapter(viewPagerDegree);
        tabLayout.setupWithViewPager(vpPager);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Note that we are passing childFragmentManager, not FragmentManager

     }

}