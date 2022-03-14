package com.parallelprocessing;


import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 2, jvmArgs={"-Xms1G", "-Xmx1G"})
@State(Scope.Thread)
public class ParallelStreamBenchmark {

    public static void main(String args[]) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }

    public static final long N= 10_000_000L;
    @Benchmark
    public long sequentialSum() {
        return Stream.iterate(1L, i -> i + 1).limit(N)
                .reduce( 0L, Long::sum);
    }

    @TearDown(Level.Invocation)
    public void tearDown() {
        System.gc();
    }



}
