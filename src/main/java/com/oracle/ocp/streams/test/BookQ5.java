package com.oracle.ocp.streams.test;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class BookQ5 {

    private static final String SEPARADOR = "----------------";

    public static void main(String[] args) {
        tes1();
        tes1();
    }

    private static void tes1(){
        //OJO, el boxed() pasa de int a INTEGER
        double result = LongStream.of(6L, 8L, 10L)
                .mapToInt(x -> (int) x)
                .boxed()
                .collect(Collectors.groupingBy(x -> x))
                .keySet()
                .stream()
                .collect(Collectors.averagingInt(x -> x));
        System.out.println(result);


        double result2 = LongStream.of(6L, 8L, 10L)
                .mapToInt(x -> (int) x)
                .boxed()
                .collect(Collectors.groupingBy(x -> x, Collectors.toSet()))
                .keySet()
                .stream()
                .collect(Collectors.averagingInt(x -> x));
        System.out.println(result2);
    }
}
