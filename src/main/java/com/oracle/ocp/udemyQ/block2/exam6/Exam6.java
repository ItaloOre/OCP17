package com.oracle.ocp.udemyQ.block2.exam6;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.DayOfWeek;
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

    private static void test9() {
        var file1 = new File("F:\\A\\B\\D\\..\\C\\Book.java");
        var file2 = new File("F:\\A\\B\\.\\.\\C\\Book.java");
        System.out.println(file1.toPath().equals(file2.toPath()));//FALSE
        System.out.println(SEPARADOR);
    }

    private static void test8() {
        IntStream stream = new Random().ints(1, 7).limit(2);
        System.out.println(stream.max().getAsInt());
        var sb = new StringBuilder("TOMATO");
        //System.out.println(sb.reverse().replace("O", "A")); //Line n1 ERROR
        System.out.println(SEPARADOR);
    }

    private static void test7() {
        LocalDate joiningDate = LocalDate.parse("2006-03-16");
        System.out.println(joiningDate.withDayOfYear(29));//2006-01-29
        List<StringBuilder> list = new ArrayList<>();
        list.add(new StringBuilder("abc"));
        list.add(new StringBuilder("xyz"));
        list.stream()
                .map(x -> x.reverse());//.toList();
        System.out.println(list);
        System.out.println(SEPARADOR);
    }

    private static void test6() {
        var l1 = new Locale.Builder().setLanguage("en").setRegion("US").build();
        var l2 = Locale.US;
        var l3 = new Locale("en");

        System.out.println(l1.equals(l2));//true
        System.out.println(l2.equals(l3));//false
        System.out.println(SEPARADOR);
    }

    private static void test5() {
        int [] arr = {10, 20, 30}; //Line n1
        int i = 0;
        arr[i++] = arr[++i] = 40; //Line n2 funciona
        for(var x : arr) //Line n3
            System.out.println(x);
        System.out.println(SEPARADOR);
    }

    private static void test4() {
        var list1 = List.of("A", "B");
        var list2 = List.of("B", "C");
        //list1.retainAll(list2);//NO SE PUDE HACER POR EL PRINCIPIO DE INMUTABILIDAD
        System.out.println(list1.size());
        System.out.println(SEPARADOR);
    }

    private static void test3() {
        var str = "\"{0} x {0} x {0}\" = {1}";//PJP CPN LAS SALIDAS
        System.out.println(MessageFormat.format(str, 3, 3*3*3));
        System.out.println(SEPARADOR);
    }

    private static void test2() {
        LocalDateTime dt = LocalDateTime.parse("2018-03-16t10:15:30.22");//t minuscula valido
        System.out.println(dt.toLocalDate() + " " + dt.toLocalTime());
        System.out.println(SEPARADOR);
        var nf = NumberFormat.getIntegerInstance();
        System.out.println(nf.format(-1.5).equals(nf.format(-2.5)));//OJO, ES TRUE
        System.out.println(SEPARADOR);
    }

    private static void test1() {
        var str = "BEVERAGE";
        var arr = str.split("E", 3);
        System.out.println(String.join(".", arr));
        System.out.println(SEPARADOR);
        String a;
    }
}
