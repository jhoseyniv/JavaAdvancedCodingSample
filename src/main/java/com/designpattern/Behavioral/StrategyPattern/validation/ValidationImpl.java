package com.designpattern.Behavioral.StrategyPattern.validation;

public class ValidationImpl {
    public static void main(String args[]){
        Validation numericValidation = new Validation(new IsNumeric());
        boolean b1 = numericValidation.validateString("aaaa");

    }
}
