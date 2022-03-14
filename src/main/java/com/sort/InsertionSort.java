package com.sort;

import java.util.Arrays;
import java.util.Comparator;

public class InsertionSort {
     // The time complexity cases are as follows: best case O(n), average case O(n2), worst case O(n2)
     // The space complexity case is as follows: worst case O(1)

    public static void insert(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        Arrays.stream(arr).forEach(a -> System.out.print(a + " , "));

    }
    public static <T> void insertWithComparator(
            T arr[], Comparator<? super T> c) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            T key = arr[i];
            int j = i - 1;
            while (j >= 0 && c.compare(arr[j], key) > 0) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
    public static void main(String args[]){
        Comparator<Melon> byType = Comparator.comparing(Melon::getType).thenComparing(Melon::getWeight);
        int[] arr ={5,6,3,23,67,2,45,12,45,7,0,-2,23,-19,11,5};
        InsertionSort.insert(arr);

    }
}
