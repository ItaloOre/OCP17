package com.oracle.ocp.udemyQ.block2.exam5;
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
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
public class Test {
    public static void main(String[] args) {
        String[][] arr = { { "7", "6", "5" }, { "4", "3" }, { "2", "1" } };
        for (int i = 0; i < arr.length; i++) { //Line n1
            for (int j = 0; j < arr[i].length; j++) { //Line n2
                switch (arr[i][j]) { //Line n3
                    case "2":
                    case "4":
                    case "6":
                        break; //Line n4
                    default:
                        continue; //Line n5
                }
                System.out.print(arr[i][j]); //Line n6
            }
        }
    }
}

record Person(String firstName, String lastName) {
    @Override
    public String toString() {
        return "{" + firstName + ", " + lastName + "}";
    }
}

class Test2 {
    public static void main(String[] args) {
        List<Person> list = Arrays.asList(
                new Person("Tom", "Riddle"),
                new Person("Tom", "Hanks"),
                new Person("Yusuf", "Pathan"));
        list.stream().sorted(Comparator.comparing(Person::firstName).reversed()
                .thenComparing(Person::lastName)).forEach(System.out::println);
    }
}

class Message {
    private String msg = "Good Morning!";
    public Message(String msg) {
        this.msg = msg;
    }

    public Message() {super();}

    public String getMsg() {
        return msg;
    }

    public String toString() {
        return msg;
    }
}

 class Test3 {
    public static void main(String[] args) {
        Message message = null;
        Optional<Message> optional = Optional.ofNullable(message);
        System.out.println(optional.isPresent() ? optional.get().getMsg() : new Message());
    }
}

 interface Shape { } //Line n1
//final class Rectangle { } //Line n2
class Rectangle { } //Line n2
class Test4 {
    public static void draw(Rectangle r) {
        Shape s = (Shape) r; //Line n3
    }

    public static void main(String [] args) {
        draw(new Rectangle()); //Line n4
    }
}

class Test5 {
    Integer i = 10; //Line n1
    {
        Integer i = 2; //Line n2
    }
    public static void main(String[] args) {
        System.out.println(new Test5().i); //Line n3
    }
    { i--; } //Line n4
}

class Test6<T> {
    private T t;

    public T get() {
        return t;
    }

    public void set(T t) {
        this.t = t;
    }

    public static void main(String args[]) {
        Test6 obj = new Test6();
        obj.set("OCP");
        obj.set(85);
        obj.set('%');

        System.out.println(obj.get());
    }
}

class Test7 {
    private static void print() {
        System.out.println("PRINT");
    }

    private static Integer get() {
        return 10;
    }

    public static void main(String [] args) throws InterruptedException, ExecutionException {
        var es = Executors.newFixedThreadPool(10);
        Future<?> future1 = es.submit(Test7::print);
        Future<?> future2 = es.submit(Test7::get);
        System.out.println(future1.get());
        System.out.println(future2.get());
        es.shutdown();
    }
}

interface I1 {
    void m1();
}

class Test8 {
    public static void main(String[] args) {
        I1 i1 = new I1() {
            @Override
            public void m1() {
                System.out.println(1234);
            }
        };//NO OLVIDAR LA COMA
        i1.m1();
    }
}

 class Test9 {
    public static void main(String[] args) {
        var console = System.console();
        if(console != null) {
            console.format("%d %x", 10);
        }
    }
}

enum Color {
    RED, YELLOW, GREEN
}

record TrafficLight(String msg, Color color) {
    @Override
    public String toString() {
        return "{" + color + ", " + msg + "}";
    }
}

class Test10 {
    public static void main(String[] args) {
        TrafficLight tl1 = new TrafficLight("Go", Color.GREEN);
        TrafficLight tl2 = new TrafficLight("Go Now!", Color.GREEN);
        TrafficLight tl3 = new TrafficLight("Ready to stop", Color.YELLOW);
        TrafficLight tl4 = new TrafficLight("Slow Down", Color.YELLOW);
        TrafficLight tl5 = new TrafficLight("Stop", Color.RED);

        List<TrafficLight> list = Arrays.asList(tl1, tl2, tl3, tl4, tl5);

        Map<Color, List<String>> map = list.stream()
                .collect(Collectors.groupingBy(TrafficLight::color,
                        Collectors.mapping(TrafficLight::msg, Collectors.toList())));

        System.out.println(map.get(Color.YELLOW));
    }
}

class Car {
    void speed(Byte val) { //Line n1
        System.out.println("DARK"); //Line n2
    } //Line n3

    void speed(byte... vals) {
        System.out.println("LIGHT");
    }
}

class Test11 {
    public static void main(String[] args) {
        byte b = 10; //Line n4
        new Car().speed(b); //Line n5
    }
}