package com.oracle.ocp.udemyQ.block4.exam6;
import java.time.*;

public class Exam6 {
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
        System.out.println(SEPARADOR);
    }

    private static void test5() {
        System.out.println(SEPARADOR);
    }

    private static void test4() {
        System.out.printf("%2$d + %1$d", 10, 20, 30);
        System.out.println(SEPARADOR);
        LocalTime time = LocalTime.parse("14:14:59.1111");
        System.out.println(time);
        System.out.println(SEPARADOR);
    }

    private static void test3() {

        String [] arr1 = {null, null};
        System.out.println("1. " + String.join("::", arr1));

        String [] arr2 = {};
        System.out.println("2. " + String.join("-", arr2));

        //ERROR

        // String [] arr3 = null;
        //System.out.println("3. " + String.join(".", arr3));

        //System.out.println("4. " + String.join(".", null));

        System.out.println(SEPARADOR);
    }

    private static void test2() {

        var str = "Have Faith!"; //Line n1
        System.out.println(str.length() + " : " + str.charAt(10)); //Line n2

        // System.out.println(SEPARADOR);
    }

    private static void test1() {

        var arr2 = new String[][] {};
        var arr1 = new int[]{10};
        var arr3 = new char[][] {{}};
        //var arr4 = {10, 20, 30};
        //var [] arr6 = new int[] {2, 3, 4};
        var arr5 = new String[][] {new String[]{"LOOK"}, new String[] {"UP"}};
        System.out.println(SEPARADOR);


    }
}

