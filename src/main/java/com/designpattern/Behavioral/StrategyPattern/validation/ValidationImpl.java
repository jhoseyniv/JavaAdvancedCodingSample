package com.designpattern.Behavioral.StrategyPattern.validation;

public class ValidationImpl {
    public static void main(String args[]){
        Validation numericValidation = new Validation(new IsNumeric());
        boolean b1 = numericValidation.validateString("980767");
        boolean b2 = numericValidation.validateString("9807b67");

        Validation lowerCaseValidation = new Validation(new IsAllLowerCase());
        boolean b3 = lowerCaseValidation.validateString("Werbosthins a test noT");

     }
}
