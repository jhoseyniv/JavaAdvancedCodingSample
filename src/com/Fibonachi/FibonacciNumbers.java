package com.Fibonachi;
public class FibonacciNumbers {

    public static long getFiboByRecurseive(int n){
        if(n == 0  )
            return  0;
        if(n == 1  )
            return  1;
        return getFiboByRecurseive(n-1) + getFiboByRecurseive(n -2);
    }

    public static int[] getFiboByDynamicProgramming(int n) {
        int fibos[] = new int[n];
        fibos[0] = 0 ;
        fibos[1] = 1;
        for (int i=2;i<n;i++) {
            fibos[i] = fibos[i-1] + fibos[i-2];
        }
        return fibos;
    }
    public static long factorial(int n){
        if(n == 1)
            return  1;
        return
                n*factorial(n-1);
    }

    public static void main(String args[]){
        int n =10;
//        int numbers[]=new int[n+1];
//        for( int i=0;i<n ; i++)   System.out.print(fiboRecurseive(i) + " , ");
//        System.out.println("\n");
//        numbers = fiboDP(n);
//        for ( int i=0;i<n;i++) System.out.print(numbers[i] + " , ");
        int f =10;

        System.out.println( factorial(6));
    }
}
