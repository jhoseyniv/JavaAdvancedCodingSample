package com.designpattern.Behavioral.StrategyPattern;

import java.math.BigInteger;

public class Addition  implements Strategy{

    @Override
    public BigInteger calculation(BigInteger a, BigInteger b) {
        return a.add(b);
    }
}
