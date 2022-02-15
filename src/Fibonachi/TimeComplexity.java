package Fibonachi;

import java.util.Date;

public class TimeComplexity {
    public static void main(String[] args){

        //time for fibo recuresive
        long start1= new Date().getTime();
        FibonacciNumbers.getFiboByRecurseive(30);
        long end1= new Date().getTime();
        long difference = end1 - start1;
        System.out.println(difference + " mili seconds.");

        //time for fibo dynamic programming
        long start2= new Date().getTime();
        FibonacciNumbers.getFiboByDynamicProgramming(1500000);
        long end2= new Date().getTime();
        long difference2 = end2 - start2;

        System.out.println(difference2 + " mili seconds.");
    }


}
