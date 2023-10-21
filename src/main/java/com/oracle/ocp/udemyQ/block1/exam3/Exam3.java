package com.oracle.ocp.udemyQ.block1.exam3;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

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
        LocalTime t1 = LocalTime.parse("11:03:15.987");
        System.out.println(t1.plus(22, ChronoUnit.HOURS)
                .equals(t1.plusHours(22)));
    }

    private static void test8() {
        LongStream.iterate(0, i -> i + 2)
                .limit(4)
                .forEach(System.out::print);
        System.out.println(SEPARADOR);
    }

    private static void test7() {
        var date = LocalDate.of(2023, Month.FEBRUARY, 1);
        //recuerda que DD es dia del mes
        var formatter = DateTimeFormatter.ofPattern("DD'nd day of' uuuu");
        System.out.println(formatter.format(date));
    }

    private static void test6() {
        List<String> names = Arrays.asList("James", "diana", "Anna");
        //ORDEN NATURAL, MAY,MIN,NUMERO
        Collections.sort(names);
        System.out.println(names);
    }

    private static void test5() {
        var list = List.of("S", "P", "I", "R", "I", "T");
        list.forEach(System.out::print);
        list.stream().forEach(System.out::print);
        list.stream().map(Function.identity()).forEach(System.out::print);
        list.parallelStream().forEachOrdered(System.out::print);
        System.out.println(list.stream().collect(Collectors.joining()));
    }

    private static void test4() {
        int i = 10;
        System.out.println(i > 3 != false);

        //OJO cuando uso Set.of no puede ser repetido y no es posible usar null
        //java.lang.IllegalArgumentException
       //Set<String> set = Set.of("A", "E", "I", "I", null, "O", "U");
       //System.out.println(set.size());
    }

    interface Printer {
        void print();
    }
    private static void test3() {
        char [] arr1 = {'A'};
        char [] arr2 = {'A', 'A', 'A', 'A'};
        //OJO CON EL COMPARE, PRIMERO COMPARA VALOR, SINO COMPARA LONGITUD
        System.out.println(Arrays.compare(arr1, arr2));

        int i = 400;
        Printer obj = () -> System.out.println(8);
        obj.print();
        System.out.println(++i);
    }

    private static void test2() {
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("*", 1);
        map.put("$", 3);
        map.put("#", 5);

        map.forEach((p,q) -> System.out.println(p.repeat(q)));
    }

    private static void test1() {
        var javaworld = "JavaWorld";
        var java = "Java";
        var world = "World";
        java += world;
        System.out.println(java == javaworld);
    }
}
