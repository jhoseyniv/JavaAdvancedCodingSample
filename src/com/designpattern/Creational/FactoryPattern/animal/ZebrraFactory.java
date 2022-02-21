package com.designpattern.Creational.FactoryPattern.animal;

public class ZebrraFactory extends AnimalFactory{
    @Override
    public Animal createAnimal() {
        return new Zebrra();
    }
}
