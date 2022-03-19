package com.designpattern.Behavioral.Observer.twitter;

public interface NewsSubject {
    public void register(NewsObserver newsObserver);
    public void notify(String tweet);
}
