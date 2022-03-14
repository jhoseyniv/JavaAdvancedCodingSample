package com.exceptionhandling.powexp;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class MyCalculator   {

    public static long power(int n, int p) throws Exception {
        if(n < 0 || p < 0 )
            throw new Exception("n or p should not be negative.");
        if(n == 0 && p == 0 )
            throw  new Exception("n and p should not be zero.");

        long pow = 1;
        for (int i = 1; i<= p; i++) pow*= n;
        return  pow;
    }

    public static void main(String args[]) throws Exception {
        long a = power(0,0);
    }

    @TestFactory
    Collection<DynamicTest> dynamicTestArhtmatiecPower(){
        return Arrays.asList(
                dynamicTest("1th dynamic test", () -> assertEquals(32,power(2,5))),
                dynamicTest("2th dynamic test", () -> assertEquals("java.lang.Exception: n and p should not be zero.",power(0,0))),
                dynamicTest("3th dynamic test", () -> assertEquals("java.lang.Exception: n and p should not be zero.",power(-2,-1)))
        );
    }
}
