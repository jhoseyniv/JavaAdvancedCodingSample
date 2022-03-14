package com.checkarray;

import com.sort.Melon;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

public class ReverseArray {

    public static void reverse(int[] arr) {
        for (int leftHead = 0, rightHead = arr.length - 1;  leftHead < rightHead; leftHead++, rightHead--) {
            int elem = arr[leftHead];
            arr[leftHead] = arr[rightHead];
            arr[rightHead] = elem;
        }
        Arrays.stream(arr).forEach(en -> System.out.print(en + " , "));
    }

    public static void main(String args[]){
        int[] integers = {-1, 2, 3, 1, 4, 5, 3, 2, 22};
        //reverse(integers);

        int[] reversed = IntStream.rangeClosed(1, integers.length)
                .map(i -> integers[integers.length - i]).toArray();

        Melon[] melons = {  new Melon("Crenshaw", 2000),  new Melon("Gac", 1200),  new Melon("Bitter", 2200)
        };
        Collections.reverse(Arrays.asList(melons));




    }



}
