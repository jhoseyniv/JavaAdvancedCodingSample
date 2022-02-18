package designpattern.Creational.FactoryPattern.animal;

public class LionFactory extends AnimalFactory{
    @Override
    public Animal createAnimal() {
        return new Lion();
    }
}
