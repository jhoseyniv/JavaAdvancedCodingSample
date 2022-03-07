package com.streams.foodsample;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;

public class SortFoodsByCalori {

    public static void main(String args[]){
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("kebab", false, 700, Dish.Type.MEAT),
                new Dish("chess", false, 400, Dish.Type.DAIRY),
                new Dish("ice cream", false, 250, Dish.Type.DAIRY),
                new Dish("salmon", false, 450, Dish.Type.FISH),
                new Dish("soushi", false, 350, Dish.Type.FISH),
                new Dish("Bread", false, 230, Dish.Type.CARBO),
                new Dish("Spagetii", false, 500, Dish.Type.CARBO)
        );


        List<String> lowCaloricDishesName =
                menu.parallelStream()
                        .filter(d -> d.getCalories() < 400)
                        .sorted(comparing(Dish::getCalories))
                        .map(Dish::getName)
                        .collect(Collectors.toList());
        System.out.println("----Get Dishs that have calories less than 400------------ ");
        lowCaloricDishesName.stream().forEach(d -> System.out.println(d));

        List<Dish> threeHighFoodCalorie = menu.stream().sorted(Comparator.comparingInt(Dish::getCalories).reversed()).
                limit(3).collect(Collectors.toList());

       System.out.println("----Get 3 Dishs with more calories ------------ ");
       threeHighFoodCalorie.stream().forEach(dish -> System.out.println(dish.getName() + "-"+ dish.getCalories()));

        System.out.println("----Get 3 Dishs with low calories ------------ ");
        menu.stream().sorted(Comparator.comparingInt(Dish::getCalories)).limit(3).
                forEach(dish -> System.out.println(dish.getName() + "-"+ dish.getCalories()));

        List<String> titles =Arrays.asList("one","two","three","four","five");
        Stream<String> s1 = titles.stream();
        s1.forEach(System.out::println);
        //if ietrate stream twice... exception will be throw
        //s1.forEach(System.out::println);

        for(String s:titles){
            System.out.println("string is : "+ s);
        }
        //iterate menu by for-each iterate externally
        List<String> names = new ArrayList<String>();
        for(Dish dish:menu){
            names.add(dish.getName());
        }
        // iterate menu list by iterator class externally
        Iterator<Dish> iterator = menu.iterator();
        while(iterator.hasNext()){
            Dish dish =  iterator.next();
            names.add(dish.getName());
        }



        //itreate internally by streams...
        List<String> namesStream = new ArrayList<String>();
        namesStream = menu.stream().map(Dish::getName ).collect(Collectors.toList());

        //refoactor this  code by stream
        List<String> highCaloricDishes = new ArrayList<>();
        Iterator<Dish> iterator2 = menu.iterator();
        while(iterator2.hasNext()) {
            Dish dish = iterator2.next();
            if(dish.getCalories() > 300) {
                highCaloricDishes.add(dish.getName());
            }
        }
        //refactored coded by above....

        List<String> highCaloricDishesStream = new ArrayList<>();
        highCaloricDishesStream = menu.stream().filter(dish -> dish.getCalories() > 300).
                map(Dish::getName).collect(Collectors.toList());
        System.out.println("----Get Dishs with low calories with grater than 300 ------------ ");

        highCaloricDishesStream.stream().forEach(System.out::println);
    }
}
