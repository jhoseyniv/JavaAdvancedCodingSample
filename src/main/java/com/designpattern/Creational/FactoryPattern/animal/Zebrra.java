package com.designpattern.Creational.FactoryPattern.animal;

public class Zebrra  implements Animal{
    @Override
    public void speak() {
        System.out.println("Zebrra says: ohhh.");

    }

    @Override
    public void preferredAction() {
        System.out.println("zebrra : ......");

    }
}
