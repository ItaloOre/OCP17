package com.oracle.ocp.udemyQ.block3.exam4;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
public class Exam4 {
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
        char [] arr1 = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'i', 'j', 'k'};
        char [] arr2 = {'f', 'g', 'a', 'i', 'k'};
        System.out.println(Arrays.mismatch(arr1, 5, 10, arr2, 0, 5));
        System.out.println(SEPARADOR);
    }

    private static void test2() {
        /*INSERT*/
        //var x = 7, y = 200;//'var' is not allowed in a compound declaratio
        long x = 7, y = 200;
        System.out.println(String.valueOf(x + y).length());

        System.out.println(SEPARADOR);
    }

    private static void test1() {

        var x = Math.ceil(10.50) + Math.floor(10.50) + Math.round(10.50);
        System.out.println(x);
        System.out.println(SEPARADOR);
    }
}


