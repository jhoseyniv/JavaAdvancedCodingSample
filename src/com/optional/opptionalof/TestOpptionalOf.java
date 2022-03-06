package com.optional.opptionalof;

import java.util.Optional;

public class TestOpptionalOf {

    public static void main(String[] args){
        String message="Hello World!";
        Optional<String> optionalOf = Optional.of(message);
        Optional<String> optionalOfNull = Optional.ofNullable(message);

        System.out.println("In this case message is not null so Optional.of and Optional.OfNullable....");

        System.out.println("Optional.of(message) = " + optionalOf);
        System.out.println("Optional.ofNullable(message) = " + optionalOfNull);

        message = null;
        try {
            Optional<String> optionalOfWithNullValue = Optional.of(message);
        }catch (NullPointerException exception){
            System.out.println("Excpetion Occured optionalOfWithNullValue is " + exception.getMessage());
        }

        Optional<String> optionalOfNullableWithNullValue = Optional.ofNullable(message);
        if(!optionalOfNullableWithNullValue.isPresent()){
            System.out.println("optionalOfNullableWithNullValue is empty or null  ");

        }
    }
}
