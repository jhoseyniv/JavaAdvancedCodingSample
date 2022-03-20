package com.designpattern.Creational.FactoryPattern.banking;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class BankingObjectFactory {
    public static BankingObject createProduct(String name){
        switch (name){
            case "Loan" : return new Loan();
            case "Stock" : return new Stock();
            case "Bond" : return new Bond();
            default: throw new RuntimeException("No Banking Object found : " + name);
        }

    }
    public static BankingObject createBankObjectWithMap(Map<String, Supplier<BankingObject>> map, String name){
        Supplier<BankingObject> p = map.get(name);
        if(p != null) return p.get();
        throw new IllegalArgumentException("No such product " + name);
    }
}
