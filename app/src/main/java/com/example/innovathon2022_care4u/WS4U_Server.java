package com.example.innovathon2022_care4u;

import android.util.Log;

import org.java_websocket.WebSocket;
import org.java_websocket.drafts.Draft;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.Collections;

public class WS4U_Server extends WebSocketServer {
   Boolean client_has_joined;

   public boolean has_client_joined() {
       return client_has_joined;
   }


    public WS4U_Server(int port) throws UnknownHostException {
        super(new InetSocketAddress(port));
    }

    public WS4U_Server(InetSocketAddress address) {
        super(address);
    }

    public WS4U_Server(int port, Draft_6455 draft) {
        super(new InetSocketAddress(port), Collections.<Draft>singletonList(draft));
    }

    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake) {
        conn.send("Welcome to the server!");
        broadcast("new connection: " + handshake
                .getResourceDescriptor());

        Log.i("WS SERVER: JOINED ", conn.getRemoteSocketAddress().getAddress().getHostAddress());
        client_has_joined = true;
    }

    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {
        broadcast(conn + "left the server");
        Log.i("WS SERVER: LEFT ", conn.getRemoteSocketAddress().toString());
    }

    @Override
    public void onMessage(WebSocket conn, String message) {
        broadcast(message);
        Log.i("WS SERVER: MSG ", message);
    }

    @Override
    public void onError(WebSocket conn, Exception ex) {
        ex.printStackTrace();
    }

    @Override
    public void onStart() {
        Log.i("WS SERVER: START ", "SERVER STARTED");
        client_has_joined = false;
        setConnectionLostTimeout(0);
        setConnectionLostTimeout(100);
    }
}