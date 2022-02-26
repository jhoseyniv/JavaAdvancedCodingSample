package com.objectimmutablity;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class SubRange {
    private static final int N_UPPER_BOUND=101;

    private final int n;
    public SubRange(int n) {
        if(Objects.checkIndex(n, N_UPPER_BOUND) < 0) {
            throw new IndexOutOfBoundsException("index out of bound");
        }
        this.n = n;
    }

    public int yMinusX(int x, int y) {
        return y - x;
    }
    @TestFactory
    Collection<DynamicTest> test_RangeCheck() {
        return Arrays.asList(
                dynamicTest("first test ",
                        ()->assertEquals( new Character('d'), new Character(' ')) )
                );

    }
        public static void main(String args[]){
        SubRange subRange1 = new SubRange(100);
        SubRange subRange2 = new SubRange(1);
        SubRange subRange3 = new SubRange(0);

    }

}
