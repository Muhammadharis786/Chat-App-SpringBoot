package com.haris.websocket.Configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;


@Configuration
@EnableWebSocketMessageBroker
public class websocketconfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws")
                .setAllowedOrigins("http://127.0.0.1:5500/")
                .addInterceptors(new UserHandshakeInterceptor())
                .withSockJS();

    }

    @Override
    public  void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic" , "/queue"); //this is for broadcast all connect user
        registry.setApplicationDestinationPrefixes("/app");   //this is for prefiex app for reciveing data from client
        registry.setUserDestinationPrefix("/user");  //this is for private mesage broadcast send message for specific user
    }

    @Override
    public void configureClientInboundChannel(ChannelRegistration registration) {
        registration.interceptors(new UserChannelInterceptor());  // YE ADD KAREIN
    }

}
