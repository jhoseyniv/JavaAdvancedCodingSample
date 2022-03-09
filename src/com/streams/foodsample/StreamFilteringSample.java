package com.streams.foodsample;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
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
                new Dish("beef", false, 600, Dish.Type.MEAT),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("kebab", false, 600, Dish.Type.MEAT),
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

        System.out.println("\n Test Skip ...............By .....");
        List<Dish> dishes = specialMenu.stream().filter(dish -> dish.getCalories() >= 300).skip(3).toList();
        dishes.stream().forEach(System.out::println);

        System.out.println("\n filter the first two meat dishes ..By .....");
        specialMenu.stream().filter(dish -> dish.getType().equals(Dish.Type.MEAT) ).limit(2).
                forEach(dish -> System.out.println(dish.getName()));

        System.out.println("\n map dishes  calories..By .....");
        List<Integer> calories = specialMenu.stream().map(Dish::getCalories).sorted().toList();
        calories.stream().forEach(System.out::println);

        System.out.println("\n map dishes  name length..By .....");
        List<Integer> dishesNameLenght = specialMenu.stream().map(Dish::getName).map(String::length).toList();
        dishesNameLenght.stream().forEach(System.out::println);


        System.out.println("\n Flat map dishes By  name and Type..By .....");
         List<String> dishesNames =  specialMenu.stream().flatMap(dish-> Stream.of(dish.getName(),dish.getType().toString())).toList();
        List<String> dishesNameLenghtA = specialMenu.stream().map(dish -> String.format("%s: %s :%s",dish.getName(), dish.getName().length(),dish.getType() )).toList();

        dishesNameLenghtA.stream().forEach(System.out::println);

        System.out.println("\n map words  name length..By .....");
        List<String> words = Arrays.asList("Modern", "Java", "In", "Action");
        List<Integer> wordLengths = words.stream()
                .map(String::length)
                .toList();

        List<String> uniqueCharacters =
                words.stream()
                        .map(word -> word.split(""))
                        .flatMap(Arrays::stream)
                        .distinct()
                        .toList();
        for(String s:uniqueCharacters) {
            System.out.println(s);
        }

        System.out.println(" \n return a list of the square of each number..By .....");
         numbers.stream().map(num -> num*num).forEach( num -> System.out.print(num + " , "));
        //In a nutshell, the flatMap method lets you replace each value of a stream with
        //another stream and then concatenates all the generated streams into a single stream


    }
}
