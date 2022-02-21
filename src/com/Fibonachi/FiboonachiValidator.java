package com.Fibonachi;

public class FiboonachiValidator {

   public static long[] getFiboSeri(int n){
       long[] series = new long[n];
       series[0] = 0;
       series[1] = 1;
       for (int i=2; i<n; i++) {
           series[i] = series[i-1] + series[i-2];
           System.out.println(series[i]);
       }
       return series;
   }

    public static boolean  checkIsANumberFibonacciByBrutForce(long fibo){
        boolean flag = true;
        boolean isFiboo = false;
        long pervious = 0;
        long current = 1;
        long next = 1;

        while(flag){
            next = current + pervious;
            if( next == fibo ) {
                isFiboo = true;
                flag = false;
            }else if(next > fibo) {
                isFiboo = false;
                flag = false;
            }
            pervious = current;
            current = next;
        }
       return isFiboo;
    }

    public static boolean checkIsANumberFiboByEquation(long n){
       boolean result = false;
       double X1 = 5 * Math.pow(n, 2) + 4;
        double X2 = 5 * Math.pow(n, 2) - 4;

        long X1_sqrt = (long)Math.sqrt(X1);
        long X2_sqrt = (long)Math.sqrt(X2);
        if( X1_sqrt * X1_sqrt == X1 ||
                X2_sqrt*X2_sqrt == X2 ) {
            result = true;
        }else{
            result = false;
        }
        return result;
    }
    public static void main(String args[]){

    }
}
