package com.streams.foodsample;

import java.util.Arrays;
import java.util.List;

public class StreamFilteringSample {
    public static void main(String args[]){
        List<Integer> numbers = Arrays.asList(2,1,3,4,6,2,4,8,2,4,6,5,12,11,7,9,13,12,4,6,4,6);

        //distinct method on even numbers in above list
        numbers.stream().filter(num -> num % 2 == 0 ).distinct().forEach(System.out::println);

    }

}
