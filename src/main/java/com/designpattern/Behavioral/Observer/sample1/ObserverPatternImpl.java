package com.designpattern.Behavioral.Observer.sample1;

public class ObserverPatternImpl {
    public static void main(String[] args) {
        MySubject subject = new MySubject();

        new HexaObserver(subject);
        new OctalObserver(subject);
        new BinaryObserver(subject);

        System.out.println("First state change: 15");
        subject.setState(15);
        System.out.println("Second state change: 10");
        subject.setState(10);
    }
}
