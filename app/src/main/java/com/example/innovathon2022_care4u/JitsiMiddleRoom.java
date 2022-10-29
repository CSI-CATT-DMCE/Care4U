package com.example.innovathon2022_care4u;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class JitsiMiddleRoom extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jitsi_middle_room);

        Log.i("STARTED", "STARTED");

        EditText jitsi_code_textbox = findViewById(R.id.jitsi_code_textbox);
        Button begin_meeting_button = findViewById(R.id.begin_meeting_button);
        begin_meeting_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                final String meeting_code = jitsi_code_textbox.getText().toString();

                Intent i = new Intent(JitsiMiddleRoom.this, JitsiActivity.class);
                i.putExtra("jitsi_meeting_code", meeting_code);
                JitsiMiddleRoom.this.startActivity(i);
            }
        });
    }

    public void log_this() {
        Log.i("STARTED", "STARTED");
    }
}
