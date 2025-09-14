package com.example.stomp_java_websocket;

import org.springframework.stereotype.Component;

@Component
public class Message {
    private String id;
    private String name;
    private String content;

    public Message(String id, String name, String content) {
        this.id = id;
        this.name = name;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }
}


   
