package com.designpattern.Behavioral.StrategyPattern.validation;

public class Validation {
    private ValidationStrategy strategy;

    public Validation(ValidationStrategy strategy) {
        this.strategy = strategy;
    }
    public boolean validateString(String  s){
          return  strategy.execute(s);
    }
}
