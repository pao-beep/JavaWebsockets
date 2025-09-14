package com.example.Chat;

public class User {
    private String username;
    private String sessionId;

    public User(String username, String sessionId) {
        this.username = username;
        this.sessionId = sessionId;
    }

    public String getUsername() {
        return username;
    }

    public String getSessionId() {
        return sessionId;
    }
}
