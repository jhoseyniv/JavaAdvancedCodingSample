package com.streams.buildstreams;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class StreamFromFile {
    public static void main(String args[]) throws IOException {
        Stream<String> lines = Files.lines(Paths.get("src/com/streams/buildstreams/input.txt"), Charset.defaultCharset());
        //long  uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" "))).distinct().count();

        lines.forEach(System.out::println);
    }
}
