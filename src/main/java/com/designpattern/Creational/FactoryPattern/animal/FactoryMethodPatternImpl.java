package com.designpattern.Creational.FactoryPattern.animal;

public class FactoryMethodPatternImpl {
    public static void main(String[] args) {
        AnimalFactory dogFactory = new DogFactory();
        AnimalFactory lionFactory = new LionFactory();
        AnimalFactory zebraFactory = new ZebrraFactory();

        Animal dog1= dogFactory.createAnimal();
        Animal lion1= lionFactory.createAnimal();
        Animal zebrra1= zebraFactory.createAnimal();


        dog1.speak();
        lion1.speak();
        zebrra1.speak();


    }
}
