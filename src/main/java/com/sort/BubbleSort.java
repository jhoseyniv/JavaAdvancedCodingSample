package com.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class BubbleSort {
    public static void bubble(int[] arr){
            int n = arr.length;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }
        Arrays.stream(arr).forEach(a -> System.out.print(a + " , "));
    }

    public static <T> void bubbleSortWithComparator(T arr[], Comparator<? super T> c){
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (c.compare(arr[j], arr[j + 1]) > 0) {
                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            Arrays.stream(arr).forEach(a -> System.out.print(a + " , "));

        }
    }

    public static boolean findElement(int[] arr , int contain){
        return  Arrays.stream(arr).anyMatch(c -> c == contain);
    }
    public static int findIndexOfElement(int[] arr, int toFind) {
        return IntStream.range(0, arr.length)
                .filter(i -> toFind == arr[i])
                .findFirst()
                .orElse(-1);
    }
    public static void main(String args[]){
        //time complexity is O(n^2) in worse case and memory complexity is O(1)
        int[] arr ={5,6,3,23,67,2,45,12,45,7,0,-2,23,-19,11,5};
        BubbleSort.bubble(arr);

        Melon[] melons = new Melon[]{
                new Melon("A",10), new Melon("B,",23), new Melon("C",12),new Melon("D",3)
        };

        // Ascending
        Comparator<Melon> byType = Comparator.comparing(Melon::getType);
       BubbleSort.bubbleSortWithComparator(melons,byType);

       int index =  Arrays.binarySearch(arr, 12);
       System.out.println(index);

        boolean find = findElement(arr , -9);
        System.out.println("find = " + find);

        int location = BubbleSort.findIndexOfElement(arr,45);
        System.out.println("location = " + location);

    }

}

