package com.streams;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.IntStream;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;
public class FindPrimeNumber {
    public static boolean isPrime(int number){
        boolean isPrime = IntStream.range(2,number).noneMatch(n -> number % n == 0);
        return  isPrime;
    }
    public static void main(String args[]){
        System.out.println(" 2 is " + isPrime(2) + " prime");
        System.out.println(" 5 is " + isPrime(5) + " prime");
        System.out.println(" 12 is " + isPrime(12) + " prime");
        System.out.println(" 21 is " + isPrime(21) + " prime");
        System.out.println(" 23 is " + isPrime(23) + " prime");

    }

    @TestFactory
    Collection<DynamicTest> testFoctroyForPrimeNumbers(){
        return Arrays.asList(
                dynamicTest("test 2 is prime ",() -> assertEquals(true, isPrime(2)) ),
                dynamicTest("test 5 is prime ",() -> assertEquals(true, isPrime(5)) ),
                dynamicTest("test 5 is prime ",() -> assertEquals(true, isPrime(13)) ),
                dynamicTest("test 5 is prime ",() -> assertEquals(true, isPrime(12)) )
        );
    }
}
