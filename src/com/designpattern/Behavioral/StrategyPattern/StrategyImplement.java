package com.designpattern.Behavioral.StrategyPattern;

import java.math.BigInteger;

public class StrategyImplement {
    public static void main(String[] args){
        System.out.println("This is sample code to implement Stategy Behaivoral pattern in java");
        BigInteger a=new BigInteger("98129387823748632487632487326487623487");
        BigInteger b=new BigInteger("98723847873264732572354326463254652364523642374723672356732");
        StrategyContext addStrategy=new StrategyContext(new Addition());
        System.out.println("Add Two Number a+b="+addStrategy.executeStrategy(a,b));

        StrategyContext multyStrategy = new StrategyContext(new Multiplication());
        System.out.println("Multiple of Two number a x b =" + multyStrategy.executeStrategy(a,b));
    }
}
