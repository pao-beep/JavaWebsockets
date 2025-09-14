package com.example.stomp_java_websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {
    private final StompMessageWebsocketConfig stompMessageService;

    public GreetingController(StompMessageWebsocketConfig stompMessageService) {
        this.stompMessageService = stompMessageService;
    }

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public GreetingMessage greet(@Payload Message message) throws Exception {
   
        Thread.sleep(1000); // simulated delay
        return new GreetingMessage("Hello, " + HtmlUtils.htmlEscape(message.getName() ) + "!");
    }
    
}
