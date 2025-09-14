package com.example.stomp_java_websocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StompJavaWebsocketApplication {

	public static void main(String[] args) {
		SpringApplication.run(StompJavaWebsocketApplication.class, args);
	}
	@Bean
	public Message message() {
    	return new Message("1", "Test", "This is a test message");
	}
}
