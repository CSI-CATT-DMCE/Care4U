package com.example.innovathon2022_care4u;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.server.WebSocketServer;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;

public class ChatActivity extends AppCompatActivity {

    WebSocketClient ws_client;
    WS4U_Server ws_stuff;

    TextView client_signal, counselor_signal;
    Boolean clients_turn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_module);

        client_signal = findViewById(R.id.client_signal);
        counselor_signal = findViewById(R.id.counselor_signal);

        clients_turn = false;
        EditText message = findViewById(R.id.message);

        TextView author = findViewById(R.id.author);
        TextView message_content = findViewById(R.id.message_content);

        FloatingActionButton send_message = findViewById(R.id.send_message);

        try {
            Log.i("WS SERVER: ", "Trying to start the WS server");
            ws_stuff = new WS4U_Server(9001);
            ws_stuff.start();
            counselor_signal.setBackgroundColor(getResources().getColor(R.color.blue_grotto));
        } catch (UnknownHostException e) {
            Log.i("WS SERVER: ", "Epic fail");
            e.printStackTrace();
        }


        client_signal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    ws_client = new WS4u_Client(new URI("ws://localhost:9001"));
                    ws_client.connectBlocking();
                    client_signal.setBackgroundColor(getResources().getColor(R.color.red));
                    client_signal.setWidth(Integer.parseInt("105dp"));
                } catch (InterruptedException | URISyntaxException e) {
                    e.printStackTrace();
                }
            }
        });


        send_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clients_turn) {
                    author.setText("Client");
                    // ws_client.send(message.toString());
                    message_content.setText(message.getText());
                    clients_turn = false;
                } else {
                    author.setText("Counselor");
                    // ws_stuff.broadcast(message.toString());
                    message_content.setText(message.getText());
                    clients_turn = true;
                }

                message.setText("");
            }
        });







    }
}
