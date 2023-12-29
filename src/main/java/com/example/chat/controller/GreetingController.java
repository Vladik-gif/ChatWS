package com.example.chat.controller;


import com.example.chat.models.GreetingEntity;
import com.example.chat.models.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {

    private static final String HELLO = "/hello";
    private static final String TP = "/topic/greetings";

    @MessageMapping(HELLO)
    @SendTo(TP)
    public GreetingEntity greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000);
        return new GreetingEntity("Hello, " + HtmlUtils.htmlEscape(message.name()) + "!");
    }
}

