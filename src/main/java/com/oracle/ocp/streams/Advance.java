package com.oracle.ocp.streams;

import java.io.IOException;
import java.util.*;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;


public class Advance {

    private static final String SEPARADOR = "----------------";

    public static void main(String[] args) {
        Optional<Integer> optional = Optional.of(420);
        threeDigit(optional);
        spliterator();
        basicCollectors();
        grouping();
    }



    private static void threeDigit(Optional<Integer> optional) {
        optional.map(n -> "" + n) // part 1
                .filter(s -> s.length() == 3) // part 2
                .ifPresent(System.out::println); // part 3
    }

    // OJO CON LAS ECEPCIONES
    private static List<String> create() throws IOException {
        throw new IOException();
    }

    public void good() throws IOException {
        Advance.create().stream().count();
    }

    public void bad() throws IOException {
        //Supplier<List<String>> s = Advance::create; // DOES NOT COMPILE
    }

    private static List<String> createSafe() {
        try {
            return Advance.create();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void wrapped() {
        Supplier<List<String>> s2 = Advance::createSafe;
    }

    //Usando Spliterator

    public static void spliterator(){
        var stream = List.of("bird-", "bunny-", "cat-", "dog-", "fish-", "lamb-", "mouse-");
        Spliterator<String> originalBagOfFood = stream.spliterator();
        Spliterator<String> emmasBag = originalBagOfFood.trySplit();
        emmasBag.forEachRemaining(System.out::print); // bird-bunny-cat
        System.out.println();
        Spliterator<String> jillsBag = originalBagOfFood.trySplit();
        jillsBag.tryAdvance(System.out::print); // dog
        System.out.println();
        jillsBag.forEachRemaining(System.out::print); // fish
        System.out.println();
        originalBagOfFood.forEachRemaining(System.out::print); // lamb-mouse
        System.out.println();
        stream.forEach(System.out::print);
        System.out.println();

        var originalBag = Stream.iterate(1, n -> ++n)
                .spliterator();
        Spliterator<Integer> newBag = originalBag.trySplit();
        newBag.tryAdvance(System.out::print); // 1
        System.out.println();
        newBag.tryAdvance(System.out::print); // 2
        System.out.println();
        newBag.tryAdvance(System.out::print); // 3

        System.out.println(SEPARADOR);
    }

    //collectores basicos

    public static void basicCollectors(){
        var ohMy = Stream.of("lions", "tigers", "bears");
        String result = ohMy.collect(Collectors.joining(", "));
        System.out.println(result); // lions, tigers, bears

        var ohMy2 = Stream.of("lions", "tigers", "bears");
        Double result2 = ohMy2.collect(Collectors.averagingInt(String::length));
        System.out.println(result2); // 5.333333333333333

        var ohMy3 = Stream.of("lions", "tigers", "bears");
        TreeSet<String> result3 = ohMy3
                .filter(s -> s.startsWith("t"))
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.println(result3); // [tigers]

        var ohMy4 = Stream.of("lions", "tigers", "bears");
        Map<String, Integer> map4 = ohMy4.collect(
                Collectors.toMap(s -> s, String::length));
        System.out.println(map4); // {lions=5, bears=5, tigers=6}


        var ohMy5 = Stream.of("lions", "tigers", "bears");
        Map<Integer, String> map5 = ohMy5.collect(Collectors.toMap(
                String::length,
                k -> k,
                (s1, s2) -> s1 + "," + s2));
        System.out.println(map5); // {5=lions,bears, 6=tigers}
        System.out.println(map5.getClass()); // class java.util.HashMap

        var ohMy6 = Stream.of("lions", "tigers", "bears");
        TreeMap<Integer, String> map6 = ohMy6.collect(Collectors.toMap(
                String::length,
                k -> k,
                (s1, s2) -> s1 + "," + s2,
                TreeMap::new));
        System.out.println(map6); // // {5=lions,bears, 6=tigers}
        System.out.println(map6.getClass()); // class java.util.TreeMap

        System.out.println(SEPARADOR);
    }

    //Grouping, Partitioning, and Mapping

    public static void grouping(){
        var ohMy = Stream.of("lions", "tigers", "bears");
        Map<Integer, List<String>> map = ohMy.collect(
                groupingBy(String::length));
        System.out.println(map); // {5=[lions, bears], 6=[tigers]}

        var ohMy2 = Stream.of("lions", "tigers", "bears");
        Map<Integer, Set<String>> map2 = ohMy2.collect(
                groupingBy(
                        String::length,
                        Collectors.toSet()));
        System.out.println(map2); // {5=[lions, bears], 6=[tigers]}

        var ohMy3 = Stream.of("lions", "tigers", "bears");
        TreeMap<Integer, Set<String>> map3 = ohMy3.collect(
                groupingBy(
                        String::length,
                        TreeMap::new,
                        Collectors.toSet()));
        System.out.println(map3); // {5=[lions, bears], 6=[tigers]}

        System.out.println(SEPARADOR);
    }

    public static void partitioning() {
        var ohMy = Stream.of("lions", "tigers", "bears");
        Map<Boolean, List<String>> map = ohMy.collect(
                Collectors.partitioningBy(s -> s.length() <= 5));
        System.out.println(map); // {false=[tigers], true=[lions, bears]}

        var ohMy2 = Stream.of("lions", "tigers", "bears");
        Map<Boolean, List<String>> map2 = ohMy2.collect(
                Collectors.partitioningBy(s -> s.length() <= 7));
        System.out.println(map2); // {false=[], true=[lions, tigers, bears]}

        var ohMy3 = Stream.of("lions", "tigers", "bears");
        Map<Boolean, Set<String>> map3 = ohMy3.collect(
                Collectors.partitioningBy(
                        s -> s.length() <= 7,
                        Collectors.toSet()));
        System.out.println(map3); // {false=[], true=[lions, tigers, bears]}

        var ohMy4 = Stream.of("lions", "tigers", "bears");
        Map<Integer, Long> map4 = ohMy4.collect(
                groupingBy(
                        String::length,
                        Collectors.counting()));
        System.out.println(map4); // {5=2, 6=1}

        System.out.println(SEPARADOR);
    }

    public static void mapping() {

        var ohMy = Stream.of("lions", "tigers", "bears");
        Map<Integer, Optional<Character>> map = ohMy.collect(
                groupingBy(
                        String::length,
                        Collectors.mapping(
                                s -> s.charAt(0),
                                Collectors.minBy((a, b) -> a - b))));
        System.out.println(map); // {5=Optional[b], 6=Optional[t]}

    }



}
