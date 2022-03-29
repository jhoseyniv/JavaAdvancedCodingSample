package com.debug;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LoggingStreams {
    public static void main(String args[]){
        List<Integer> numbers = Arrays.asList(3,5,6,7,89,12,34,5,6);
        numbers.stream().map(x -> x+17).
                filter( x -> x % 2 == 0).limit(3).forEach(System.out::println);


        List<Integer> result = numbers.stream().peek(x -> System.out.print("original stream is " + x + " , " )).
                map(x -> x+17 ).peek(x -> System.out.println("after map " + x + " , ")).
                filter(x -> x % 2 ==0 ).peek(x -> System.out.print("after filter " + x + " , ")).
                limit(3).peek(x -> System.out.println("after limit " + x + " , x")).
                collect(Collectors.toList());

        //result.stream().forEach(System.out::println);
    }
}
