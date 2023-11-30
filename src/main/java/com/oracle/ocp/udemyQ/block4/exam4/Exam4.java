package com.oracle.ocp.udemyQ.block4.exam4;
import java.time.LocalDate;
import java.util.*;

public class Exam4 {
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
        //Anho visiesto
        LocalDate date = LocalDate.parse("1983-06-30");
        System.out.println(date.plusMonths(8));
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

    private static StringBuilder RES = new StringBuilder();
    private static void test3() {
        var list = List.of("A", "B", "C", "D", "E", "F", "G", "H", "I", "J");
        list.parallelStream().forEach(RES::append);
        System.out.println(RES);
        System.out.println(SEPARADOR);
    }

    private static void test2() {

        Optional optional = Optional.empty();
        //System.out.println(optional.get()); generea exepcion
        System.out.println(optional.orElse(new RuntimeException()));
        System.out.println(optional.orElseGet(() -> new RuntimeException()));
        //System.out.println(optional.orElseThrow()); generea exepcion
        //optional.ifPresentOrElse(System.out::print, () -> {throw new RuntimeException();}); //generea exepcion
        System.out.println(SEPARADOR);

    }

    private static void test1() {
        String [] str1 = {"A", "AA", "ABCD"};
        String [] str2 = {"A", "AA", "ABCB"};
        System.out.print(Arrays.mismatch(str1, str2));//2
        System.out.print(Arrays.compare(str1, str2));//2
        System.out.println(SEPARADOR);
    }
}
