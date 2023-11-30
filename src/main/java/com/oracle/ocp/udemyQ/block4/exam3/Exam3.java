package com.oracle.ocp.udemyQ.block4.exam3;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
public class Exam3 {
    public static final String SEPARADOR = "-------------";

    public static void main(String[] args) throws IOException {
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

        LocalDate date = LocalDate.parse("1947-08-14");
        LocalTime time = LocalTime.MAX;
        System.out.println(date.atTime(time));//1947-08-14T23:59:59.999999999

        System.out.println(SEPARADOR);
    }

    private static void test4() {

        var date = LocalDate.of(2021, 11, 4);
        var formatter = DateTimeFormatter.ofPattern("DD-MM-uuuu");
        System.out.println(formatter.format(date));

        LocalTime t1 = LocalTime.now();
        LocalDateTime t2 = LocalDateTime.now();
        //System.out.println(Duration.between(t2, t1));//error
        System.out.println(SEPARADOR);
    }

    private static void test3() {
        Stream<String> stream = Stream.of("java", "python", "c",
                "c++", "java", "python");
        Set<String> set = stream.collect(Collectors.toSet());
        System.out.println(set.size());
        System.out.println(SEPARADOR);
    }

    private static void test2() throws IOException {
//        var prop = new Properties ();
//        var fis = new FileInputStream("C:\\Message.properties");
//        prop.load(fis);
//        System.out.println(prop.get("key1")); //Line n1
//        //.out.println(prop.get("key2", "Good Day!")); //Line n2 ERROR
//        System.out.println(prop.getProperty("key3", "Good Day!")); //Line n3
//        System.out.println(prop.getProperty("key4")); //Line n4
//        System.out.println(SEPARADOR);
    }

    private static void test1() {

        IntStream.rangeClosed(1, 10)
                .parallel()
                .forEachOrdered(System.out::println);
        System.out.println(SEPARADOR);
    }

}


