package com.oracle.ocp.udemyQ.block3.exam2;

import java.nio.file.Paths;
import java.text.NumberFormat;
import java.util.Locale;

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

        var s1 = """
            1Z0-829""";
        var s2 = """
            1Z0-829
            """;
        var s3 = """
            1Z0-829\
            """;
        //false:false:true
        System.out.println((s1 == s2) + ":" + (s2 == s3) + ":" + (s1 == s3));
        System.out.println(SEPARADOR);
    }

    private static void test2() {

        var path = Paths.get("A", "..", "B", "..").normalize();
        System.out.println(path);
        System.out.println(path.getNameCount());//PORQUE ES UNO
        System.out.println(path.getName(0).toString().length());

        System.out.println(SEPARADOR);
    }

    private static void test1() {

        Locale.setDefault(Locale.US);
        var nf = NumberFormat.getCompactNumberInstance();
        nf.setMaximumFractionDigits(2);
        System.out.println(nf.format(592_92));//59.29K

        System.out.println(SEPARADOR);
    }
}
