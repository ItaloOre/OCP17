package com.oracle.ocp.udemyQ.block1.exam2;

import org.springframework.cglib.core.Local;

import java.io.File;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.BiPredicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
        Locale locale = new Locale("","");
        Locale locale2 = new Locale("");
        Locale locale3 = new Locale("","","");//OJO, EL LOCAL PUEDE TENER 3 PARAMETROS

        System.out.println(SEPARADOR);

        System.out.println("""
    "A",\
    "B",\
    "C".\
    """);
        System.out.println("""
    \"A\",\
    \"B\",\
    \"C\".\
    """);
        System.out.println(String.join(",", "\"A\"", "\"B\"", "\"C\"") + ".");

        var dir = new File("F:" + File.separator + "A" + File.separator + "B");
        System.out.println(dir.getParentFile().getParent());
        System.out.println(dir.getParentFile().getParentFile());
        System.out.println(dir.getParent());
    }

    private static void test8() {
        String str = " "; //single space
        boolean b1 = str.isEmpty();
        boolean b2 = str.isBlank();
        System.out.println(b1 + " : " + b2); //Line n1

        str.strip(); //Line n2
        b1 = str.isEmpty();
        b2 = str.isBlank();
        System.out.println(b1 + " : " + b2); //Line n3
        System.out.println(SEPARADOR);
    }

    private static void test7() {
        BiPredicate<String, String> predicate = String::equalsIgnoreCase;
        System.out.println(predicate.test("JaVa", "Java"));

        System.out.println(SEPARADOR);

        byte[] arr1 = { 5, 10, 15, 2, 21 };
        byte[] arr2 = { 5, 10, 15, 17 };
        System.out.println(Arrays.compare(arr1, arr2));//DEVUELVE - si el de la izquierda es menor y la diferncia
        System.out.println(Arrays.mismatch(arr1, arr2));
        System.out.println(Arrays.equals(arr1, arr2));
        System.out.println(SEPARADOR);
    }

    private static void test6() {//OJO, NO HAY GARANTIA DE QUE SIEMPRE SALGA -10
        System.out.println(Stream.of(10, 0, -10)
                .sorted()
                .findAny()
                .orElse(-1));
        System.out.println(SEPARADOR);
    }


    private static void test5() {
        //Set<String> set = new TreeSet<>(Arrays.asList(null,null,null));
        //long count = set.stream().count();
        //System.out.println(count);
    }

    private static void test4() {
        for(var i = 1; i <= 5; i++) {
            System.out.println("*".repeat(i));
        }
        System.out.println(SEPARADOR);

        Stream.iterate("*", s -> s += "*").limit(5)
                .forEach(System.out::println);

        System.out.println(SEPARADOR);

        Stream.iterate("*", s -> s.length() <= 5, s -> s += "*")
                .forEach(System.out::println);

        System.out.println(SEPARADOR);

        IntStream.range(1, 6)
                .mapToObj(i -> "*".repeat(i))//OJO, usar mapToObj en lugar de map
                .forEach(System.out::println);
        System.out.println(SEPARADOR);
    }

    private static void test3() {
        var list = new ArrayList<String>(List.of("T", "O", "A", "S", "L", "M")); //Line n1
        /*
        * x2. El método compareTo se utiliza para comparar dos objetos. Si x1.compareTo(x2)
        * devuelve un número negativo, significa que x1 es menor que x2. Multiplicar ese valor
        * por -2 invierte la relación, lo que significa que si x1.compareTo(x2) es negativo,
        * entonces -2 * x1.compareTo(x2) será positivo y viceversa.
        *
        * */
        list.sort((var x1, var x2) -> -2 * x1.compareTo(x2)); //Line n2
        list.forEach(System.out::print); //Line n3
        System.out.println(SEPARADOR);
    }

    private static void test2() {
        int m = 20;
        int var = --m * m++ + m-- - --m;
        System.out.println("m = " + m);
        System.out.println("var = " + var);

        System.out.println(Duration.ofDays(-2));//PT-48H
        System.out.println(SEPARADOR);

    }

    private static void test1() {
        var a = 5;
        var x = 20;
        switch(x) {
            case 10 ->
                    a *= 2;
            case 20 ->
                    a *= 3;
            case 30 ->
                    a *= 4;
        }
        System.out.println(a);
        System.out.println(SEPARADOR);
    }

}
