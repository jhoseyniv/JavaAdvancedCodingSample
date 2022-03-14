package com.designpattern.Structural.ProxyPattern.expensiveObject;

public class ExpensiveObjectProxy implements ExpensiveObject{
    private static ExpensiveObject object;

    @Override
    public void process() {
        if (object == null) {
            object = new ExpensiveObjectImpl();
        }
        object.process();
    }

    public static void main(String args[]){
        ExpensiveObject expensiveObject = new ExpensiveObjectProxy();
        expensiveObject.process();
        expensiveObject.process();
        expensiveObject.process();
    }

}
