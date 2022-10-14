package com.example.innovathon2022_care4u;

import android.provider.Telephony;
import android.util.Log;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;

public class WS4u_Client extends WebSocketClient {
    public WS4u_Client(URI server_uri, Draft draft) {
        super(server_uri, draft);
    }

    public WS4u_Client(URI server_uri) {
        super(server_uri);
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {
        send("Hello, the client has connected! :)");
        Log.i("WS CLIENT: OPEN ", "New connection established");
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        Log.i("WS CLIENT: CLOSE ", "closed the connection");
    }

    @Override
    public void onMessage(String message) {
        Log.i("WS CLIENT: MSG ", message);
    }

    @Override
    public void onError(Exception ex) {
        Log.i("WS CLIENT: ERR", ex.toString());
    }
}
