package com.oracle.ocp.udemyQ.block1.exam6;
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
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
class Paper {
    static String getType() { //Line n1
        return "GENERIC";
    }
}

class RuledPaper extends Paper {
    //String getType() { //Line n2 ERROR, TIENE QUE SER ESTATICO
    static String getType() { //Line n2
        return "RULED";
    }
}

public class Test {
    public static void main(String[] args) {
        Paper paper = new RuledPaper(); //Line n3
        System.out.println(paper.getType()); //Line n4
    }
}

interface Logger {
    Object get();
    void log();
}

class Test2 {
    private static void testLogger(Logger logger) {
        logger.log();
    }

    public static void main(String[] args) {
        var obj = new Logger() { //Line n1
            @Override
            public Logger get() { //Line n2
                return this;
            }

            @Override
            public void log() {
                System.out.println("WINNERS NEVER QUIT"); //Line n3
            }
        };
        testLogger(obj.get()); //Line n4
    }
}

class Animal {
    public String toString() {
        return "ANIMAL";
    }
}

class Mammal extends Animal {
    public String toString() {
        return "MAMMAL";
    }
}

class Dog extends Mammal {
    public String toString() {
        return "DOG";
    }
}

class Test3 {
    public static void main(String... args) {
        Animal obj = new Dog();
        if(obj instanceof Mammal m)
            System.out.print("1. ");
        //System.out.println(m); ERROR
    }
}


interface StringConsumer extends Consumer<String> {
    @Override
    public default void accept(String s) {
        System.out.println(s.toUpperCase());
    }
}

 class Test4 {
    public static void main(String[] args) {
        StringConsumer consumer = new StringConsumer() {
            @Override
            public void accept(String s) {
                System.out.println(s.toLowerCase());
            }
        };
        List<String> list = Arrays.asList("Dr", "Mr", "Miss", "Mrs");
        list.forEach(consumer);//Es posible pasar un consumer dfentro del foreach
    }
}

//interface Operation {
//    int operate(int x, int y);
//}
//
//interface Operation {
//    long operate(long x, long y);
//}
//
//interface Operation<T> {
//    T operate(T x, T y);
//}
interface Operation<T extends Integer> {
    T operate(T x, T y);
}

class Test5 {
    public static void main(String[] args) {
        Operation o1 = (x, y) -> x + y;
        System.out.println(o1.operate(5, 10));
    }
}


 class Test6 {
    static String [] names = {"Williamson.pdf", "Finch.pdf", "Kohli.pdf", "Morgan.pdf"};
    public static void main(String[] args) {
        try {
            if (search("virat.pdf"))
                System.out.println("FOUND");

        } catch(FileNotFoundException ex) {
            System.out.println("NOT FOUND");
        }
    }

    private static boolean search(String name) throws FileNotFoundException {
        for(int i = 0; i <= 4; i++) {
            if (names[i].equalsIgnoreCase(name)) {
                return true;
            }
        }
        throw new FileNotFoundException();
    }
}

class Book {
    String isbn;
    double price;

    Book(String isbn, double price) {
        this.isbn = isbn;
        this.price = price;
    }

    public String toString() {
        return "Book[" + isbn + ":" + price + "]";
    }
}

class Test7 {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("9781976704031", 9.99));
        books.add(new Book("9781976704032", 15.99));

        Book b = books.stream().reduce(new Book("9781976704033", 0.0), (b1, b2) -> {
            b1.price = b1.price + b2.price;
            return new Book(b1.isbn, b1.price);
        });

        books.add(b);
        books.parallelStream().reduce((x, y) -> x.price > y.price ? x : y)
                .ifPresent(System.out::println);
    }
}

 class Test8 {
    public static void main(String[] args) throws InterruptedException {
        Callable<String> c = new Callable<String>() {
            @Override
            public String call() throws Exception {
                try {
                    Thread.sleep(3000);
                } catch(InterruptedException e) {}
                return "HELLO";
            }
        };

        var es = Executors.newFixedThreadPool(10);
        var list = Arrays.asList(c,c,c,c,c);
        var futures = es.invokeAll(list);
        System.out.println(futures.size());
        es.shutdown();
    }
}

class Test9 {
    public static void main(String[] args) {
        StringBuilder[] sb = new StringBuilder[2]; //Line n1 OBLIGATORIO 2 OBJETOS, EL SEGUNDO EZS NULL
        sb[0] = new StringBuilder("PLAY"); //Line n2

        boolean[] flag = new boolean[1]; //Line n3

        if (flag[0]) { //Line n4
            sb[1] = new StringBuilder("GROUP"); //Line n5
        }

        System.out.println(String.join("-", sb)); //Line n6
    }
}



interface Profitable1 {
    default double profit() {
        return 12.5;
    }
}

interface Profitable2 {
    default double profit() {
        return 25.5;
    }
}

abstract class Profit implements Profitable1, Profitable2 {
    @Override
    public double profit() {
        return Profitable1.super.profit();
    }
    /*INSERT*/
}

enum Department {
    Finance, SE, Sales, HR, TBD
}

record Employee(String id, String name, char grade) {
    public static Department findDepartment(Employee emp) {
        return switch(emp.grade()) {
            case 'A', 'B' -> Department.Sales;
            case 'C' -> Department.HR;
            case 'D' -> Department.Finance;
            case 'E' -> Department.SE;
            default -> Department.TBD;
        };
    }
}

class Test10 {
    public static void main(String[] args) {
        record EmpDept(Employee emp, Department dept){}

        Stream<Employee> employees =
                Stream.of(
                        new Employee("S001", "Robert", 'F'),
                        new Employee("S002", "Patricia", 'A'),
                        new Employee("S003", "Sam", 'C'),
                        new Employee("S004", "Jennifer", 'E'));

        employees //Line n1
                .map(emp -> new EmpDept(emp, Employee.findDepartment(emp))) //Line n2
                .sorted(Comparator.comparing(EmpDept::dept)) //Line n3
                .map(EmpDept::emp) //Line n4
                .findFirst() //Line n5
                .stream() //Line n6
                .forEach(System.out::print); //Line n7
    }
}

class Test11 {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        //add(set, s -> s.add(10)); //Line n1
        //add(set, s -> s.add(20)); //Line n2

        System.out.println(set.size());
    }

    private static void add(Set<Integer> set, Consumer<Set<Integer>> consumer) { //Line n3
        consumer.accept(set);
    }

    private static void add(Set<Integer> set, Predicate<Set<Integer>> predicate) { //Line n4
        predicate.test(set);
    }
}