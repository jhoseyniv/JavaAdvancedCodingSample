package com.checkarray;

import java.util.Arrays;

public class SettingArray {
    public static void main(String args[]){
        int[] arr = new int[10];
        // 1, 1, 1, 1, 1, 1, 1, 1, 1, 1
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }

        Arrays.fill(arr,2);


    }
}
