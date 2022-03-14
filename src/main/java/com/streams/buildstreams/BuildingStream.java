package com.streams.buildstreams;

import java.util.Arrays;
import java.util.stream.Stream;

public class BuildingStream {
    public static void main(String args[]){
        //You can create a stream with explicit values by using the static method Stream.of,
        Stream<String> messageStream = Stream.of("any","programmer","Should","Follow","Up","Clean","Code","Rules","And","Regulations");
        messageStream.map(String::toUpperCase).forEach(System.out::println);

        //empty stream using the empty method as follows
        Stream<String> empty = Stream.empty();

        //Stream from nullable :For example, the method System.getProperty returns null if there
        //is no property with the given key
        Stream<String> homeValueStream = Stream.ofNullable(System.getProperty("home"));

        Stream<String> values =
                Stream.of("config", "home", "user")
                        .flatMap(key -> Stream.ofNullable(System.getProperty(key)));

        //Streams from arrays
        int[] numbers = {4,5,6,7,8,2,5};
        int sum = Arrays.stream(numbers).sum();

    }
}
