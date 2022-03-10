package com.streams.buildstreams;

import java.util.stream.Stream;

public class InfiniteStreams {
    public static void main(String args[]){
        Stream.iterate(0, n -> n + 5)
                .limit(10000000)
                .forEach(System.out::println);
    }
}
