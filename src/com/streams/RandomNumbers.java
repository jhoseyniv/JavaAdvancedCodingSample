package com.streams;

import com.sun.tools.javac.Main;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RandomNumbers {

    public static void main(String args[]){
        IntStream rndInfStream = new Random().ints(1, 1000);
       // rndInfStream.forEach(System.out::println);

        //fetch a list of 10 even pseudorandom integer values
        List<Integer> result = rndInfStream
                .filter(i -> i % 2 == 0)
                .limit(10)
                .boxed()
                .collect(Collectors.toList());
             result.forEach(System.out::println);
       //we could fetch a List of random even integers until the first generated
        //value is less than 50:
        System.out.println("value is less than 50:");
        List<Integer> result2 = new Random().ints(1, 100)
                .filter(i -> i % 2 == 0)
                .takeWhile(i -> i >= 50)
                .boxed()
                .collect(Collectors.toList());
        result2.forEach(System.out::println);


        //a List of random passwords until the first generated password
        //doesn't contain the ! character


    }
}
