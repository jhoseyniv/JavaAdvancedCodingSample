package com.designpattern.Structural.ProxyPattern.expensiveObject;

public class ExpensiveObjectImpl implements ExpensiveObject{

    public ExpensiveObjectImpl() {
        System.out.println("Loading initial configuration...");
    }

    @Override
    public void process() {
        System.out.println("Processing Complete...");

    }
}
