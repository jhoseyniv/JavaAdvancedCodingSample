package com.designpattern.Behavioral.StrategyPattern.Arhtmatic;

import java.math.BigInteger;

public interface Strategy {
    public BigInteger calculation(BigInteger a, BigInteger b);
}
