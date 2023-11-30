package com.oracle.ocp.udemyQ.block4.exam2;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.time.Period;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
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
        Period period = Period.ofWeeks(100);
        System.out.println(period);

        Deque<Character> chars = new ArrayDeque<>();
        chars.add('A');
        chars.remove();
        //chars.remove();//Remove a una cola vacia da error

        System.out.println(chars);
        System.out.println(SEPARADOR);
    }

    private static void test8() {
        Set<Character> set = new TreeSet<>(Arrays.asList('a','b','c','A','a','c'));
        set.stream().forEach(System.out::print);
        System.out.println(SEPARADOR);
    }

    private static void test7() {

        Stream<String> stream = Stream.of("ocp");
        stream.flatMapToInt(s -> s.chars())//ojo con el TOINT
                .forEach(i -> System.out.print((char)i));
        System.out.println(SEPARADOR);
    }

    private static void test6() {
        var list = List.of(false, Boolean.valueOf(null), Boolean.valueOf("1"), Boolean.valueOf("0"));
        BinaryOperator<Boolean> operator = (b1, b2) -> b1 || b2;
        System.out.println(list.stream().reduce(false, operator));
        System.out.println(SEPARADOR);
    }

    private static void test5() {

        char[] c1 = { 'T', 'A', 'L', 'L' };
        char[] c2 = { 'T', 'A', 'L', 'K' };
        System.out.println(Arrays.mismatch(c1, c2) * Arrays.compare(c1, c2));
        System.out.println(SEPARADOR);
    }

    private static void test4() {
        Function<char [], String> obj = String::new; //Line n1
        String s = obj.apply(new char[] {'j', 'a', 'v', 'a'}); //Line n2
        System.out.println(s);

        var strings = Stream.of("S", "H", "I", "E", "L", "D");
        var result = strings.collect(Collectors.teeing(
                Collectors.joining("."),
                Collectors.joining("-"),
                (str1, str2) -> String.join("|", str1, str2)));
        System.out.println(result);
        System.out.println(SEPARADOR);
    }

    private static void test3() {

        var stream = Stream.of("JAVA", new String("JAVA"));
        stream.distinct()
                .findAny()
                .stream()
                .forEach(System.out::println);
        System.out.println(SEPARADOR);
    }

    private static void test2() {

        var path = Paths.get(".", "..", ".", "..", "..", ".").normalize();
        System.out.println(path.getNameCount());
        System.out.println(path.getName(0).toString().length());
        System.out.println(SEPARADOR);
    }

    private static void test1() {
        BiFunction<Integer, Integer, Character> compFunc = (i, j) -> {return (char)(i + j);};
        //No funciona porque funcion tiene que retornar char
        //BiFunction<Integer, Integer, Character> compFunc = (i, j) -> i + j;
        System.out.println(compFunc.apply(0, 65));

        var loc = Locale.ENGLISH;
        //OJO no hay set en Locale
        //loc.setCountry("en");
        //loc.setCountry("CA");

        System.out.println(loc.getDisplayCountry());

        Locale.setDefault(Locale.US);
        var nf = NumberFormat.getCompactNumberInstance();
        System.out.println(nf.format(5698));

        System.out.println(SEPARADOR);
    }
}
