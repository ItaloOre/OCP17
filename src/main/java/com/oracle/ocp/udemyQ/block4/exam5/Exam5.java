package com.oracle.ocp.udemyQ.block4.exam5;
import java.util.stream.IntStream;
import java.util.stream.Stream;
public class Exam5 {
    public static final String SEPARADOR = "-------------";

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
        test8();
        test9();
    }

    private static void test9() {

        System.out.println(SEPARADOR);
    }

    private static void test8() {
        System.out.println(SEPARADOR);
    }

    private static void test7() {
        System.out.println(SEPARADOR);
    }

    private static void test6() {
        System.out.println(SEPARADOR);
    }

    private static void test5() {
        System.out.println(SEPARADOR);
    }

    private static void test4() {
        System.out.println(SEPARADOR);
    }

    private static void test3() {
        System.out.println(SEPARADOR);
    }

    private static void test2() {

        Stream<StringBuilder> stream = Stream.of();
        stream.map(s -> s.reverse())
                .forEach(System.out::println);
        System.out.println(SEPARADOR);
    }

    private static void test1() {

        int sum = IntStream.rangeClosed(1,3)
                .map(i -> i * i)
                .map(i -> i * i)
                .sum();
        System.out.println(sum);
        System.out.println(SEPARADOR);
    }
}
