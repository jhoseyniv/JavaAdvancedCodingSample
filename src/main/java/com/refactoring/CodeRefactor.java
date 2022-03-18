package com.refactoring;

import com.streams.foodsample.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class CodeRefactor {
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

        //goup by dishes by calories...
        Map<Dish.CaloricLevel, List<Dish>> dishesByCaloricLevel =
                menu.stream()
                        .collect(
                                groupingBy(dish -> {
                                    if (dish.getCalories() <= 400) return Dish.CaloricLevel.DIET;
                                    else if (dish.getCalories() <= 700) return Dish.CaloricLevel.NORMAL;
                                    else return Dish.CaloricLevel.FAT;
                                }));


        //goup by dishes by calories...
        Map<Dish.CaloricLevel,List<Dish>> groups = menu.stream().collect(groupingBy(Dish::getCaloricLevel));
        groups.entrySet().forEach(System.out::println);

        int totalCalorieOFMenu = menu.stream().map(Dish::getCalories).reduce(0,(c1,c2)-> c1 + c2);
        System.out.println(totalCalorieOFMenu);

    }
}
