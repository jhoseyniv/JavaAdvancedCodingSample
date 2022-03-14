package com.streams;

import java.util.stream.IntStream;

public class RangeNumberSamples {
    public static void main(String args[]){
        IntStream evenNumbers = IntStream.rangeClosed(0,100).filter(n -> n % 2 == 0 );
        System.out.println(evenNumbers.count());
    }
}
