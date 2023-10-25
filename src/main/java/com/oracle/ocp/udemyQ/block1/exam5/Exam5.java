package com.oracle.ocp.udemyQ.block1.exam5;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
public class Exam5 {
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
    }

    private static void test6() {
        List<String> list1 = new ArrayList<>();
        list1.add("A");
        list1.add("B");

        List<? extends Object> list2 = list1;
        list2.remove("A"); //Line n1
        //list2.add("C"); //Line n2 ERROR COMO SE QUE OBJETO ES

        System.out.println(list2);
    }

    private static void test5() {
        Map<Integer, String> map = new LinkedHashMap<>();
        map.put(null, "zeroW");
        map.put(1, "one");

        System.out.println(map);
    }

    private static void test4() {
        var es = Executors.newSingleThreadExecutor();
        es.execute(() -> System.out.println("HELLO"));
        es.shutdown();

        LocalDate date = LocalDate.ofYearDay(2023, 1);//SI COLOCAS 0 EN DAY SE ROMPE
        System.out.println(date);
    }

    private static void test3() {
        Stream<Integer> stream = Arrays.asList(1,2,3,4,5).stream();
        //System.out.println(stream.sum()); SREAM no tiene el metodo sum, sol IntStream
    }

    private static void test2() {
        Stream.of("A")
                //.map(s -> s.reverse()) reverse no es un metodo de objeto
                .forEach(System.out::println);

        //Optional<Integer> optional = Optional.of(null); //Line n1 OJO, NO PUEDE SER NULO
        //System.out.println(optional.orElse(-1)); //Line n2
    }

    private static void test1() {
        var str = "ALASKA";
        System.out.println(str.charAt(str.indexOf("A") + 1));

        Collection<Integer> list = List.of(100, 100, 100); //Line n1
        Collection<Integer> set = new LinkedHashSet<>(list); //Line n2
        set.forEach((set1) -> System.out.print(set1)); //Line n3 OJO, NO PUEDES USAR EL NOMBRE set
    }
}
