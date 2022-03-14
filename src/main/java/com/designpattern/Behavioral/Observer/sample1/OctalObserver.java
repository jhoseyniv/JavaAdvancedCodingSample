package com.designpattern.Behavioral.Observer.sample1;

public class OctalObserver extends MyObserver {
    public OctalObserver(MySubject subject){
        this.subject = subject;
        this.subject.register(this);
    }

    @Override
    public void update() {
        System.out.println( "Octal String: " + Integer.toOctalString( subject.getState() ) );
    }

    @Override
    public void register(MyObserver myObserver) {

    }
}
