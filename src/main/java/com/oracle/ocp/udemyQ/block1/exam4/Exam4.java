package com.oracle.ocp.udemyQ.block1.exam4;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Stream;

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
    }

    private static void test8() {
    }

    private static void test7() {
        //INVALID DAY
        //LocalDate date = LocalDate.of(2025, 9, 31);
       //System.out.println(date);

    }
    private static void test6() {

    }

    private static void test5() {
        final var str = "+";
        System.out.println(str.repeat(2) == "++");//ES FALSO

        var sb1 = new StringBuilder("A");
        var sb2 = new StringBuilder("B");
        var set1 = Set.of(sb1, sb2); //Line n1
        var set2 = Set.copyOf(set1); //Line n2
        System.out.println((set1 == set2) + ":" + set1.equals(set2)); //Line n3 //true:true
    }

    private static void test4() {
        var str = "Game on"; //Line n1
        var sb = new StringBuilder(str); //Line n2

        System.out.println(str.contentEquals(sb)); //Line n3
        //System.out.println(sb.contentEquals(str)); //Line n4 NO TIENE content EQUALs
        System.out.println(sb.equals(str)); //Line n5
        System.out.println(str.equals(sb)); //Line n6
        System.out.println(SEPARADOR);
    }


    private static void test3() {
        Stream<Integer> stream = Stream.iterate(1, i -> i + 1);
        System.out.println(stream.anyMatch(i -> i > 1));

        System.out.println(700 * Math.pow(2, -2));
        System.out.println(700 * (1 / 4));//DA 0 POURQUE SI DIVIDES 2 ENTEROS SE REDONDEA PARA ABAJO, OJJOO
        System.out.println(7 * Math.ceil(24.80));
    }

    private static void test2() {
        var m = 10; //Line n1
        var n = 20; //Line n2
        var p = m = n = 30; //Line n3
        System.out.println(m + n + p); //Line n4
    }

    private static void test1() {
        String s = new String("Hello");
        List<String> list = new ArrayList<>();
        list.add(s);
        list.add(new String("Hello"));
        list.add(s);
        s.replace("l", "L");

        System.out.println(list);
    }
}
