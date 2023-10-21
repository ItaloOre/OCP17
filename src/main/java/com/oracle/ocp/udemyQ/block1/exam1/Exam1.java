package com.oracle.ocp.udemyQ.block1.exam1;

import java.util.Date;
import java.util.Locale;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class Exam1 {

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
    }

    public static void test1(){
        char a = 'a';
        int b = a;
        System.out.println(b);
    }

    public static void test2(){
        Supplier<Date> obj = Date::new;//Constructor reference for no-argument Date() constructor
        Date date = obj.get(); //Creates an instance of Date class.
        System.out.println(date);
    }

    public static void test3(){
        Boolean [] arr = new Boolean[2];
        System.out.println(arr[0] + ":" + arr[1]);//NULL NULL
    }

    public static void test4(){
        System.out.println(IntStream.range(10,1).count());//0
    }

    public static void test5(){
        var loc = new Locale("it", "IT"); //Line 7
        loc.setDefault(loc); //Line 8
        System.out.println(Locale.getDefault());
    }


}




//ESTO ES LEGAL
class GenericPrinter<T> {}
abstract class AbstractGenericPrinter<X,Y,T> extends GenericPrinter<T>{}

