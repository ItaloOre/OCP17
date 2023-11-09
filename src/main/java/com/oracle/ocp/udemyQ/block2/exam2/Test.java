package com.oracle.ocp.udemyQ.block2.exam2;
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
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Outer {
    public void print(int x) {
        class Inner {
            public void getX() {
                //System.out.println(++x); DEBE SER FINAL O EFECTIVE FINAL
                System.out.println(9);
            }
        }
        Inner inner = new Inner();
        inner.getX();
    }
}

public class Test {
    public static void main(String[] args) {
        new Outer().print(100);
    }
}
class A<T extends String> {

}



record Toy(String name) {
    @Override
    public String toString() {
        return "Toy[" + name +"]";
    }

    @Override
    public boolean equals(Object obj) {
        return true;
    }

    @Override
    public int hashCode() {
        return 0;
    }
}

//Sino implementan AutoCloseable DA ERROR
class Resource1 implements AutoCloseable {
    public void close() {
        System.out.println("Resource1");
    }
}

class Resource2 implements AutoCloseable{
    public void close() {
        System.out.println("Resource2");
    }
}

class Test2 {
    public static void main(String[] args) {
        try(Resource1 r1 = new Resource1(); Resource2 r2 = new Resource2()) {
            System.out.println("Test");
        }
    }
}

interface Creator<T> {
    T create();
}

class Book {
    public Book() {
        System.out.println(1);
    }

    public String toString() {
        return "2";
    }
}

 class Test3 {
    public static void main(String[] args) {
        Creator<Book> obj = Book::new;
        obj.create().toString();
    }
}

record Employee(String name, int age) implements Comparable<Employee> {
    @Override
    public String toString() {
        return "{" + name + ", " + age + "}";
    }

    @Override
    public int compareTo(Employee o) {
        return o.age - this.age;
    }
}

 class Test4 {
    public static void main(String[] args) {
        Set<Employee> employees = new TreeSet<>();
        employees.add(new Employee("Udayan", 31));
        employees.add(new Employee("Neha", 23));
        employees.add(new Employee("Hou Jian", 42));
        employees.add(new Employee("Smita", 29));

        System.out.println(employees);
    }
}


class Test5 {
    public static void main(String [] args) throws InterruptedException, ExecutionException, TimeoutException {
        Callable<String> r = () -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "ATTACK";
        };

        var es = Executors.newSingleThreadExecutor();
        var f = es.submit(r);
        System.out.println(f.get(1000, TimeUnit.MILLISECONDS));
        es.shutdown();
    }
}


interface I1 {
    void m1();
}

interface I2 extends I1 {
    void m2();
}

interface I3 extends I2 {
    void m3();
}

interface I4 {
    String toString();
}

 class Test6 {
    public static void main(String[] args) {
        I1 i1 = () -> System.out.println(1);

    }
}

class Test7 {
    public static void main(String[] args) {
        try {
            System.out.print(Arrays.compare(new char[] { 'A' }, null));//1
        } catch (Exception ex) {
            System.out.print('A');
        }

        try {
            System.out.print(Arrays.mismatch(null, new int[] { 1 }));//B
        } catch (Exception ex) {
            System.out.print('B');
        }

        try {
            System.out.print(Arrays.equals(new short[] { 10 }, null));//FALSE
        } catch (Exception ex) {
            System.out.print('C');
        }
    }
}

class Test8 {
    public static void main(String[] args) {
        Function<String, Integer> f1 = Integer::valueOf;
        Function<String, String> f2 = s -> new StringBuilder(s).reverse().toString();
        System.out.println(f1.compose(f2).apply("12345"));
    }
}