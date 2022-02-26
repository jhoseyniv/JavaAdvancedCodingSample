package com.sort;

import java.util.Arrays;
import java.util.Comparator;

public class SortMelon {


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
    }
}
