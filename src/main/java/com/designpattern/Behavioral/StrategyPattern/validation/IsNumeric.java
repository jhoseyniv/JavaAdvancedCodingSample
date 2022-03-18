package com.designpattern.Behavioral.StrategyPattern.validation;

public class IsNumeric implements ValidationStrategy{
    @Override
    public boolean execute(String s) {
        return s.matches("[0-9]+");
    }
}
