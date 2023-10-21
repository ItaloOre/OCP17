package com.oracle.ocp.udemyQ.block1.exam3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test extends ListResourceBundle {//SI EXTIENDO DE ListResourceBundle tengo que usar su metodo
    public static void main(String[] args) {
        var names = List.of("John", "william", "Claire", "HOPE", "Clark", "Hunter", "Kirk");

        //OJO, SI ES UNO U OTRO NO UNO Y OTRO
        search(names, "jack")
                .or(() -> search(names, "Jon"))
                .or(() -> search(names, "hope"))
                .or(() -> search(names, "Clark"))
                .stream()
                .forEach(System.out::print);
    }

    static Optional<String> search(List<String> list, String textToSearch) {
        return list.stream()
                .filter(s -> s.equalsIgnoreCase(textToSearch))
                .findFirst();
    }

    @Override
    protected Object[][] getContents() {//RECUERDA QUE ES UN OBJECT[][]
        return new Object[0][];
    }
}

 class Test2 {
    public static void main(String[] args) {
        try(var writer = new BufferedWriter(new FileWriter("C:\\Users\\Italo\\Downloads\\test.txt")))
        {
            writer.close();
            writer.newLine();
        } catch(IOException e) {
            System.out.println(e);//java.io.IOException: Stream closed
        }
    }
}

class Test3 {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("apple");
        fruits.add("orange");
        fruits.add("grape");
        fruits.add("mango");
        fruits.add("banana");
        fruits.add("grape");

        if(fruits.remove("grape"))
            fruits.remove("papaya");

        System.out.println(fruits);
    }
}

 class Test4 {
    private static void getData() throws SQLException {
        try {
            throw new SQLException();
        } catch (Exception e) {
            e = new SQLException();
            //throw e; ESPERA UN Exception PERO SOLO PATEAS EL SQL
        }
    }

    public static void main(String[] args) {
        try {
            getData();
        } catch(SQLException e) {
            System.out.println("SQL");
        }
    }
}

record Rope(int length, String color) {
    @Override
    public String toString() {
        return "Rope [" + color + ", " + length + "]";
    }

    record RedRopeFilter() {//ES POSIBLE TENER record dentro de otro record
        boolean filter(Rope rope) {
            return rope.color.equalsIgnoreCase("Red");
        }
    }
}

class Test5 {
    public static void main(String[] args) {
        var list = List.of(new Rope(5, "red"),
                new Rope(10, "Red"), new Rope(7, "RED"),
                new Rope(10, "green"), new Rope(7, "Blue"));

        list.stream()
                .filter(new Rope.RedRopeFilter()::filter)
                .forEach(System.out::println);

        String[] arr = new String[2];
    }
}

class Test6 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("T", "S", "R", "I", "F");
        ListIterator<String> iter = list.listIterator(5);//5 SIZE
        while(iter.hasPrevious()) {//ORDEN INVERSO
            System.out.print(iter.previous());
        }
    }
}

class Number { //OJOO
    public void find() {
        final int x = 10;
        record Calculator(int num){ //Line n1
            int calc() {
                //X DEBE SER ESTATICO PARA FUNCIONA AQUI
                //return num * x; //Line n2
                return 1;
            }
        }
        System.out.println(new Calculator(10).calc()); //Line n3
    }
}

class Test7 {
    public static void main(String[] args) {
        new Number().find(); //Line n4
    }
}

class Test8 {
    public static void main(String[] args) {
        String res = "";
        loop: for(var i = 1; i <= 5; i++) { //Line n1
            switch(i) {
                case 1:
                    res += "UP ";
                    break;
                case 2:
                    res += "TO ";
                    break;
                case 3:
                    break;
                case 4:
                    res += "DATE";
                    break loop;
            }
        }
        System.out.println(String.join("-", res.split(" "))); //Line n2

    }
}

class Test9 {
    public static void main(String[] args) {
        extractInt(2.7);
        //extractInt(2); Necesita un double
    }

    private static void extractInt(Double obj) {
        System.out.println(obj.intValue());
    }
}

class Resource1 implements AutoCloseable {
    public void m1() throws Exception {
        System.out.print("A");
        throw new Exception("B");
    }

    public void close() {
        System.out.print("C");
    }
}

class Resource2 implements AutoCloseable {
    public void m2() {
        System.out.print("D");
    }

    public void close() throws Exception {
        System.out.print("E");
    }
}

class Test10 {
    public static void main(String[] args) {
        try (Resource1 r1 = new Resource1();
             Resource2 r2 = new Resource2()) {
            r1.m1();
            r2.m2();
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
}

record Furniture(String name, double weight, double price) {
    public String toString() {
        return name;
    }
}

class Test11 {
    public static void main(String [] args) {
        List<Furniture> list = new ArrayList<>();
        list.add(new Furniture("Chair", 10.2, 40));
        list.add(new Furniture("Table", 23.7, 300));
        list.add(new Furniture("Sofa", 41, 900));
        list.add(new Furniture("Bed", 45, 1500));
        list.add(new Furniture("Cabinet", 51, 2000));

        process(list, f -> f.weight() < 45);
    }

    private static void process(List<Furniture> list, Predicate<Furniture> predicate) {
        Iterator<Furniture> iterator = list.iterator();
        while(iterator.hasNext()) {
            Furniture f = iterator.next();
            if(predicate.test(f))
                System.out.print(f + " ");
        }
    }
}

class Test13 {
    /*Insert-1*/
    public static void main(String[] args) {
        System.out.println(combine(List.of(1, 2), List.of(3, 4)));
    }

    /*Insert-2*/
    @SafeVarargs
    public static List<Integer> combine(List<Integer>... list) {
        return Arrays.stream(list)
                .flatMap(s -> s.stream())
                .collect(Collectors.toList());
    }
}

class Parent {
    Parent() throws IOException {
        System.out.print("HAKUNA");
    }
}

class Child extends Parent {
    Child() throws Exception {
        System.out.println("MATATA");
    }
}

class Test14 {
    public static void main(String[] args) throws Exception {
        new Child();
    }
}

class Test15 {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("mars", "pluto", "sun",
                "earth", "mars", "pluto");
        Set<String> set = stream.collect(Collectors.toCollection(TreeSet::new));
        System.out.println(set);
    }
}

interface Creator<T, R> {
    R create(T t);
}

class Log {
    Log() {
        System.out.println(1);
    }

    Log(String name) {
        System.out.println(2);
    }
}

class Test16 {
    public static void main(String[] args) {
        Creator<String, Log> obj = Log::new;
    }
}