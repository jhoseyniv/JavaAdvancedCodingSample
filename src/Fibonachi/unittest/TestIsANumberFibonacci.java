package Fibonachi.unittest;


import Fibonachi.FiboonachiValidator;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestIsANumberFibonacci {

    @Test
    public  void isANumberFiboByBrutForce(){
        assertEquals(true, FiboonachiValidator.checkIsANumberFibonacciByBrutForce(1));
        assertEquals(true,FiboonachiValidator.checkIsANumberFibonacciByBrutForce(2));
        assertEquals(true,FiboonachiValidator.checkIsANumberFibonacciByBrutForce(13));
        assertEquals(true,FiboonachiValidator.checkIsANumberFibonacciByBrutForce(21));
        assertEquals(true,FiboonachiValidator.checkIsANumberFibonacciByBrutForce(34));
    }

    @Test
    public  void isANumberFiboByEquatoin(){
        assertEquals(true, FiboonachiValidator.checkIsANumberFiboByEquation(1));
        assertEquals(true, FiboonachiValidator.checkIsANumberFiboByEquation(2));
        assertEquals(true, FiboonachiValidator.checkIsANumberFiboByEquation(13));
        assertEquals(true, FiboonachiValidator.checkIsANumberFiboByEquation(21));
    }




}
