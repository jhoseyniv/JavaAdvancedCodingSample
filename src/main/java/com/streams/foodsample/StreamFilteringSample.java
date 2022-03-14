package com.streams.foodsample;

import javax.print.Doc;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Collectors.*;
import java.util.stream.IntStream;
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

        Map<String, List<String>> dishTags = new HashMap<>();
        dishTags.put("pork", Arrays.asList("greasy", "salty"));
        dishTags.put("beef", Arrays.asList("salty", "roasted"));
        dishTags.put("chicken", Arrays.asList("fried", "crisp"));
        dishTags.put("french fries", Arrays.asList("greasy", "fried"));
        dishTags.put("rice", Arrays.asList("light", "natural"));
        dishTags.put("season fruit", Arrays.asList("fresh", "natural"));
        dishTags.put("pizza", Arrays.asList("tasty", "salty"));
        dishTags.put("prawns", Arrays.asList("tasty", "roasted"));
        dishTags.put("salmon", Arrays.asList("delicious", "fresh"));



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


        System.out.println(" \n Given two lists of numbers, how would you return all pairs of numbers..By .....");
        List<Integer> numbers1 = Arrays.asList(2,5,7,1,3);
        List<Integer> numbers2=  Arrays.asList(13,2,4);
        List<int[]> pairNumbers = numbers1.stream().flatMap(num1 -> numbers2.stream().map(num2-> new int[]{num1,num2})).toList();
        pairNumbers.stream().forEach(pair -> System.out.println(pair[0]+" , "+pair[1]));


        //How would you extend the previous example to return only pairs whose sum is divisible by 3
        System.out.println(" \n pair numbers,whose sum is divisible by 3 ..By .....");

        List<int[]> pairNumbers2 = numbers1.stream().flatMap(num1 -> numbers2.stream().map(num2-> new int[]{num1,num2})).toList();
        pairNumbers2.stream().filter(pair -> (pair[0] + pair[1]) % 3 == 0 ).
                forEach(pair -> System.out.println(pair[0]+" , "+pair[1]));


        //In a nutshell, the flatMap method lets you replace each value of a stream with
        //another stream and then concatenates all the generated streams into a single stream

        if(specialMenu.stream().anyMatch(Dish::isVegetarian)) {
            System.out.println("The menu is (somewhat) vegetarian friendly!!");
        }
        if(specialMenu.stream().allMatch(dish ->  dish.getCalories() <800 )){
            System.out.println("The menu is (Fully) Helthy Menu!!");

        }
        if(specialMenu.stream().noneMatch(dish -> dish.getType().equals("MeditrainFOOD"))) {
            System.out.println("The menu is Not Meditrain Menu!!");

        }
        if(specialMenu.stream().noneMatch(dish -> dish.getType().equals(Dish.Type.FISH))) {
            System.out.println("The menu is NOT A See Food Menu!!");

        }else{
            System.out.println("The menu is  A See Food Menu!!");

        }
        Optional<Dish> dish2 = specialMenu.stream().filter(Dish::isVegetarian).findAny();

        specialMenu.stream().filter(dish -> dish.getCalories()>300).findAny().ifPresent(d -> System.out.println(d.getName()));

        System.out.println("The Number suqare is divideable by 3!!");

        List<Integer> someNumber = Arrays.asList(13,2,3,5,6,7,8,4,9,11,12);
        someNumber.stream().filter(n -> n*n % 3 == 0).findFirst().ifPresent(System.out::println);
        int sum = someNumber.stream().reduce(0,(a,b)-> a+b);
        System.out.println("Summ of Numbers is "+ sum);

        //int multiply = someNumber.stream().reduce(0,Integer::sum);

        System.out.println("Summ of Numbers is "+ sum);
        someNumber.stream().reduce(Integer::max).ifPresent(m -> System.out.println(m));


        System.out.println("Sum of the calories of all foods in the menu is "+ sum);
        int sumCalories = specialMenu.stream().map(Dish::getCalories).reduce(0,Integer::sum);
        System.out.println("All Calories is : " + sumCalories);

        System.out.println("Sum of the calories of all foods in the menu BY Map To Int Method ");
        int sumCalories2 = specialMenu.stream().mapToInt(Dish::getCalories).sum();
        OptionalDouble averageCalories = specialMenu.stream().mapToInt(Dish::getCalories).average();

        System.out.println("All Calories is : " + sumCalories2);

        //CONVERTING BACK TO A STREAM OF OBJECTS with Boxed Method
        IntStream intStream = specialMenu.stream().mapToInt(Dish::getCalories);
        Stream<Integer> stream = intStream.boxed();

        OptionalInt maxCalories = specialMenu.stream()
                .mapToInt(Dish::getCalories)
                .max();
        //You can now process the OptionalInt explicitly to define a default value if there’s no maximum:
        int max = maxCalories.orElse(1);

       // String shortMenu = specialMenu.stream().map(Dish::getName).collect(joining());
        String shortMenu = specialMenu.stream().map(Dish::getName).collect(Collectors.joining(", "));
        System.out.println("All dish Names is : " + shortMenu);

        int totalCalories = specialMenu.stream().collect(Collectors.reducing(0, Dish::getCalories, (i, j) -> i + j));

        Optional<Dish> mostCalorieDish =
                specialMenu.stream().collect(Collectors.reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2));



        //grouping dishes by type
        Map<Dish.Type, List<Dish>> disehsByType = specialMenu.stream().collect(Collectors.groupingBy(Dish::getType));

//        Map<Dish.Type, Set<String>> dishNamesByType =
//                specialMenu.stream()
//                        .collect(Collectors.groupingBy(Dish::getType,
//                                Collectors.flatMapping(dish -> dishTags.get( dish.getName() ).stream(),Collectors.toSet())));
//
//        System.out.println(dishNamesByType);

        Map<Dish.Type, Map<Dish.CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel =
        specialMenu.stream().collect(Collectors.groupingBy(Dish::getType,Collectors.groupingBy(dish -> {
                    if(dish.getCalories() <= 300 ) return Dish.CaloricLevel.DIET;
                    else if(dish.getCalories() < 700 ) return Dish.CaloricLevel.NORMAL;
                    else  return  Dish.CaloricLevel.FAT;
                })
        )
        );
        dishesByTypeCaloricLevel.entrySet().forEach(System.out::println);

        Map<Dish.Type,Long> dishTypeCount = specialMenu.stream().collect(Collectors.groupingBy(Dish::getType,Collectors.counting()));
        dishTypeCount.entrySet().forEach(System.out::println);

        //the highest-calorie dish in the menu to achieve a similar result, but now classified by
        //the type of dish:
        Map<Dish.Type,Optional<Dish>> maxCalorieByTypeDish = specialMenu.stream().collect(Collectors.groupingBy(Dish::getType,Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)) ));
        maxCalorieByTypeDish.entrySet().forEach(System.out::println);

        Map<Boolean,List<Dish>> partitionedMenu = specialMenu.stream().collect(Collectors.groupingBy(Dish::isVegetarian));
        partitionedMenu.entrySet().forEach(System.out::println);
        //you could retrieve all the vegetarian dishes by getting from this Map the value
        //indexed with the key true
        List<Dish> vegetarianDishes = partitionedMenu.get(true);

        Map<Boolean,Map<Dish.Type, List<Dish>>> vegetarianDishesByType = specialMenu.stream().
                collect(Collectors.partitioningBy( Dish::isVegetarian,Collectors.groupingBy(Dish::getType) ));
        vegetarianDishesByType.entrySet().forEach(System.out::println);

    }
}
