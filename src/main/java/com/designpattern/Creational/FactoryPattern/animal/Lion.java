package com.designpattern.Creational.FactoryPattern.animal;

public class Lion  implements Animal{
    @Override
    public void speak() {
        System.out.println("Lions says: Halum.");
    }

    @Override
    public void preferredAction() {
        System.out.println("Lions prefer hunting...\n");
    }
}
