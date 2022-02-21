package com.designpattern.Behavioral.StrategyPattern;

import java.math.BigInteger;

public class Subtraction implements Strategy{

    @Override
    public BigInteger calculation(BigInteger a, BigInteger b) {
        return a.subtract(b);
    }
}
