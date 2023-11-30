package com.oracle.ocp.udemyQ.block3.exam2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

enum Flags {
    TRUE, FALSE;

    Flags() {
        System.out.println("HELLO");
    }
}

public class Test {
    public static void main(String[] args) {
        Flags flags = Flags.TRUE;//SE IMPRIME 2 VECES
    }
}

record Student(String name, int age) {
    public static int compareByName(Student s1, Student s2) {
        return s1.name().compareTo(s2.name());
    }
}

class Test2 {
    public static void main(String[] args) {
        Set<Student> students = new TreeSet<>(Student::compareByName);
        students.add(new Student("Martha", 16));
        students.add(new Student("Martha", 17));
        students.add(new Student("Martha", 18));

        System.out.println(students.size());
    }
}


class Test3 {
    public static void main(String[] args) {
        String [] arr1 = {"Virat", "Rohit", "Shikhar", "Dhoni"};
        String [] arr2 = {"Bumrah", "Pandya", "Sami"};
        String [] arr3 = {};

        Stream<String[]> stream = Stream.of(arr1, arr2, arr3);
        stream.flatMap(s -> Arrays.stream(s))
                .sorted()
                .forEach(s -> System.out.print(s + " "));
    }
}

class Test4 {
    static String msg; //Line n1
    public static void main(String[] args) {
        String msg; //Line n2
        if(args.length > 0) {
            msg = args[0]; //Line n3
        }
        //System.out.println(msg); //Line n4
    }
}

@FunctionalInterface
interface Log {
    void log(String s);

    /**
     * @deprecated This method has been deprecated,
     * use log(String) method instead
     */
    @Deprecated(since = "9", forRemoval = true)
    default void print(String s) {
        System.out.println(s);
    }
}

class Test5 {
    public static void main(String[] args) {
        Log l = s -> System.out.println(s.toUpperCase());
        //l.print("hello");
    }
}

class Test6 {
    public static void main(String[] args) {
        int[] a1 = { 10, 15, 20 };
        int[] a2 = { 10, 20, 30 };
        System.out.println(Arrays.mismatch(a1, a2));
        System.out.println(Arrays.compare(a1, a2));
        System.out.println(Arrays.mismatch(a1, a2) + Arrays.compare(a1, a2));
    }
}

class Test7 {
    public static void main(String[] args) {
        var loc = Locale.US;
        //var loc = Locale.ENGLISH;//VACIO
        System.out.println(loc.getDisplayCountry());
    }
}

class Test8 {
    public static void main(String[] args) {
        outer: for(var i = 0; i < 3; System.out.print(i)) {
            i++;
            inner: for(var j = 0; j < 3; System.out.print(j)) {
                if(i > ++j) {
                    break outer;
                }
            }
        }
    }
}

interface Printer {
    default void print() throws FileNotFoundException {
        System.out.println("PRINTER");
    }
}

class FilePrinter implements Printer {
    public void print() { //Line n1
        System.out.println("FILE PRINTER");
    }
}
class Test9 {
    public static void main(String[] args) {
        Printer p = new FilePrinter(); //Line n2
        //p.print(); //Line n3
        var fp = new FilePrinter(); //Line n4
        fp.print(); //Line n5
    }
}


class Outer {
    private static int i = 10;
    private int j = 20;

    static class Inner {
        void add() {
            //System.out.println(i + j);//ERROR
        }
    }
}

 class Test10 {
    public static void main(String[] args) {
        Outer.Inner inner = new Outer.Inner();
        inner.add();
    }
}

class A{}
interface M{}
interface N{}

class B extends A {}
class C extends A implements M {}
class D extends A implements M, N {}
class Generic<T extends A & M & N> {}
//class Generic<T extends M & N & A> {}//OJO, EL ORDEN ES IMPORTANTE

class Test11 {
    public static void main(String[] args) {
        var codes = List.of("1st", "2nd", "3rd", "4th");
        System.out.println(codes.stream()
                .filter(s -> s.endsWith("d"))
                .reduce((s1, s2) -> s1 + s2));//Optional[2nd3rd]
    }
}
interface X1 {
    default void print() {
        System.out.println("X1");
    }
}

interface X2 extends X1 {
    void print();
}

interface X3 extends X2 {
    default void print() {
        System.out.println("X3");
    }
}

class X implements X3 {}

class Test12 {
    public static void main(String[] args) {
        X1 obj = new X();
        obj.print();

    }
}

class MyResource implements AutoCloseable {
    @Override
    public void close() throws IOException {
        throw new IOException("IOException");
    }

    public void execute() throws SQLException {
        throw new SQLException("SQLException");
    }
}

class Test13 {
    public static void main(String[] args) {
        try(MyResource resource = new MyResource()) {
            resource.execute();
        } catch(Exception e) {
            System.out.println(e.getSuppressed()[0].getMessage());//IOException
        }
    }
}

class Test14 {
    public static void main(String[] args) {
        Stream<Integer> nums = Stream.iterate(1, k -> k <= 10, i -> i + 1);

        var result = nums.collect(Collectors.teeing(
                Collectors.filtering(x -> x % 2 == 0, Collectors.toList()),
                Collectors.filtering(x -> x % 2 != 0, Collectors.toList()),
                (x, y) -> {
                    var list = new ArrayList<String>();
                    for (int i = 0; i < x.size(); i++) {
                        list.add(y.get(i) + "" + x.get(i));
                    }
                    return list;
                }));

        System.out.println(result);
    }
}

class Test15 {
    public static void main(String[] args) {
        try { //outer
            try { //inner
                System.out.println(1/0);
            } catch(ArithmeticException e) {
                System.out.println("INNER");
            } finally {
                System.out.println("FINALLY 1");
            }
        } catch(ArithmeticException e) {
            System.out.println("OUTER");
        } finally {
            System.out.println("FINALLY 2");
        }
    }
}

class Test16 {
    public static void main(String[] args) {
        IntUnaryOperator opr = i -> i * i * i;
        int result = IntStream.range(1, 5)
                .map(opr)
                .sum();
        System.out.println(result);
    }
}

interface Logger {
    String log(byte i, byte j, byte k);
}

class Test17 {
    private static String print(Number i, Number j, Number k) {
        return i + ", " + j + ", " + k;
    }

    public static void main(String[] args) {
        Logger obj = Test17::print; //Line n1
        System.out.println(obj.log((byte)11, (byte)22, (byte)33)); //Line n2
    }
}


interface Sellable {}
abstract class Animal {}
class Mammal extends Animal{}
class Rabbit extends Mammal implements Sellable{}

class Test18 {
    {
        List<Animal> list = new ArrayList<>();
        list.add(new Rabbit());
    }
    {
        List<Animal> list = new ArrayList<>();
        list.add(new Mammal());
    }
    {
        List<Mammal> list = new ArrayList<>();
        list.add(new Rabbit());
    }
    {
        List<Sellable> list = new ArrayList<>();
        //list.add(new Mammal()); ESTO FALLA
    }
    {
        List<Sellable> list = new ArrayList<>();
        list.add(new Rabbit());
    }
}