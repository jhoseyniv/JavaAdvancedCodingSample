package com.multithreading;

import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SumNumber {
    private static class Result {
        private long left;
        private long right;
    }
    public static long sumByLoop(int[] stats){
        long sum = 0;
        Arrays.fill(stats,1);
        for(int i=0;i<10;i++) {

            for (int j = 0; j < stats.length; j++) {
                sum += stats[j];
            }
        }
        return sum;
    }
    public static void sumByMultiThreading(int[] stats) throws InterruptedException {
        SumNumber.Result result = new SumNumber.Result();
        Thread t1 = new Thread(() -> { result.left = SumNumber.sumByLoop(stats); } );
        Thread t2 = new Thread(() -> { result.right = SumNumber.sumByLoop(stats); });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(result.left +" , " + result.right);

    }
    public static void ExecutorServiceExample(int[] stats) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Long> y = executorService.submit(() -> SumNumber.sumByLoop(stats));
        Future<Long> z = executorService.submit(() -> SumNumber.sumByLoop(stats));
        System.out.println(y.get() + " , " +  z.get());
        executorService.shutdown();
    }

    public static void main(String args[]) throws InterruptedException, ExecutionException {
        int[] stats = new int[100000000] ;

        long start1 = new Date().getTime();
            sumByLoop(stats);


        long end1 = new Date().getTime();
        System.out.println(end1 - start1 + " mili seconds.");


        long start2 = new Date().getTime();
        for(int i=0;i<10;i++) {
            long result1 = Arrays.stream(stats).parallel().sum();
        }
        long end2 = new Date().getTime();
        System.out.println(end2 - start2 + " mili seconds.");


        long start3 = new Date().getTime();
        for(int i=0;i<10;i++) {
            long result1 = Arrays.stream(stats).sum();
        }
        long end3 = new Date().getTime();
        System.out.println(end2 - start2 + " mili seconds.");



        System.out.println(" sum calcualtion with multithreading in  mili seconds.");
        long start4 = new Date().getTime();
        sumByMultiThreading(stats);
        long end4 = new Date().getTime();
        System.out.println(end4 - start4 + " mili seconds.");


        System.out.println(" sum calcualtion with ExecutorService & Future  in  mili seconds.");
        long start5 = new Date().getTime();
        ExecutorServiceExample(stats);
        long end5 = new Date().getTime();
        System.out.println(end5 - start5 + " mili seconds.");



    }
}
