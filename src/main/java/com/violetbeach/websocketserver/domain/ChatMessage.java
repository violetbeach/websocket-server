package com.violetbeach.websocketserver.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatMessage {
    private String roomId;
    private String sender;
    private String message;
    private Type type;

    public enum Type {
        ENTER, TALK
    }
}
