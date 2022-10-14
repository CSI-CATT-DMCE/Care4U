package com.example.innovathon2022_care4u;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class UserHomeDashboard extends AppCompatActivity  implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home_dashboard);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.home_user);
    }
    DashHome homedash = new DashHome();
    DashProfile dashprof = new DashProfile();

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.home_user:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, homedash).commit();
                return true;

            case R.id.profile_user:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, dashprof).commit();
                return true;

//            case R.id.settings:
//                getSupportFragmentManager().beginTransaction().replace(R.id.container, thirdFragment).commit();
//                return true;
        }
        return false;
    }
}