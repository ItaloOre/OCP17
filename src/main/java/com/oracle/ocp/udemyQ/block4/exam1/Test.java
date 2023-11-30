package com.oracle.ocp.udemyQ.block4.exam1;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
class X {
    void greet() {
        System.out.println("Good Morning!");
    }
}

class Y extends X {
    void greet() {
        System.out.println("Good Afternoon!");
    }
}

class Z extends Y {
    void greet() {
        System.out.println("Good Night!");
    }
}

public class Test {
    public static void main(String[] args) {
        X x = new Z();
        x.greet(); //Line n1
        ((Y)x).greet(); //Line n2
        ((Z)x).greet(); //Line n3
    }
}
interface M {
    public static void log() {
        System.out.println("M");
    }
}

abstract class A {
    public static void log() {
        System.out.println("N");
    }
}

class MyClass extends A implements M {}

class Test2 {
    public static void main(String[] args) {
        M obj1 = new MyClass();
        //obj1.log(); //Line n1 ERROR, USAR OPCION DE ABAJO
        M.log(); //Line n1
        A obj2 = new MyClass();
        obj2.log(); //Line n2

        MyClass obj3 = new MyClass();
        obj3.log(); //Line n3
    }
}


class Test3 {
    public static void main(String... args) {
        Object [] arr = {new Object(), "JAVA", new int[]{1, 2, 3}};
        for(var obj : arr) {
            if(obj instanceof String str && str.length() > 2) //Line n1
                System.out.print(str);
            if(obj instanceof int [] a) //Line n2
                //if(obj instanceof int [] a || a.length > 2) //Line n2 ERROR
                System.out.print(a[1]);
        }
    }
}

class Foo {
    public static void m1() { //Line n1
        System.out.println("Foo : m1()");
    }
    class Bar {
        public static void m1() { //Line n2
            System.out.println("Bar : m1()");
        }
    }
}

class Test4 {
    public static void main(String [] args) {
        var foo = new Foo(); //Line n3
        var bar = foo.new Bar(); //Line n4
        bar.m1(); //Line n5
    }
}

class Test5 {
    public static void main(String[] args) {
        try {
            find();
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    static void find() throws Exception { //OJO CONM ESTA, REVISAR
        try {
            System.out.print(1);
            throw new FileNotFoundException("FNF");
        } catch(FileNotFoundException ex) {
            System.out.print(2);
            throw new IOException("IO");
        } catch(IOException ex) {
            System.out.print(3);
            throw new Exception("EXP");
        } finally {
            System.out.print(4);
            throw new Exception("FINALLY");
        }
    }
}
record Student2(int id, String name, int marks) {}//NO EXISTE LA HERENCIA EN RECORDS PORQUE ES INMUTABLE Y FINAL
record Student(int id, String name, int marks) {}

 class Test6 {//REVISAR
    public static void main(String[] args) {
        var students = Stream.of(
                new Student(1001, "Sharon", 925),
                new Student(1002, "Amy", 875),
                new Student(1003, "Ryan", 875),
                new Student(1004, "Eric", 900));

        var result = students.collect(Collectors.teeing(
                Collectors.minBy(Comparator.comparing(Student::marks)),
                Collectors.maxBy(Comparator.comparing(Student::marks)),
                (r1, r2) -> r1.get().marks() + r2.get().marks())
        );

        System.out.println(result);
    }
}

class Printer<String> {
    private String t;
    Printer(String t){
        this.t = t;
    }
//    public String toString() { //ERROR
//        return null;
//    }
}

class Test7 {
    public static void main(String[] args) {
        Printer<Integer> obj = new Printer<>(100);
        System.out.println(obj);
    }
}
