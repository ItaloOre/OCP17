package com.oracle.ocp.udemyQ.block3.exam6;
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
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.function.*;
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

        var word = "REBUS";
        /* INSERT */
        word = word.substring(2);
        //word = word.substring(2, 5);
        //word = word.replace("RE", "");
        //NO FUNCIONAN
        //word = word.substring(2, 4);
        //word = word.substring(2, 6);
        //word = word.delete(); No existe

        System.out.println(word);

        System.out.println(SEPARADOR);
    }

    private static void test2() {
        Date date = new Date();
        LocalDate localDate = null; //Line n1
        System.out.println(SEPARADOR);
    }

    private static void test1() {
        var loc = new Locale("en", "US");
        var nf = NumberFormat.getCurrencyInstance(loc);
        System.out.printf("Amount %s is in %s" , nf.format(10), nf.getCurrency());
        System.out.println(SEPARADOR);
    }
}

