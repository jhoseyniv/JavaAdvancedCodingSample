package com.designpattern.Behavioral.Observer.sample1;

public class HexaObserver extends MyObserver{

    public HexaObserver(MySubject subject){
        this.subject = subject;
        this.subject.register(this);
    }

    @Override
    public void update() {
        System.out.println( "Hex String: " + Integer.toHexString( subject.getState() ).toUpperCase() );
    }

    @Override
    public void register(MyObserver myObserver) {

    }
}
