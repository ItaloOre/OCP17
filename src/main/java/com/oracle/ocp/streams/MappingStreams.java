package com.oracle.ocp.streams;

import java.util.ArrayList;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class MappingStreams {

    public static void main(String[] args) {
        Stream<String> objStream = Stream.of("dog", "cat");
        IntStream intStream1 = objStream.mapToInt(s -> s.length());

        var integerList = new ArrayList<Integer>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        IntStream instStram1 = integerList.stream().flatMapToInt(x -> IntStream.of(x));
        DoubleStream doubleStream = integerList.stream().flatMapToDouble(x -> DoubleStream.of(x));
        LongStream longs = integerList.stream().flatMapToLong(x -> LongStream.of());


        var stream = IntStream.rangeClosed(1,10);
        OptionalDouble optional = stream.average();// <--- es para primitivos
        //Optional<Double> <--- es para wrappers
        optional.ifPresent(System.out::println);
        System.out.println(optional.getAsDouble());
        System.out.println(optional.orElseGet(()-> Double.NaN));

    }

    private static Stream<Integer> mapping(IntStream stream) {
        return stream.mapToObj(x -> x);
    }
    private static Stream<Integer> boxing(IntStream stream) {
        return stream.boxed();
    }

}
