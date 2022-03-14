package com.designpattern.Behavioral.Observer.sample2;

public interface Subject {
    public void attach(Observer o);
    public void detach(Observer o);
    public void notifyUpdate(Message m);
}
