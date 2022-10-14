package com.example.innovathon2022_care4u;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


public class DashProfile extends Fragment {

    TextView appoint, profile, logout;


    public DashProfile() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_dash_profile, container, false);

        appoint = (TextView) v.findViewById(R.id.appointments);

        profile = (TextView) v.findViewById(R.id.view_my_profile);

        logout = (TextView) v.findViewById(R.id.log_out);



        appoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(),AppointmentsSection.class));
            }
        });


        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(),ViewProfile.class));
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "You have logged out successfully", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getContext(),LoginActivity.class));

            }
        });





        return v;
    }
}