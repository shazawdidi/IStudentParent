package com.tztechs.student.ui.degree;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.ViewGroup;
import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.tztechs.student.R;
import com.tztechs.student.ui.degree.TermsFragment;

import java.util.List;


public class ViewPagerDegree extends FragmentPagerAdapter {
    private Context mContext;
    List<String> clothesList;
    private final Resources resources;

    SparseArray<Fragment> registeredFragments = new SparseArray<Fragment>();

    public ViewPagerDegree(final Resources resources,FragmentManager fm) {
        super(fm);
        this.resources = resources;;

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new TermsFragment();
        Bundle args = new Bundle();
        args.putInt(TermsFragment.ARG_OBJECT, position + 1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return "Term " + (position + 1);
//        switch (position) {
//            case 0:
//                return resources.getString(R.string.term_one);
//            case 1:
//                return resources.getString(R.string.term_two);
//            default:
//                return null;
//        }

     }

    public Object instantiateItem(ViewGroup container, int position) {
        Fragment fragment = (Fragment) super.instantiateItem(container, position);
        registeredFragments.put(position, fragment);
        return fragment;
    }

    public void destroyItem(ViewGroup container, int position, Object object) {
        registeredFragments.remove(position);
        super.destroyItem(container, position, object);
    }

    public Fragment getRegisteredFragment(int position) {
        return registeredFragments.get(position);
    }
}
