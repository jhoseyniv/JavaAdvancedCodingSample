package com.designpattern.Behavioral.Observer.sample1;

    public abstract class MyObserver {
        protected MySubject subject;
        public abstract void update();
        public abstract void add(MyObserver myObserver);
 }

