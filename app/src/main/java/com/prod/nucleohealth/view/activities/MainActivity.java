package com.prod.nucleohealth.view.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.prod.nucleohealth.R;
import com.prod.nucleohealth.data.model.request.LoginRequestModel;
import com.prod.nucleohealth.viewmodel.LoginViewModel;


public class MainActivity extends AppCompatActivity {
    BottomNavigationView homeTabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        homeTabLayout = findViewById(R.id.tabHome);
        setUpNavigation();
        //setTabBar();

    }



    public void setUpNavigation(){
        NavHostFragment navHostFragment = (NavHostFragment)getSupportFragmentManager()
                .findFragmentById(R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(homeTabLayout, navHostFragment.getNavController());
    }
    /*private void setTabBar(){
        int[] tabIcons = {
                R.drawable.tab_home,
                R.drawable.tab_search,
                R.drawable.tab_profile_01,
                R.drawable.tab_settings
        };

        homeTabLayout.addTab(homeTabLayout.newTab());
        homeTabLayout.addTab(homeTabLayout.newTab());
        homeTabLayout.addTab(homeTabLayout.newTab());
        homeTabLayout.addTab(homeTabLayout.newTab());
        homeTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        for (int i = 0; i < homeTabLayout.getTabCount(); i++) {
            homeTabLayout.getTabAt(i).setIcon(tabIcons[i]);
        }
        homeTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                switch (tab.getPosition()){
                    case 0:
                        //navController.navigate(R.id.dashboardFragment);
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }*/
}
