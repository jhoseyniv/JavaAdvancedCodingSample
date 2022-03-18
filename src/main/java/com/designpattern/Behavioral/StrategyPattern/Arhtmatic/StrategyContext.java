package com.designpattern.Behavioral.StrategyPattern.Arhtmatic;

import java.math.BigInteger;

public class StrategyContext {
    private Strategy strategy;

    public StrategyContext(Strategy strategy) {
        this.strategy = strategy;
    }

    public BigInteger executeStrategy(BigInteger a, BigInteger b) {
        return  strategy.calculation(a, b);
    }
}

