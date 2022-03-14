package com.Fibonachi.unittest;

import com.Fibonachi.FibonacciNumbers;
import com.Fibonachi.FiboonachiValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

public class TestFibonacciNumbers {


    @Test
    @Timeout(value = 10000, unit = TimeUnit.MILLISECONDS)
    void failsIfExecutionTimeExceeds100Milliseconds() {
        FibonacciNumbers.getFiboByRecurseive(40);
    }
    @Test
    @Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
    void failsIfExecutionTimeExceeds100Milliseconds2() {
        FibonacciNumbers.getFiboByDynamicProgramming(400);
    }




    @ParameterizedTest
    @ValueSource(ints = { 1, 2,13,21 })
    void palindromes(int fib) {
        assertEquals(true,FiboonachiValidator.checkIsANumberFibonacciByBrutForce((fib) ));
    }

}

