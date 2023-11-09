package com.oracle.ocp.udemyQ.block2.exam2;
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
public class Exam2 {

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
        var date = LocalDate.of(2022, 11, 4);
        var formatter = DateTimeFormatter.ofPattern("dd-MM-uuuu");
        System.out.println(formatter.format(date).equals(date.format(formatter)));
        System.out.println(SEPARADOR);
    }

    private static void test8() {
        LocalDate d1 = LocalDate.now();
        LocalDateTime d2 = LocalDateTime.now();
        //.out.println(Duration.between(d1, d2));//OJO, DA ERROR PERO ES VALIDO
        var json = """
            {
                "fName":\"%s\",
                "lName":"%s"
            }
            """.formatted("Udayan", "Khattry");
        System.out.println(json);
        System.out.println(SEPARADOR);
    }

    private static void test7() {
        int x = 7;
        boolean res = x++ == 7 && ++x == 9 || x++ == 9;
        System.out.println("x = " + x);
        System.out.println("res = " + res);
        System.out.println(SEPARADOR);
    }

    private static void test6() {
        Stream.of(2, 4, 6, 8, 10, 12)
                .filter(Predicate.not(Predicate.isEqual(100)))
                .reduce((i1, i2) -> i1 + i2)
                .stream()
                .forEach(System.out::println);
        System.out.println(SEPARADOR);
    }

    private static void test5() {
        var a = 5;
        var x = "+";
        switch(x) {
            case "+" -> a = a + 2; //Line n1
            case "-" -> { a = a - 3; break; } //Line n2
            case "/" -> a = a / 4; //Line n3
            //case "*" : a = a * 3; //Line n4 ESTO DA ERROR
        }
        System.out.println(a);
        System.out.println(SEPARADOR);
    }


    private static void test4() {
        Set<String> set = new HashSet<>(Arrays.asList(null,null,null));
        long count = set.stream().count();
        System.out.println(count);
    }

    private static void test3() {
        String s1 = "1Z0-829";
        String s2 = "1Z0-829" + "";
        System.out.println(s1 == s2);
        System.out.println(SEPARADOR);
    }

    private static void test2() {
        var res = ""; //Line n1
        String [] arr = {"1", "2", "3"};
        for(var s : arr) { //Line n2
            res += String.join(".", s); //Line n3
        }
        System.out.println(res); //Line n4
        System.out.println(SEPARADOR);
    }

    private static void test1() {
        List<Integer> list = new ArrayList<Integer>();

        list.add(27);
        list.add(27);

        list.add(227);
        list.add(227);

        System.out.println(list.get(0) == list.get(1));
        System.out.println(list.get(2) == list.get(3));

        IntStream.iterate(1, i -> i + 1)
                .limit(11)
                .filter(i -> i % 2 != 0)
                .forEach(System.out::print);
        System.out.println(SEPARADOR);
    }
}
