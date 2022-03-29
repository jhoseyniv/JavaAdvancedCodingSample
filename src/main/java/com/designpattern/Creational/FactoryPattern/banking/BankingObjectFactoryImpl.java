package com.designpattern.Creational.FactoryPattern.banking;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class BankingObjectFactoryImpl {
    public static final Map<String,Supplier<BankingObject>> map = new HashMap<>();
    static {
        map.put("loan",Loan::new);
        map.put("stock",Stock::new);
        map.put("bond",Bond::new);
    }

    public static void main(String args[]){
        BankingObject loan = BankingObjectFactory.createProduct(BankingObjectType.Loan.toString());
        BankingObject stock = BankingObjectFactory.createProduct(BankingObjectType.Stock.toString());

        Supplier<BankingObject> loan2  = Loan::new;
        Supplier<BankingObject> stock2 = Stock::new;


        BankingObject loan3 = BankingObjectFactory.createBankObjectWithMap(map,"loan");
        BankingObject bond = BankingObjectFactory.createBankObjectWithMap(map,"bond");


    }
}
