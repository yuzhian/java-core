package com.github.yuzhian.java.version.java8.stream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * 构造流
 *
 * @author yuzhian
 */
public class DemoStreamCreate {
    public static void main(String[] args) throws IOException {
        Collection<String> strings = Arrays.asList("1", "2", "3", "12", "13", "23", "13", "2");

        System.out.println("------ Collection.stream()/Arrays.stream() ------");
        strings.stream().mapToInt(Integer::valueOf).forEach(System.out::println);
        Arrays.stream(new String[]{"1", "2", "3", "12", "13", "23", "13", "2"}).forEach(System.out::println);

        System.out.println("------ Collection.parallelStream() ------");
        strings.parallelStream().forEach(System.out::println);

        System.out.println("------ Stream.of()/Stream.builder().build() ------");
        Stream.of("1", "2", "3", "12", "13", "23", "13", "2").forEach(System.out::println);
        Stream.builder().add("1").add("2").add("3").add("12").add("13").add("23").add("13").add("2")
                .build().forEach(System.out::println);

        System.out.println("------ IntStream.range()/of() ------");
        IntStream.range(3, 8).forEach(System.out::println);
        LongStream.of(1L, 2L).forEach(System.out::println);
        DoubleStream.of(1.1, 1.2, 1.3).forEach(System.out::println);

        System.out.println("------ Random.ints() ------");
        new Random().ints(10, 0, 100).forEach(System.out::println);

        System.out.println("------ BufferedReader.lines() ------");
        BufferedReader reader = new BufferedReader(new FileReader("resource/text/languages.txt"));
        reader.lines().forEach(System.out::println);

        System.out.println("------ Files.walk() ------");
        Files.walk(Paths.get("resource/")).forEach(System.out::println);
    }
}
