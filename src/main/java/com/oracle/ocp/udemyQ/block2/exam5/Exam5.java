package com.oracle.ocp.udemyQ.block2.exam5;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.function.DoubleFunction;
import java.util.function.DoubleUnaryOperator;
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

        System.out.println(SEPARADOR);
    }

    private static void test8() {
        System.out.println(SEPARADOR);
    }

    private static void test7() {
        System.out.println(SEPARADOR);
    }

    private static void test6() {
        Instant instant = Instant.now();
        //LocalDateTime obj = instant.toLocaleDateTime; //Line n1 NO EXISTE
        LocalDateTime obj = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
        System.out.println(SEPARADOR);
    }

    private static void test5() {

        DoubleFunction<DoubleUnaryOperator> func = m -> n -> m + n; //Line n1
        System.out.println(func.apply(11).applyAsDouble(24)); //Line n2
        System.out.println(SEPARADOR);
        String [] cities = {"Seoul", "Tokyo", "Paris", "London",
                "Hong Kong", "Singapore"};
        Arrays.stream(cities)
                .sorted((s1,s2) -> s2.compareTo(s1))
                .forEach(System.out::println);
        //var[] arr = new int[2]; //Line n1 ERROR
    }

    private static void test4() {

        System.out.print("Enter some text: ");
        try(Scanner scan = new Scanner(System.in)) {
            //String s = scan.nextLine();
            System.out.println("s");
            scan.close();
            scan.close();//NO OCURRE NADA
        }
        System.out.println(SEPARADOR);
    }

    private static void test3() {

        NavigableMap<Integer, String> map = new TreeMap<>();
        map.put(25, "Pune");
        map.put(32, "Mumbai");
        map.put(11, "Sri Nagar");
        map.put(39, "Chennai");

        System.out.println(map.headMap(25, true));//ojoo
        System.out.println(SEPARADOR);
        System.out.println("1" + "2" + "3" == "1" + "2" + "3");
        System.out.println(SEPARADOR);

        LocalDate date1 = LocalDate.parse("1947-08-15", DateTimeFormatter.ISO_DATE);
        LocalDate date2 = LocalDate.parse("1947-08-15", DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate date3 = LocalDate.of(1947, 8, 15);

        System.out.println(date1.equals(date2) + " : " + date2.equals(date3));//true : true
        System.out.println(SEPARADOR);
    }

    interface Operation {
        long operate(Integer x, Integer y);
    }
    private static void test2() {

        int x = 10;
        int y = 20;
        //Operation o1 = (int m, Integer n) -> m * n;//ERROR
        //Operation o1 = (var m, Integer n) -> m * n;//ERROR
        Operation o1 = (var m, var n) -> m * n;
        System.out.println(o1.operate(5, 10));
        System.out.println(SEPARADOR);
    }

    private static void test1() {

        String [] arr = {"1st", "2nd", "3rd", "4th", "5th"};
        var place = "faraway";
        System.out.println(arr[place.indexOf("a", 3)]); //Line n1
        LocalDate date = LocalDate.ofEpochDay(1);//1970-01-02
        System.out.println(date);

        int [] arr2 = {2, 1, 0};
        for(int i : arr2) {
            System.out.println(arr2[i]);
        }

        System.out.println(SEPARADOR);

    }

}
