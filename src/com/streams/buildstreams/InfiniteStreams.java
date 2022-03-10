package com.streams.buildstreams;

import java.util.stream.Stream;

public class InfiniteStreams {
    public static void main(String args[]){
        Stream.iterate(0, n -> n + 5)
                .limit(10)
                .forEach(System.out::println);

        Stream.iterate(new int[]{0,1} , t -> new int[]{t[1],t[0]+t[1]})
                .limit(20)
                .forEach(t -> System.out.println("(" + t[0] + "," + t[1] +")"));


        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1],t[0] + t[1]}).limit(10)
                .map(t -> t[0]).forEach(System.out::println);


        //Similarly to the method iterate, the method generate lets you produce an infinite  stream
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);
    }
}
