package com.testunit;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Debugginglambdas {
    public static void main(String args[]){
        List<String> list = List.of("anna", "bob","christian", "carmen", "rick", "carla");

        List<Integer> ints = Arrays.asList(1, 2, -4, 0, 2, 0, -1, 14, 0, -1);

        System.out.println("Start words with C");
        list.stream()
                .filter(s -> s.startsWith("c"))
                .map(String::toUpperCase)
                .sorted()

                .forEach(System.out::println);

        System.out.println("End words with A");
        list.stream()
                .filter(s -> s.endsWith("a"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);

        System.out.println("sart a word by A & End words with A");
        list.stream().filter(s -> s.endsWith("a")).
                filter(s->s.endsWith("a")).forEach(System.out::println);

        List<Integer> result = ints.stream()
                .filter(i -> i != 0)
                .collect(Collectors.toList());
        result.stream().forEach(System.out::print);
    }
}
