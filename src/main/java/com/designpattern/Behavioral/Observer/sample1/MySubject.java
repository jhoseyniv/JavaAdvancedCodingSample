package com.designpattern.Behavioral.Observer.sample1;

import java.util.ArrayList;
import java.util.List;

public class MySubject {
    private List<MyObserver> observers = new ArrayList<MyObserver>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void register(MyObserver observer){

        observers.add(observer);
    }

    public void notifyAllObservers(){
        for (MyObserver observer : observers) {
            observer.update();
        }
    }
}
