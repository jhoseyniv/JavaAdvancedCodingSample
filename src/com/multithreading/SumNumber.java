package com.multithreading;

import java.util.Arrays;
import java.util.Date;

public class SumNumber {

    public static void sumByLoop(int[] stats){
        long sum = 0;
        Arrays.fill(stats,1);

        for (int i = 0; i < stats.length; i++) {
           // System.out.println(i);
            sum += stats[i];
        }
    }

    public static void main(String args[]){
        int[] stats = new int[100000000] ;

        long start1 = new Date().getTime();
         sumByLoop(stats);
         sumByLoop(stats);
         sumByLoop(stats);
        sumByLoop(stats);
        sumByLoop(stats);
        sumByLoop(stats);
        sumByLoop(stats);
        sumByLoop(stats);
        sumByLoop(stats);
        sumByLoop(stats);

        long end1 = new Date().getTime();
        System.out.println(end1 - start1 + " mili seconds.");


        long start2 = new Date().getTime();
        for(int i=0;i<10;i++) {
            long result1 = Arrays.stream(stats).parallel().sum();
        }
        long end2 = new Date().getTime();
        System.out.println(end2 - start2 + " mili seconds.");


        long start3 = new Date().getTime();
        for(int i=0;i<10;i++) {
            long result1 = Arrays.stream(stats).sum();
        }
        long end3 = new Date().getTime();
        System.out.println(end2 - start2 + " mili seconds.");

    }
}
