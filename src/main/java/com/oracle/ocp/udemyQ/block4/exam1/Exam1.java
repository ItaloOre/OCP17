package com.oracle.ocp.udemyQ.block4.exam1;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.Instant;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;
public class Exam1 {
    public static final String SEPARADOR = "-------------";

    public static void main(String[] args) throws ParseException {
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

        System.out.println(Instant.EPOCH);//1970-01-01T00:00:00Z
        String text = "RISE ";
        text = text + (text = "ABOVE ");
        System.out.println(text);
        System.out.println(SEPARADOR);
    }

    private static void test5() {
        var mf = new MessageFormat("'{0}' + '{1}' = '{2}'");
        System.out.println(mf.format(new Integer[] {
                2,3,5,8
        }));
        System.out.println(SEPARADOR);
    }

    private static void test4() {
        char c = 'Z';
        long l = 100_00l;
        int i = 9_2;
        float f = 2.02f;
        double d = 10_0.35d;
        l = c + i;
        f = c * l * i * f;
        f = l + i + c;
        i = (int)d;
        f = (long)d;
        System.out.println(SEPARADOR);

    }

    private static void test3() throws ParseException {

        var nf = NumberFormat.getPercentInstance(Locale.US);
        Stream.of(nf.parse("10%"), nf.parse("20%"), nf.parse("30%"))
                .map(x -> nf.format(x))
                .map(x -> x.substring(0, 2))
                .mapToInt(x -> Integer.parseInt(x))
                .average()
                .stream()
                .forEach(System.out::print); //20

        System.out.println(SEPARADOR);
    }

    private static void test2() {

        var list1 = Arrays.asList('A', 'B', 'D');
        var list2 = List.of('A', 'B', 'C');
        /*INSERT*/
        //list2.set(2, 'C');//OJO NO se puede setear ,eliminar ni agregar
        list2 = list1; //VALIDO
        System.out.println(list1.equals(list2));
        System.out.println(SEPARADOR);
    }

    private static void test1() {
        int res = 1;
        IntStream stream = IntStream.rangeClosed(1, 4);
        //VALIDO
        System.out.println(stream.reduce(res++, (i, j) -> i * j));

        var x = new int[]{1};
        var y = new int[]{2};
        var z = new int[]{3};
        System.out.println((x = y = z)[0] + y[0] + z[0]); //9 porrque ahora los 3 valen 3
        System.out.println(SEPARADOR);
    }
}

class Test8 { //INFINITO
    public static void main(String[] args) {
        Stream<Double> stream = Stream.generate(() -> Double.valueOf("1.0"));
        System.out.println(stream.sorted().findFirst());
    }
}

class Test9 {
    public static void main(String[] args) {
        int x = 100;

        String txt = switch(x) { //Line n1
            case 10 -> "TEN"; //Line n2
            case 100 -> switch(10) { //Line n3
                default -> "HUNDRED"; //Line n4
            }; //Line n5
            default -> "NA"; //Line n6
        }; //Line n7

        System.out.println(txt);
    }
}