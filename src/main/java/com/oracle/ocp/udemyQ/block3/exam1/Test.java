package com.oracle.ocp.udemyQ.block3.exam1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.DoublePredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

interface MyRunnable {
    int run(Double start, Double end);
}

class Runner implements MyRunnable {
    public int run(Double s, Double e) {
        if(s == null) s = 0.0;
        if(e == null) e = 0.0;
        return (int) (s + e);
    }
}

public class Test {
    public static void startRunning(MyRunnable r) {
        System.out.println(r.run(5.8, null)); //Line n1
    }
    public static void main(String[] args) {
        /*INSERT*/
        startRunning(new Runner());

        startRunning(new Runner() {
            public int run(Double d1, Double d2) {
                return (int)((d1 == null ? 0.0 : d1) + (d2 == null ? 0.0 : d2));
            }
        });

        //startRunning((a, b) ->(int) (a + b));//Exception in thread "main" java.lang.NullPointerException: Cannot invoke "java.lang.Double.doubleValue()" because "b" is null

        startRunning((a, b) -> a.byteValue());

        startRunning((var d1, var d2) -> Double.valueOf(d1 + (d2 == null ? 0.0 : d2)).intValue());
    }
}

class GrandParent {}

class Parent extends GrandParent {}

class Child extends Parent {}

class GrandChild extends Child {}

class Test2 {
    public static void main(String... args) {
        GrandParent obj = new Child();
        if(!(obj instanceof GrandChild gc)) {
            System.out.print("Not a GrandChild");
            /*INSERT-1*/
            return;
        }
        /*INSERT-2*/
        System.out.println(gc); //Line n2
    }
}

class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String toString() {
        return "{" + name + ", " + salary + "}";
    }
}

class Test3 {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(new Employee("Jack", 8000),
                new Employee("Lucy", 12000));
        updateSalary(employees, d -> d < 10000);
        employees.forEach(System.out::println);
    }

    private static void updateSalary(List<Employee> list, DoublePredicate predicate) {
        for(Employee e : list) {
            if(predicate.negate().test(e.getSalary())) {
                e.setSalary(e.getSalary() + 2000);
            }
        }
    }
}

class Test4 {
    public static void main(String[] args) {
        int res = 1;
        IntStream stream = IntStream.rangeClosed(1, 5);
        System.out.println(stream.reduce(1,(i,j) -> i*j));
    }
}

class Test5 {
    public static void main(String[] args) {
        var path1 = Paths.get("F:\\A\\B\\C");
        var path2 = Paths.get("F:\\A");
        System.out.println(path1.relativize(path2));
        System.out.println(path2.relativize(path1));
    }
}


class Test6 {
    public static void main(String [] args) {
        LocalDateTime dt = LocalDateTime.parse("2018-03-16t10:15:30.22");
        //perator '+' cannot be applied to 'java.time.LocalDate', 'java.time.LocalTime'
        //System.out.println(dt.toLocalDate() + dt.toLocalTime());
    }
}

class Test7 {
    public static void main(String[] args) {
        var list = new ArrayList<String>(); //Line n1
        list.add("A");
        list.add("M");
        var list_of_list = List.of(list); //Line n2
        list_of_list.get(0).set(1, "N"); //Line n3
        list_of_list.get(0).forEach(System.out::print); //Line n4
    }
}

class Test8 {
    public static void main(String[] args) {
        try {
            findSecretFile();
        } catch(Throwable ex) {
            System.out.println(ex.getMessage());
            return;
        } finally {
            System.out.println("LEVEL 1");
        }
        System.out.println("DONE");
    }

    static void findSecretFile() throws FileNotFoundException {
        throw new FileNotFoundException("ACCESS REQUIRED");
    }
}
abstract class Greetings {
    abstract void greet(String s);
}

class Parent2 {
    String quote = "MONEY DOESN'T GROW ON TREES";
}

class Child2 extends Parent2 {
    String quote = "LIVE LIFE KING SIZE";
}

class GrandChild2 extends Child2 {
    String quote = "PLAY PLAY PLAY";
}

class Test9 {
    public static void main(String[] args) {
        GrandChild2 gc = new GrandChild2();
        System.out.println(((Parent2)(Child2)gc).quote);
        System.out.println(((Parent2)gc).quote);
    }
}

