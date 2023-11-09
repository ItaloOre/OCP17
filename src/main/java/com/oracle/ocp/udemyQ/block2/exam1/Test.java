package com.oracle.ocp.udemyQ.block2.exam1;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


//static record Pregunta1(int x, int y){} OJO, NO VALIDO
//intance record Pregunta1(int x, int y){} OJO, NO VALIDO
//native record Pregunta1(int x, int y){} OJO, NO VALIDO

public class Test {

}

class Base {
    protected void m1() {
        System.out.println("Base: m1()");
    }
}

class Derived extends Base {
    public void m1() {// OJO, TIENE QUE SER PUBLIC
        System.out.println("Derived: m1()");
    }
}

class TestBaseDerived {
    public static void main(String[] args) {
        Base b = new Derived();
        b.m1();
    }
}

class X {
    class Y {
        private void m() {
            System.out.println("INNER");
        }
    }

    public void invokeInner() {
        var obj = new Y(); //Line n1
        obj.m(); //Line n2
    }
}

class Test2 {
    public static void main(String[] args) {
        new X().invokeInner();
    }
}

class Test3 {
    static int i1 = 10;
    int i2 = 20;

    int add() {
        return this.i1 + this.i2; //Line n1
    }

    public static void main(String[] args) {
        System.out.println(new Test3().add()); //Line n2
    }
}

class Test4 {
    public static void main(String[] args) {
        StringBuilder [] arr = {new StringBuilder("A"), new StringBuilder("A")};
        List<StringBuilder> list = Arrays.asList(arr);
        for(int i = 0; i < 2; i++)
            if(i == 0)
                list.forEach(sb -> sb.append("B"));
            else
                list.forEach(sb -> sb.append("C"));

        list.forEach(sb -> System.out.println(sb));
    }
}

interface Multiplier {
    void multiply(int... x) throws SQLException;
}

class Calculator implements Multiplier {
    public void multiply(int... x) throws Error/*Error es valido aqui*/ {

    }
}
class Test5 {
    public static void main(String[] args) {
        try {
            Multiplier obj = new Calculator(); //Line n1
            obj.multiply(1, 2, 3);
        } catch(SQLException e) {
            System.out.println(e);
        }
    }
}

class Outer {
    abstract static class Animal { //Line n1 VALIDO
        abstract void eat();
    }

    static class Dog extends Animal { //Line n2
        void eat() { //Line n3
            System.out.println("DOG EATS BISCUITS");
        }
    }
}

 class Test6 {
    public static void main(String[] args) {
        Outer.Animal animal = new Outer.Dog(); //Line n4
        animal.eat();
    }
}

class MyResource implements AutoCloseable {
    @Override
    public void close() throws IOException{
        throw new IOException("IOException");
    }

    public void execute() throws SQLException {
        throw new SQLException("SQLException");
    }
}

class Test7 {//OJO, FACIL VIENE
    public static void main(String[] args) {
        try(MyResource resource = new MyResource()) {
            resource.execute();
        } catch(Exception e) {
            System.out.println(e.getMessage());//SQLException
        }
    }
}

class Document {
    void printAuthor() {
        System.out.println("Document-Author");
    }
}

class RFP extends Document {
    @Override
    void printAuthor() {
        System.out.println("RFP-Author");
    }
}

class Test8 {
    public static void main(String[] args) {
        check(Document::new);
        check(RFP::new);
    }
    //Supplier<? super RFP> supplier da error porque Object no tiene ese metodo
    private static void check(Supplier<? extends Document> supplier) {
        supplier.get().printAuthor();
    }
}

enum Color {
    RED, GREEN, BLUE;
}

record Rope(int length, Color color) {}

class Test9 { //REVISAR PASO A PASO
    public static void main(String[] args) {
        var ropes = Stream.of(
                new Rope(100, Color.RED),
                new Rope(200, Color.BLUE),
                new Rope(200, Color.RED),
                new Rope(300, Color.RED),
                new Rope(100, Color.BLUE));

        var result = ropes.collect(
                Collectors.teeing(//Returns a Collector that is a composite of two downstream collectors
                        Collectors.filtering(x -> x.color() == Color.RED, Collectors.toList()),
                        Collectors.filtering(y -> y.color() == Color.RED, Collectors.summingInt(Rope::length)),
                        (x, y) -> {
                            var map = new LinkedHashMap<String, Object>();
                            map.put("RED-ROPE", x);
                            map.put("RED-ROPE-LENGTH", y);
                            return map;
                        }
                ));
        System.out.println(((List<Rope>)result.get("RED-ROPE")).get(1).length());
        System.out.println(result.get("RED-ROPE-LENGTH"));
    }
}