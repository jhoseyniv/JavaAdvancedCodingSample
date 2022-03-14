package com.parallelprocessing;

import java.util.stream.Stream;

public class ParallelActions {

    public static long parallelSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .parallel()
                .reduce(0L, Long::sum);
    }
    public static long sequentialSum(long n) {
        return Stream.iterate(1L, i -> i + 1).limit(n)
                .reduce( 0L, Long::sum);
    }
    public static void main(String[] args){

        long strat = System.currentTimeMillis();
        long sum = sequentialSum(1000000);
        System.out.println("parallel sum is "+ sum);
        long end =System.currentTimeMillis();
        System.out.println("parallel Time by MiliSecond is " + (end -strat));




    }
}
