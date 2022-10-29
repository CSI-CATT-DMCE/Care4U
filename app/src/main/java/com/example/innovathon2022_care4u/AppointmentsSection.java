package com.example.innovathon2022_care4u;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.airbnb.lottie.model.animatable.AnimatablePointValue;

public class AppointmentsSection extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointments_section);

        Button launch_jitsi_button = findViewById(R.id.launch_jitsi_button);
        launch_jitsi_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AppointmentsSection.this, JitsiMiddleRoom.class);
                startActivity(i);
            }
        });
    }
}