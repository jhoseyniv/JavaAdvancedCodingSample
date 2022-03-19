package com.designpattern.withLambada;

import com.designpattern.Behavioral.StrategyPattern.validation.Validation;

public class ValidationStringImpl {
    public static void main(String args[]){
        Validation uppercaseValidation = new Validation((String s) -> s.matches("[A-Z]+"));
        boolean up = uppercaseValidation.validateString("ULIROOOiO");
        System.out.println(up);

    }
}
