package com.oracle.ocp.streams;

import java.util.ArrayList;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrimitiveStream {

    private static final String SEPARADOR = "----------------";

    public static void main(String[] args) {
        prueba1();
    }

    private static void prueba1() {

        Stream<Integer> stream = Stream.of(1,2,3,4,5);
        System.out.println(stream.reduce(0,(s,n) -> s + n));

        Stream<Integer> stream2 = Stream.of(1,2,3,4,5);
        System.out.println(stream2.mapToInt(x -> x).sum());

        IntStream intStream = IntStream.of(1,2,3);
        // int suma = intStream.sum();
        //System.out.println(suma);

        OptionalDouble avg = intStream.average();
        System.out.println(avg.getAsDouble());

        var random = DoubleStream.generate(Math::random);
        random.limit(5).forEach(System.out::println);

        IntStream range = IntStream.range(1,5);
        range.forEach(System.out::println);// SOLO IMPRIME DEL 1 AL 4

        IntStream range2 = IntStream.rangeClosed(1,5);
        range2.forEach(System.out::println);// SOLO IMPRIME DEL 1 AL 5



        Stream<String> objStream = Stream.of("dog", "cat");
        IntStream intStream1 = objStream.mapToInt(s -> s.length());

        var integerList = new ArrayList<Integer>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        IntStream instStram1 = integerList.stream().flatMapToInt(x -> IntStream.of(x));

        DoubleStream doubleStream = integerList.stream().flatMapToDouble(x -> DoubleStream.of(x));

        System.out.println(SEPARADOR.concat(SEPARADOR));
    }
}
