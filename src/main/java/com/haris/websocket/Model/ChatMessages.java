package com.haris.websocket.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatMessages {

    private String  recipient ; //kn recive kraiga
    private String content ;  //kya message hoga
    private String sender;
    private String  timestamp;//kisnay bheja
}
