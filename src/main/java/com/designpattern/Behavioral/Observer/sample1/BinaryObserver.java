package com.designpattern.Behavioral.Observer.sample1;

public class BinaryObserver extends MyObserver{
    public BinaryObserver(MySubject subject){
        this.subject = subject;
        this.subject.register(this);
    }

    @Override
    public void update() {
        System.out.println( "Binary String: " + Integer.toBinaryString( subject.getState() ) );
    }

    @Override
    public void register(MyObserver myObserver) {

    }
}
