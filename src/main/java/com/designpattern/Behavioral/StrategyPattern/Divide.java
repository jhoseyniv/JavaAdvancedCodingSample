package com.designpattern.Behavioral.StrategyPattern;

import java.math.BigInteger;

public class Divide implements Strategy{
    @Override
    public BigInteger calculation(BigInteger a, BigInteger b) {
        if(b.longValue()==0) {
            System.out.println("b can not be Zero");
            return new BigInteger("-1");
        }
         return a.divide(b);
    }
}
