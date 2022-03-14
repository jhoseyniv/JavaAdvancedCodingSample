package com.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class SortMelon {

    public static <T> int findIndexOfElementObject( T[] arr, T toFind, Comparator<? super T> c) {
        return IntStream.range(0, arr.length)
                .filter(i -> c.compare(toFind, arr[i]) == 0)
                .findFirst()
                .orElse(-1);
    }

    public static void main(String args[]){
        Melon[] melons = new Melon[]{
            new Melon("A",10), new Melon("B,",23), new Melon("C",12),new Melon("D",3)
        };
        Arrays.parallelSort(melons, new Comparator<Melon>() {
            @Override
            public int compare(Melon o1, Melon o2) {
                return Integer.compare(o1.getWeight(),o2.getWeight());
            }
        });
        Arrays.stream(melons).forEach(el-> System.out.println(el.getWeight()+" - " + el.getType()));
        boolean find =  Arrays.stream(melons).anyMatch(c -> c.getType().equalsIgnoreCase("C"));
        System.out.println("Find = " + find );



    }
}
