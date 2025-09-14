package com.example.Chat;
import jakarta.websocket.OnOpen;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;

import jakarta.websocket.Session;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/chat/{username}")
public class ChatEndpoint {
    private Session session;
    private static Set<ChatEndpoint> chatEndpoints = new CopyOnWriteArraySet<>();
    private static java.util.Map<String, String> users = new java.util.concurrent.ConcurrentHashMap<>();

    @OnOpen
    public void onOpen(Session session, @PathParam("username") String username) {
        this.session = session;
        chatEndpoints.add(this);
        users.put(session.getId(), username);

        Message message = new Message();
        message.setFrom(username);
        message.setContent("Connected!");
        broadcast(message);
        System.out.println("New connection: " + session.getId());
    }

    @OnClose
    public void onClose(Session session) {
        System.out.println("Connection closed: " + session.getId());
    }

    @OnMessage
    public void onMessage(Message message, Session session) {
        System.out.println("Message from " + session.getId() + ": " + message);
        // Echo the message back to the client
        try {
            message.setFrom(users.get(session.getId()));
            session.getBasicRemote().sendText("Echo: " + message);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void broadcast(Message message) {
        chatEndpoints.forEach(endpoint -> {
            synchronized (endpoint) {
                try {
                    endpoint.session.getBasicRemote().sendText(message.getFrom() + ": " + message.getContent());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}