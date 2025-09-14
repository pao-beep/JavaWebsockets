package com.example.stomp_java_websocket;

import org.springframework.stereotype.Component;

@Component
public class GreetingMessage {
    private String content;

    public GreetingMessage() {
    }

    public GreetingMessage(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
