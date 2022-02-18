package designpattern.Behavioral.StrategyPattern;

import java.math.BigInteger;

public class Multiplication implements Strategy{

    @Override
    public BigInteger calculation(BigInteger a, BigInteger b) {
        return a.multiply(b);
    }
}
