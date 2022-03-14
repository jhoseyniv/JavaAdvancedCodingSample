package com.objectimmutablity;

import java.util.*;

public class CheckNullRefrence {

    public static void main(String args[]){
        List<Integer> numbers = new ArrayList<Integer>(
                        Arrays.asList(2,3,4,57,6)
        );
        List<Integer> evenNumbers = new ArrayList<Integer>();
        evenNumbers = evenIntegers(numbers);
        System.out.println("even numbers are = " + evenNumbers.toString());
        System.out.println("Sum of " +numbers.toString()  + " = "+ sumIntgers(numbers));
    }
    public static List<Integer> evenIntegers(List<Integer> numbers) {
        List<Integer> evens = new ArrayList<Integer>();
        if(Objects.isNull(numbers)) return Collections.EMPTY_LIST;
        for (Integer nr: numbers) {{
            if( Objects.nonNull(nr)  && nr %2 == 0) {
                evens.add(nr);
            }
        }}
      return evens;
    }

    public static int sumIntgers(List<Integer> numbers){
        if(Objects.isNull(numbers)) {
            throw new IllegalArgumentException("List can not be null");
        }
        return  numbers.stream().filter(Objects::nonNull).mapToInt(Integer::intValue).sum();
    }

    public static boolean integerContainsNull(List<Integer> integers){
        return integers.stream().anyMatch(Objects::isNull);
    }

}
