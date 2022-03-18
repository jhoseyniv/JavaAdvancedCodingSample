package com.designpattern.Behavioral.StrategyPattern.validation;

public class IsAllUpperCase implements  ValidationStrategy{
    @Override
    public boolean execute(String s) {
        return s.matches("[A-Z]+");
    }
}