class Test10 {
    public static void main(String[] args) {
        Stream<Integer> ints = Stream.of(11, 22, 22, 33);
        var result = ints.collect(
                Collectors.teeing(
                        Collectors.minBy(Integer::compare),
                        Collectors.summingInt(Integer::intValue),
                        (x, y) -> y - x.orElse(0)));
        System.out.println(result);//77=
    }
}

 class Test11 {
    public static void main(String[] args) throws IOException {
        var root = Paths.get("F:");
        //BiPredicate<Path, BasicFileAttributes> predicate = (p, a) -> p.endsWith(null);//No puede terminar en null
        BiPredicate<Path, BasicFileAttributes> predicate = (p, a) -> p.endsWith("null");
        try(var paths = Files.find(root, 2, predicate))
        {
            paths.forEach(System.out::println);
        }
    }
}

class Printer<String> {
    private String t;
    Printer(String t){
        this.t = t;
    }
}

class Test12 {
    public static void main(String[] args) {
        Printer<Integer> obj = new Printer<>(100);
        System.out.println(obj);
    }
}

class Test13 {
    public static void main(String[] args) {
        int jobCode = 0;
        String status = switch(jobCode) {
            case -1 -> {
                String temp = "FAILED";
                yield temp;
            }
            case 0 -> "RUNNING";
            case 1 -> {
                yield "SUCCESS";
            }
            default -> "NA";
        };
        System.out.println(status);
    }
}

class Test14 {
    public static void main(String[] args) {
        String str = "Think"; //Line n3
        change(str); //Line n4
        System.out.println(str); //Line n5
    }

    private static void change(String s) {
        s.concat("_Twice"); //Line n9
    }
}

class Test15 {
    public static void main(String[] args) {
        List<String> list;
        list = new ArrayList<>(); //Line n1
        list.add("A");
        list.add("E");
        list.add("I");
        list.add("O");
        list.add("U");
        list.addAll(list.subList(0, 4)); //Line n2
        System.out.println(list);
    }
}

class Test16 {
    public static void main(String[] args) {
        var map1 = Map.of("1", "2", "3", "4");
        var map2 = Map.ofEntries(Map.entry("3", "4"), Map.entry("1", "2"));
        var list1 = List.of("1", "2", "3", "4");
        var list2 = List.of("4", "3", "2", "1");
        System.out.println(map1.equals(map2) + ":" + list1.equals(list2));//true:false
    }
}

class Test17 {
    private static boolean isDirection(int ch) {
        return switch(ch) {
            case 'N', 'E', 'W', 'S' -> true;
            default -> false;
        };
    }

    public static void main(String[] args) {
        String str = "North East West South";
        str.chars()
                .filter(Test17::isDirection)
                .forEach(c -> System.out.print((char)c));
    }
}

class Test18 {
    public static void main(String[] args) {
        Integer i = 10;
        List<Integer> list = new ArrayList<>();
        list.add(i);
        list.add(i *= 2);
        list.add(i);

        //list.removeIf(i -> i == 10); YA SE DECLARO EL i

        System.out.println(list);
    }
}
class Test19 {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "ONE");
        map.put(2, "TWO");
        map.put(3, "THREE");

        //System.out.println(map.stream().count()); NO EXISTE STREAM EN MAP
    }
}
enum ShapeType {
    CIRCLE, SQUARE, RECTANGLE;
}

abstract class Shape {
    private ShapeType type = ShapeType.SQUARE; //default ShapeType

    Shape(ShapeType type) {
        this.type = type;
    }

    public ShapeType getType() {
        return type;
    }

    abstract void draw();
}

class Test20 {
    public static void main(String [] args)  {
        var prop = new Properties();
        prop.setProperty("msg", "Hello");
        prop.setProperty("greet", "Welcome!");
        var mf = new MessageFormat("{1} and {0}");
        /*INSERT*/
       System.out.println(mf.format(new Object[] {prop.get("greet"), prop.get("msg")}));

       System.out.println(mf.format(new Object[] {prop.getProperty("greet"), prop.get("msg")}));

       System.out.println(mf.format(new Object[] {prop.getProperty("Greet", "Welcome!"), prop.getProperty("Msg", "Hello")}));

       //System.out.println(mf.format(new Object[] {prop.get("Greet", "Welcome!"), prop.get("Msg", "Hello")}));
    }
}