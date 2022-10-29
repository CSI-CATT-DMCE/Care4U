package com.example.innovathon2022_care4u;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class ForgotPassword extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_password);

        int supposed_otp = (int )(Math.random() * 9999 + 1);

        EditText otp = findViewById(R.id.otp);
        Button submit = findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String entered_otp = otp.getText().toString();
                if (Integer.parseInt(entered_otp) == supposed_otp){
                    submit.setText("Success! Returning to login");
                    submit.setBackgroundColor(getResources().getColor(R.color.confirm_green));

                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            finish();
                        }
                    }, 1000);
                }
            }
        });
    }
}

