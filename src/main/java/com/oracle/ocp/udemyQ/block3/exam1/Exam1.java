package com.oracle.ocp.udemyQ.block3.exam1;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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
import java.util.concurrent.Executors;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
public class Exam1 {
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
        System.out.println(SEPARADOR);
    }

    private static void test1() {
        int res = 1;
        IntStream stream = IntStream.rangeClosed(1, 4);
        //VALIDO
        System.out.println(stream.reduce(res++, (i, j) -> i * j));

        var x = new int[]{1};
        var y = new int[]{2};
        var z = new int[]{3};
        System.out.println((x = y = z)[0] + y[0] + z[0]); //9 porrque ahora los 3 valen 3
        System.out.println(SEPARADOR);
    }
}