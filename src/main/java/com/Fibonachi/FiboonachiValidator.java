package com.Fibonachi;

import org.junit.jupiter.api.DynamicTest;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.TestFactory;
import java.util.Arrays;
import java.util.Collection;

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
    @TestFactory
    Collection<DynamicTest> testFiboNumbersByEquation(){
        return Arrays.asList(
                dynamicTest("first test",()->assertEquals(true,checkIsANumberFiboByEquation(2)) ),
                dynamicTest("two test",()->assertEquals(true,checkIsANumberFiboByEquation(5)) ),
                dynamicTest("three test",()->assertEquals(true,checkIsANumberFiboByEquation(13)) ),
                dynamicTest("four test",()->assertEquals(true,checkIsANumberFiboByEquation(22)) )

        );
    }
    public static void main(String args[]){


    }
}
