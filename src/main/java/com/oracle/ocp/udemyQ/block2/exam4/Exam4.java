package com.oracle.ocp.udemyQ.block2.exam4;
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
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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
        String [] arr = {"A","B"};
        System.out.println(arr);
        System.out.println(SEPARADOR);
        List<Integer> list = Arrays.asList(10, 100, 1000);
        list.replaceAll(i -> - --i);

        System.out.println(list);
    }

    private static void test8() {

        var sb = new StringBuilder("Dream BIG");
        var s1 = sb.toString();
        var s2 = sb.toString();

        System.out.println(s1 == s2);//FALSE
        System.out.println(SEPARADOR);
    }

    private static void test7() {

        var x = 7.85; //Line n1
        var y = 5.25f; //Line n2
        var a = (int)x + (int)y; //Line n3
        var b = (int)(x + y); //Line n4
        System.out.println(a + b);
        System.out.println(SEPARADOR);
    }

    private static void test6() {

        var path = Paths.get("F:\\A\\B\\C\\Book.java");
        System.out.println(path.subpath(1,4));
        System.out.println(SEPARADOR);


        Error obj = new Error();
        //boolean flag1 = obj instanceof RuntimeException; //Line n1 ERROR
        //boolean flag2 = obj instanceof Exception; //Line n2 ERROR
        boolean flag3 = obj instanceof Error; //Line n3
        boolean flag4 = obj instanceof Throwable; //Line n4
        //System.out.println(flag1 + ":" + flag2 + ":" + flag3 + ":" + flag4);
        System.out.println(Math.round(0.5));
        System.out.println(Math.ceil(0.50));
        System.out.println(Math.floor(0.50));
        System.out.println(Math.abs(0.50));
        System.out.println(SEPARADOR);
    }

    private static void test5() {

        String [] array1 = {"OCP", "11", null, null, null};
        String [] array2 = {"OCP", "11"};
        String [] array3 = {null, "11" , "11", "11"};

        System.out.print(Arrays.compare(array1, array2));//Cuantos a la derecha
        System.out.print(Arrays.compare(array2, array3));//Compara valor
        System.out.print(Arrays.compare(array3, array2));//Compara valor
        System.out.println(SEPARADOR);

    }

    private static void test4() {

        BinaryOperator<String> operator = BinaryOperator.maxBy((s1, s2) -> s2.length() - s1.length()); //Line n1
        var list = List.of(List.of("*", "****"), List.of("##", "#####"), List.of("$$$", "$$$$$$")); //Line n2
        for(var l : list) { //Line n3
            System.out.println(operator.apply(l.get(0), l.get(1)));
        }
        System.out.println(SEPARADOR);

    }

    private static void test3() {

        LocalDate date = LocalDate.ofYearDay(2022, 32);
        System.out.println(date);
        var str = "PANIC";
        var sb = new StringBuilder("THET");
        System.out.println(str.replace("N", sb)); //Line n1
        System.out.println(SEPARADOR);
    }

    private static void test2() {

        String str = Stream.of("a", "an", "and", "alas", "after")
                .dropWhile(s -> s.length() > 4)
                .collect(Collectors.joining(", "));
        System.out.println(str);

        System.out.println(SEPARADOR);
    }

    private static void test1() {

        IntStream stream = IntStream.rangeClosed(1, 5);
        System.out.println(stream.parallel().reduce((x, y) -> x + y).getAsInt());
        System.out.println(SEPARADOR);
    }

}
