package com.objectimmutablity;

import java.util.Objects;

public class CheckSubRangeIndex {

    private final int n;
    private static final int N_UPPER_BOUND = 101;
    private static final int N_LOWER_BOUND = 0;
    public CheckSubRangeIndex(int n) {
        Objects.checkIndex(n,N_UPPER_BOUND);
        this.n = n;
    }
    public int yMinusX(int x, int y) {
        Objects.checkFromToIndex(x, y, n);
        return y - x;
    }
    public static void main(String args[]){
        CheckSubRangeIndex f = new CheckSubRangeIndex(50);
        int r = f.yMinusX(30, 20);
    }

}
