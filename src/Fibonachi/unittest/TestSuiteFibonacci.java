package Fibonachi.unittest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(value={
                            TestIsANumberFibonacci.class,
                            TestFibonacciNumbers.class
                          })
public class TestSuiteFibonacci {

}
