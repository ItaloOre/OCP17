package com.oracle.ocp.udemyQ.block2.exam1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
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
    }

    private static void test8() {
    }

    private static void test7() {
        var df1 = new DecimalFormat("###,##,#");
        var df2 = new DecimalFormat("000,00,0");

        System.out.println(df1.format(87654).equals(df2.format(87654)));

        System.out.println(df1.format(1).equals(df2.format(1)));

        System.out.println(df1.format(1234567).equals(df2.format(1234567)));

        System.out.println(df1.format(123456).equals(df2.format(123456)));
    }

    private static void test6() {
        Period period = Period.of(0, 0, 0);
        System.out.println(period);
        System.out.println(SEPARADOR);
        boolean flag = false;
        System.out.println((flag = true) | (flag = false) || (flag = true));
        System.out.println(flag);
        System.out.println(SEPARADOR);
    }

    private static void test5() {
        List<String> list = new LinkedList<>();
        list.add("ONE");
        list.add("TWO");
        list.remove(1);
        System.out.println(list);

        Queue<String> queue = new LinkedList<>();
        queue.add("ONE");
        queue.add("TWO");
        queue.remove();
        System.out.println(queue);
    }

    private static void test4() {
        double d = 1_2_3_4;
        var loc = new Locale("it", "IT");
        System.out.println(loc.getDisplayCountry()); //Line 8
        System.out.println(loc.getDisplayCountry(Locale.US)); //Line 9
        System.out.println(loc.getDisplayLanguage()); //Line 10
        System.out.println(loc.getDisplayLanguage(Locale.US)); //Line 11
        System.out.println(SEPARADOR);
    }

    private static void test3() {
        short [] args = new short[]{50, 50};
        args[0] = 5;
        args[1] = 10;
        System.out.println("[" + args[0] + ", " + args[1] + "]");
        System.out.println(SEPARADOR);
    }

    private static void test2() {
        Stream<Double> stream = Arrays.asList(1.8, 2.2, 3.5).stream();
        //NO PRODUCE ERROR, reduce no tiene nada que ver con modificar los valores del stream
        System.out.println(stream.reduce((d1, d2) -> d1 + d2)); //Line n1
        System.out.println(SEPARADOR);

    }
    record Student(String name, int age) {}
    private static void test1() {
        //File file = new File("C:aaaa/B/C");
        //file.mkdirs(); recuerda que File es mkdirs y Path es makedirectories
        Set<Student> students = new TreeSet<>();
        //error porque record no implemente cmoparable
        //students.add(new Student("Samuel", 21));
        //students.add(new Student("Samuel", 21));
        //students.add(new Student("Samuel", 21));

        System.out.println(students.size());
        System.out.println(SEPARADOR);

    }
}


