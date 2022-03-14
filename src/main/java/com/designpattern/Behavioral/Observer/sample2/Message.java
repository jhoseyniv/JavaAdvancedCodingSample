package com.designpattern.Behavioral.Observer.sample2;

public class Message {
    final String messageContent;

    public Message (String m) {
        this.messageContent = m;
    }

    public String getMessageContent() {
        return messageContent;
    }
}
