package com.oracle.ocp.udemyQ.block3.exam3;

import java.sql.CallableStatement;
import java.util.Optional;
import java.util.stream.Stream;

public class Exam3 {
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

        var multiline = """
            SUN \s
            MON \s
            TUE \s
            """;

        multiline.indent(2)
                .lines()
                .map(s -> ">" + s + "<")
                .forEach(System.out::println);
        System.out.println(SEPARADOR);
    }

    private static void test3() { //OOJO REVISAR

        java.util.Arrays.compare(new int [] {10}, null);

        //java.util.Arrays.compare(null, null);

        //java.util.Arrays.mismatch(new char[] {'1'}, null);

        java.util.Arrays.equals(null, new boolean[] {true});
        System.out.println(SEPARADOR);
    }

    private static void test2() {
        Stream<String> stream = Stream.of("a", "as", "an", "and");
        Optional<String> first = stream.findFirst();
       //if(first.ifPresent()) { OJO, QUE NO TE ENGA;E EL KGON
        if(first.isPresent()) {
            System.out.println(first.get());
        }
        System.out.println(SEPARADOR);
    }

    private static void test1() {

        var res = ""; //Line n1
        String [] arr = {"Dog", null, "Friendly"};
        for(String s : arr) { //Line n2
            res += String.join("-", s); //Line n3
        }
        System.out.println(res); //Line n4

        System.out.println(SEPARADOR);
    }
}

