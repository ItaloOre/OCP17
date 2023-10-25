package com.oracle.ocp.udemyQ.block1.exam6;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.ParseException;
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
public class Exam6 {
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

    record Point2D(int x, int y){}
    private static void test9() {
        var p1 = new Point2D(-4, -5);
        var p2 = new Point2D(-4, -5);
        //ESTO ES TRUE TRUE PORQUE
        System.out.println( p1.equals(p2) + ":" + (p1.hashCode() == p2.hashCode()));
    }


    private static void test8() {
        var stream = Stream.of("r", "t", "a");

        var list = stream.map(s -> s.toUpperCase())
                .toList();

        //list.sort(String::compareTo); NO FUNCIONA PORQUE Stream.of ES INMUTABLE

        System.out.println(list);
        System.out.println(SEPARADOR);
    }

    private static void test7() {
        var path = Paths.get("F:\\A\\.\\B\\C\\D\\..\\Book.java");
        path.normalize();
        System.out.println(path);
        Locale l = Locale.US;
        new Locale("en","US");
        System.out.println(SEPARADOR);
    }

    private static void test6() {
        List<String> list = Arrays.asList("7 Seven", "Lucky 7", "77", "O7ne");
        list.stream()
                .filter(str -> str.contains("7"))
                .forEach(System.out::println);
        System.out.println(SEPARADOR);
        var str = "USER GENERATED";
        str = String.join("-", str.split(" "));
        System.out.println(str);
        System.out.println(SEPARADOR);
    }

    private static void test5() { //PUEDE SER NULO SIN PROBLEMA
        try(PrintWriter writer = null) {
            System.out.println("HELLO");
        }
        String s1 = "OCP";
        String s2 = "ocp";
        System.out.println(s1.contentEquals(s2));
        System.out.println(SEPARADOR);
    }

    private static void test4() {
        var nf = NumberFormat.getIntegerInstance();
        System.out.println(Stream.of(nf.format(10.50), nf.format(11.50), nf.format(10.51))
                .mapToInt(x -> Integer.parseInt(x))
                .sum());
        System.out.println(SEPARADOR);
    }

    private static void test3() {
        //PJP QUE NO PUED TENER EL MISMO ID
        var map = Map.of("ONE", 1, "TWO", 2, "THREE", 4); //Line n1
        var res = 0;
        for(Integer num : map.values()) { //Line n2
            res += num;
        }
        System.out.println(res);
        System.out.println(SEPARADOR);
    }

    private static void test2() {
        LocalDateTime dt = LocalDateTime.parse("2025-03-16t10:15:30.22");
        System.out.println(dt);
        System.out.println(SEPARADOR);
    }

    private static void test1() {
        byte var = 127;
        System.out.println(var = (byte)(var +1));
        System.out.println(var);

        var list1 = List.of(); //Line n1
        var list2 = List.of("A"); //Line n2
        //list1 = list2; //Line n3 Error porque uno es de objeto y el otro de String
        System.out.println(list1.size()); //Line n4
        System.out.format("A%nB%nC");
        System.out.println(SEPARADOR);
    }
}
