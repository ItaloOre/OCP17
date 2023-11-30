package com.oracle.ocp.udemyQ.block3.exam1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.DoublePredicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Exam1 {
    public static final String SEPARADOR = "-------------";

    public static void main(String[] args) throws ParseException {
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

    private static void test7() throws ParseException {

        var nf = NumberFormat.getIntegerInstance();
        Stream.of(nf.parse("10.49"), nf.parse("10.50"), nf.parse("10.51"))
                .map(x -> "" + x)
                .forEachOrdered(System.out::print);
        //10,10,10
        System.out.println(SEPARADOR);
    }

    private static void test6() {

        String txt = "an";
        System.out.println(txt.split("an").length);
        System.out.println(SEPARADOR);
    }

    private static void test5() {

        String[] arr = { "L", "I", "V", "E" }; //Line n1
        int i = -2;

        if (i++ == -1) { //Line n2
            arr[-(--i)] = "F"; //Line n3
        } else if (--i == -2) { //Line n4
            arr[-++i] = "O"; //Line n5
        }

        System.out.println(String.join("", arr)); //Line n6
        System.out.println(SEPARADOR);
    }

    private static void test4() {

        Object[] locale = Locale.getAvailableLocales();
        Locale[] locale2 = Locale.getAvailableLocales();
        System.out.println(SEPARADOR);
    }

    private static void test3() {
        var sb = new StringBuilder(20); //Line n1
        sb.append("A".repeat(25)); //Line n2
        System.out.println(sb.toString().length()); //Line n3

        sb.setLength(10); //Line n4
        System.out.println(sb.toString().length()); //Line n5

        System.out.println(SEPARADOR);
    }

    private static void test2() {

        Optional<Integer> optional = Stream.of(10).findFirst();
        System.out.println(optional);
        System.out.println(SEPARADOR);
    }

    private static void test1() {
        byte b1 = (byte) (127 + 21);//-108
        System.out.println(b1);
        System.out.println(SEPARADOR);
    }
}

