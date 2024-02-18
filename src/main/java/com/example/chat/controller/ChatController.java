package com.example.chat.controller;

import com.example.chat.models.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    private static final String SEND_MESSAGE = "/chat.sendMessage";
    private static final String ADD_USER = "/chat.addUser";
    private static final String WS = "/topic/public";

    @MessageMapping(SEND_MESSAGE)
    @SendTo(WS)
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage){
        return chatMessage;
    }

    @MessageMapping(ADD_USER)
    @SendTo(WS)
    public ChatMessage addUser(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor){
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }
}