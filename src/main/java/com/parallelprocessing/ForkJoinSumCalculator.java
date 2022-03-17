package com.parallelprocessing;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

public class ForkJoinSumCalculator extends RecursiveTask<Long> {
    private final long[] numbers;
    private final int start;
    private final int end;
    public static final long THRESHOLD = 10_000;

    public ForkJoinSumCalculator(long[] numbers) {
        this(numbers,0,numbers.length);
    }

    public ForkJoinSumCalculator(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        int len = end -start;
        if(len <= THRESHOLD){
          return   computBySeqentially();

        }
        ForkJoinSumCalculator leftTask =  new ForkJoinSumCalculator(numbers, start, start + len/2);
        leftTask.fork();
        ForkJoinSumCalculator rightTask =  new ForkJoinSumCalculator(numbers, start + len/2, end);

        Long rightResult = rightTask.compute();
        Long leftResult = leftTask.join();
        return leftResult + rightResult;
    }

    private long computBySeqentially( ){
        long sum =0;
        for(long num: numbers){
            sum += num;
        }
        return sum;
    }
    public static long forkJoinSum(long n) {
        long[] numbers = LongStream.rangeClosed(1, n).toArray();
        ForkJoinTask<Long> task = new ForkJoinSumCalculator(numbers);
        return new ForkJoinPool().invoke(task);
    }

    public static void main(String args[]){
        long[] inputs = new long[10_000_000];
        Arrays.fill(inputs,10);

        long stratTime = System.currentTimeMillis();
        //System.out.println("lenght of array is " + inputs.length);
        ForkJoinSumCalculator forkJoinSumCalculator = new ForkJoinSumCalculator(inputs);
        forkJoinSumCalculator.compute();
        long endTime = System.currentTimeMillis();
        System.out.println("ForkJoin sum done in :  " + (endTime - stratTime) + " millisecond");


        long stratTimeSequntial = System.currentTimeMillis();
        long sum=0;
        for(long num:inputs){
            sum += num;
        }
        long endTimeSequntial = System.currentTimeMillis();
        System.out.println("Sequential sum done in :  " + (endTimeSequntial - stratTimeSequntial) + " millisecond");
        System.out.println(" sum is :  " + sum + " ");

    }
}
