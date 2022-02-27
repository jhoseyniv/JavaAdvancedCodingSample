package com.designpattern.Behavioral.Observer.sample2;

public class MessageSubscriberThree implements Observer {
    @Override
    public void update(Message m) {
        System.out.println("MessageSubscriberThree :: " + m.getMessageContent());
    }
}
