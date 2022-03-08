package com.streams.foodsample;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamFilteringSample {
    public static void main(String args[]){
        List<Integer> numbers = Arrays.asList(2,1,3,4,6,2,4,8,2,4,6,5,12,11,7,9,13,12,4,6,4,6);

        //distinct method on even numbers in above list
        numbers.stream().filter(num -> num % 2 == 0 ).distinct().forEach(System.out::println);

        //Slicing using a predicate
        //Java 9 added two new methods that are useful for efficiently selecting elements in a stream: takeWhile and dropWhile
        List<Dish> specialMenu = Arrays.asList(
                new Dish("seasonal fruit", true, 120, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER));

        //takeWhile = Takes values while the filter is true, then stops
        System.out.println("All numbers that less than 4 ...............By Filter");
        numbers.stream().filter(num -> num < 4).forEach(num -> System.out.print(num + " , "));

        System.out.println("\nAll numbers that less than 4 ...............By TakeWhile method");
        numbers.stream().takeWhile(num -> num < 4).forEach(num -> System.out.print(num + " , "));

        System.out.println("\nAll numbers dividable by 2  ...............By Filter");

        Stream.of(1,2,3,4,5,6,7,8,9,10).filter(i -> i % 2 == 0 )
                .forEach(System.out::println);

        System.out.println("\nAll numbers dividable by 2  ...............By TakeWhile");
        Stream.of(1,2,3,4,5,6,7,8,9,10).takeWhile(i -> i % 2 == 0 )
                .forEach(System.out::println);

        //The dropWhile method does the opposite of the takeWhile. If it finds the first element that does not match its predicate,
        // it discards all items that came before that unmatching element.

        System.out.println("\n find first numbers dividable by 2  and left other items ...............By DropWhile");
        numbers.stream().dropWhile(num -> num % 2 != 0).forEach(num -> System.out.print(num + " , "));

    }

}
