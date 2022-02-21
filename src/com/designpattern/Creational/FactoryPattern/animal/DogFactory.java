package com.designpattern.Creational.FactoryPattern.animal;

public class DogFactory  extends AnimalFactory {
    @Override
    public Animal createAnimal() {
        return new Dog();
    }
}
