package com.haris.websocket.Controller;


import com.haris.websocket.Model.ChatMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

@Controller
public class WebsocketController {

    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping ("/send")
    public void sendMessage(@Payload ChatMessages chat ,Principal principal ){
        String authenticatedUser = principal.getName();
        chat.setSender(authenticatedUser);

        simpMessagingTemplate.convertAndSendToUser(
                chat.getRecipient() ,   //kis ko bhejna hay
                        "/queue/messages",  //kis queue per bhejna hay
                chat   // kya bhejna hay

        );


    }
}
