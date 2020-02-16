package com.tztechs.student.base;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.tztechs.student.R;
import com.tztechs.student.ui.assignment.AssignmentFragment;
import com.tztechs.student.ui.attendance.AttendanceFragment;
import com.tztechs.student.ui.degree.DegreeFragment;
import com.tztechs.student.ui.home.HomeFragment;
import com.tztechs.student.ui.teachers.TeachersFragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.viewpager.widget.ViewPager;

public class BaseComponent extends AppCompatActivity {
    NavigationView navigationView;
    BottomNavigationView navView;
    private ViewPager viewPager;
    private AppBarConfiguration mAppBarConfiguration;
    AssignmentFragment assignmentFragment;
    AttendanceFragment attendanceFragment;
    DegreeFragment degreeFragment;
    HomeFragment homeFragment;
    TeachersFragment teachersFragment;
    MenuItem prevMenuItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_component);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
         navView = findViewById(R.id.nav_view);
        navigationView =findViewById(R.id.nav_view2);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        viewPager =  findViewById(R.id.view_pager);
        navView.setOnNavigationItemSelectedListener(
                menuItem -> {
                    switch (menuItem.getItemId()) {
                        case R.id.navigation_home:
                            viewPager.setCurrentItem(0);
                            break;
                        case R.id.navigation_assignment:
                            viewPager.setCurrentItem(1);
                            break;
                        case R.id.navigation_degree:
                            viewPager.setCurrentItem(2);
                            break;
                        case R.id.navigation_attendance:
                            viewPager.setCurrentItem(3);
                            break;
                        case R.id.navigation_teachers:
                            viewPager.setCurrentItem(4);
                            break;
                    }
                    return false;
                });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                }
                else
                {
                    navView.getMenu().getItem(0).setChecked(false);
                }
                Log.d("page", "onPageSelected: "+position);
                navView.getMenu().getItem(position).setChecked(true);
                prevMenuItem = navView.getMenu().getItem(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_assignment, R.id.navigation_degree,R.id.navigation_attendance,R.id.navigation_teachers
        ,R.id.navigation_bus,R.id.navigation_time_table,R.id.navigation_fees)
                .setDrawerLayout(drawer)
                .build();
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
//        NavigationUI.setupWithNavController(navigationView, navController);
//        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.navigation_home, R.id.navigation_assignment, R.id.navigation_degree,R.id.navigation_attendance,R.id.navigation_teachers)
//                .build();
//        NavController navController2 = Navigation.findNavController(this, R.id.nav_host_fragment);
//        NavigationUI.setupWithNavController(navView, navController2);
        setupViewPager(viewPager);

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        homeFragment=new HomeFragment();
        assignmentFragment=new AssignmentFragment();
        degreeFragment=new DegreeFragment();
        attendanceFragment=new AttendanceFragment();
        teachersFragment=new TeachersFragment();
        adapter.addFragment(homeFragment);
        adapter.addFragment(assignmentFragment);
        adapter.addFragment(degreeFragment);
        adapter.addFragment(attendanceFragment);
        adapter.addFragment(teachersFragment);
        viewPager.setAdapter(adapter);
    }
//    @Override
//    public boolean onSupportNavigateUp() {
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
//                || super.onSupportNavigateUp();
//    }
}
