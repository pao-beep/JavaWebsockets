package com.example.stomp_java_websocket;

import org.springframework.stereotype.Service;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
@Configuration
@EnableWebSocketMessageBroker
public class StompMessageWebsocketConfig  implements WebSocketMessageBrokerConfigurer{

   
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        // Configuration code for message broker can be added here
        config.enableSimpleBroker("/topic");
        config.setApplicationDestinationPrefixes("/app");
    }
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/gs-guide-websocket")
                .setAllowedOriginPatterns("*");
                //.withSockJS();
    }
  
}
