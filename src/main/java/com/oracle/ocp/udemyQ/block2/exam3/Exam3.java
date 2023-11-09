package com.oracle.ocp.udemyQ.block2.exam3;

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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
public class Exam3 {
    public static final String SEPARADOR = "-------------";

    public static void main(String[] args) throws IOException {
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
        for(int x = 10, y = 11, z = 12; y > x && z > y; y++, z -= 2) {
            System.out.println(x + y + z);
        }
        System.out.println(SEPARADOR);

    }

    private static void test8() {
        int [] array1 = {};
        int [] array2 = {100, 200};
        System.out.print(Arrays.compare(array1, array2));//OJO CON ESTO
        System.out.print(Arrays.mismatch(array1, array2));
        System.out.println(SEPARADOR);
        var set1 = Set.of("1", "2", "3");
        var set2 = Set.of("3", "1", "2");
        var set3 = Set.of("1", "2", "3");
        System.out.println(set1.equals(set2) + ":" + set1.equals(set3));//OJO ES TRUE TUE
        System.out.println(SEPARADOR);
    }

    private static void test7() {
        //No se puede usar el var en un lambda
        //var lambda1 = () -> System.out.println("Hello");
        var list2 = new ArrayList(); //Line n4 VALIDO
        System.out.println(SEPARADOR);
    }

    interface MyInterface {
        void calculate();
    }
    private static void test6()  {
        MyInterface obj = () ->  {
            int i = 10;
            i++;
            System.out.println(i);
            return;
        };
        obj.calculate();
    }

    private static void test5() {
        LocalDate date = LocalDate.of(2000, Month.JANUARY, 1);
        Period period = Period.parse("p-30000y");
        System.out.println(date.plus(period));
        System.out.println(SEPARADOR);
    }

    private static void test4() {
        boolean flag1 = true;
        boolean flag2 = false;
        boolean flag3 = true;
        boolean flag4 = false;

        System.out.println(!flag1 == flag2 != flag3 == !flag4); //Line n1
        System.out.println(flag1 = flag2 != flag3 == !flag4); //Line n2
        System.out.println(SEPARADOR);
    }

    private static void test3() {
        List<String> list = new ArrayList<>();
        System.out.println(list.stream().anyMatch(s -> s.length() > 0));
        System.out.println(list.stream().allMatch(s -> s.length() > 0));
        System.out.println(list.stream().noneMatch(s -> s.length() > 0));
        System.out.println(SEPARADOR);
    }

    private static void test2() {
        String text = "Aa aA aB Ba aC Ca";
        ToIntFunction<String> func = text::indexOf;
        System.out.println(func.applyAsInt("a"));
        System.out.println(SEPARADOR);
    }

    private static void test1() {
        var date = LocalDateTime.of(2025, Month.JANUARY, 1, 10, 10);
        var formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        System.out.println(formatter.format(date));
        System.out.println(SEPARADOR);
    }
}
