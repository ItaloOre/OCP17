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
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
public class Test {
    private static void checkData() throws SQLException {
        try {
            throw new SQLException();
        } catch (Exception e) {
            //e = null; //Line n1 ESTO GENERA ERROR
            throw e; //Line n2
        }
    }

    public static void main(String[] args) {
        try {
            checkData(); //Line n3
        } catch(SQLException e) {
            System.out.println("NOT AVAILABLE");
        }
    }
}
record Point(int x, int y) {
    @Override
    public String toString() {
        return "Point(" + x + ", " + y + ")";
    }
}

 class TestPoint {
    public static void main(String [] args) {
        List<Point> points = new ArrayList<>();
        points.add(new Point(4, 5));
        points.add(new Point(6, 7));
        points.add(new Point(2, 2));

        Collections.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                //return o1.x - o2.x; esto no funciona
                return o1.x() - o2.x();
            }
        });
        System.out.println(points);
    }
}

interface Rideable { }
class Animal { }

class Test2 {
    public static void ride(Animal a) {
        Rideable r = (Rideable) a; //Line n1
    }

    public static void main(String [] args) {
        ride(new Animal()); //Line n2
    }
}

 class Test3 {
    public static void main(String [] args) {
        LocalDate date1 = LocalDate.of(2019, 1, 2);
        date1.minus(Period.ofDays(1));
        LocalDate date2 = LocalDate.of(2018, 12, 31);
        date2.plus(Period.ofDays(1));
        System.out.println(date1.equals(date2) + ":" + date1.isEqual(date2));
    }
}

record Person(int id, String name) {}

class Test4 {
    public static void main(String[] args) {
        Person p1 = new Person(1010, "Sean");
        Person p2 = new Person(2843, "Rob");
        Person p3 = new Person(1111, "Lucy");

        Stream<Person> stream = Stream.of(p1, p2, p3);
        Map<Integer, Person> map = stream.collect( Collectors.toMap(p -> p.id(), Function.identity()));
        System.out.println(map.size());
    }
}

class Test5 {
    /*INSERT-1*/
    public static void main(String[] args) {
        List<Integer> list = create();
    }

    /*INSERT-2*/
    private static List create() {
        return new ArrayList();
    }
}

class Test6 {
    public static void main(String[] args) {
        m1(null);
    }

    static void m1(CharSequence s) {
        System.out.println("CharSequence");
    }

    static void m1(String s) {
        System.out.println("String");
    }

    static void m1(Object s) {
        System.out.println("Object");
    }
}

class Test7 {
    public static void main(String [] args) {
        var text = """
            I gave him $200 and \
            he returned me €120, \
            so I am left with £80.""";

        System.out.println(
                text.transform(Test7::removeCurrencySymbols)
                        .transform(String::toUpperCase)
                        .formatted("¥", "¥", "¥"));
    }

    private static String removeCurrencySymbols(String s) {
        return s.replaceAll("\\$", "%s")
                .replaceAll("€", "%s")
                .replaceAll("£", "%s");
    }
}
class Student {
    String name;
    int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
}

 class Test8 { //OJO, EL OBJETO SI SE VE AFECTADO pero la variable local no
    public static void main(String[] args) {
        Student student = new Student("James", 25);
        int marks = 25;
        review(student, marks);
        System.out.println(marks + "-" + student.marks);
    }

    private static void review(Student stud, int marks) {
        marks = marks + 10;
        stud.marks+=marks;
    }
}

class Test9 {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        map.put(1, 10);
        map.put(2, 20);
        BiConsumer<Integer, Integer> consumer = (k, v) -> {
            System.out.println(k + ":" + v);
        };

        BiFunction<Integer, Integer, Integer> function = (k, v) -> {
            System.out.println(k + ":" + v);
            return null;
        };
        //Line n1
        map.forEach(consumer);
    }
}

class Outer {
    private String msg = "A";
    public void print() {
        final String msg = "B";
        class Inner {
            public void print() {
                //System.out.println(this.msg); NO FUNCIONA
            }
        }
        Inner obj = new Inner();
        obj.print();
    }
}

 class Test10 {
    public static void main(String[] args) {
        new Outer().print();
    }
}

class Test11 { //200 SOBREPASA LOS LIMITES DEL byte
    public static void main(String[] args) {
        byte var = 100;
        switch(var) {
            case 100:
                System.out.println("var is 100");
                break;
            //case 200:
            //System.out.println("var is 200");
            //break;
            default:
                System.out.println("In default");
        }
    }
}

interface Message {
    String msg = "CONSISTENCY";
    public default void quoteOfTheDay() {
        record Quote(){ //Line n1
            String combine(String str) {
                return msg + "=" + str; //Line n2
            }
        }
        System.out.println(new Quote().combine("SUCCESS")); //Line n3
    }
}

class Test12 {
    public static void main(String[] args) {
        new Message(){}.quoteOfTheDay(); //Line n4
    }
}

class Test13 {
    private void increment(int start, int end) throws InterruptedException, ExecutionException {
        var es = Executors.newFixedThreadPool(10);
        var results = new Future<?>[26];
        IntStream.rangeClosed(start, end)
                .parallel()
                .forEach(x -> results[x] = es.submit(() -> new String(new char[]{(char)(x + 65)})));
        System.out.println(results[1].get());
        es.shutdown();
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        new Test13().increment(0, 25);
    }
}

