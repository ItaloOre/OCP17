package com.oracle.ocp.udemyQ.block1.exam5;
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
import java.util.concurrent.Executors;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class MyClass {
    MyClass() {
        System.out.println(101);
    }
}

class MySubClass extends MyClass {
    //final MySubClass() { OJO, NO SE PUEDE USAR FINAL EN UN CONSTRUCTOR
    MySubClass() {
        System.out.println(202);
    }
}
public class Test {
    public static void main(String[] args) {
        System.out.println(new MySubClass());
    }
}

sealed interface Calculator {
    int calc();
}

record Add(Calculator c1, Calculator c2) implements Calculator {
    public int calc() {
        return c1.calc() + c2.calc();
    }
}

record Multiply(Calculator c1, Calculator c2) implements Calculator {
    public int calc() {
        return c1.calc() * c2.calc();
    }
}

record Negate(int value) implements Calculator {
    public int calc() {
        return -value;
    }
}

class Test2 {
    public static void main(String... args) {
        Calculator calculator = new Add(
                new Multiply(new Negate(5), new Negate(10)),
                new Add(new Negate(25), new Negate(25))
        );
        System.out.println(calculator.calc());
    }
}

class Test3 {
    public static void main(String[] args) throws IOException {
        var src = Paths.get("C:", "TEMP", "msg");

        var tgt = Paths.get("C:", "TEMP", "Parent", "copy");
        Files.copy(src, tgt);

        System.out.println(Files.isSymbolicLink(src) + ":" + Files.isSymbolicLink(tgt));
    }
}

class Super { //OJO, la variable String e int no dan conflicto
    public String num = "10"; //Line n1
}

class Sub extends Super {
    protected int num = 20; //Line n2
}

class Test4 {
    public static void main(String[] args) {
        Super obj = new Sub();
        System.out.println(obj.num += 2); //Line n3
    }
}

class Test5 {
    public static void main(String[] args) {
        System.out.print("Enter some text: ");
        try(Scanner scan = new Scanner(System.in)) {
            String s = scan.nextLine();
            System.out.println(s);
            scan.close(); //OJO, SI SE CIERRA SE CERRO PARA SIEMPRE MRD
            //scan.nextLine();
        }
    }
}

class Test6 {
    public static void main(String[] args) {
        var console = System.console();
        if(console != null) {
            console.format("%d %<x", 10);
        }
    }
}

interface Flyable {
    void hola();
}

 class Test7 {
    public static void main(String[] args) {

        /*INSERT*/
        Flyable flyable = new Flyable() {
            @Override
            public void hola() {
                System.out.println("Hola");
            }
            public void adios() {
                System.out.println("Adios");
            }
        };
        flyable.hola();
        //flyable.adios(); NO SE PUEDE USAR
    }
}


class Calculator2 {
    int calculate(int i1, int i2) {
        return i1 + i2;
    }

    double calculate(byte b1, byte b2) {
        return b1 % b2;
    }
}

class Test8 {
    public static void main(String[] args) {
        byte b = 100;
        int i = 20;
        System.out.println(new Calculator2().calculate(b, i));//BYTE SE PUEDE PASAR A INT
    }
}

abstract class Base {
    public abstract void print() throws IOException;
}

class Derived extends Base {
    @Override
    public void print() throws IOException {
        throw new FileNotFoundException();
    }
}

class Test9 {
    public static void main(String[] args) throws IOException {//OJO, CON LA EXCEPCION QUE SE PIDA
        Base b = new Derived();
        try {
            b.print();
        } catch (FileNotFoundException e) {
            System.out.print("AWE");
        } finally {
            System.out.print("SOME");
        }
    }
}

class Test10 {//OJO CON ESE THEN COMPARING
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("d", "a", "mm", "bb", "zzz", "www");
        Comparator<String> lengthComp = (s1, s2) -> s1.length() - s2.length();
        stream.sorted(lengthComp.thenComparing(String::compareTo)).forEach(System.out::println);
    }
}

class Test11 {
    final static StringBuilder sb = new StringBuilder("A");
    static int x = 2;
    public static void main(String[] args) {
        switch (x) {
            default:
                sb.append("B"); //Line n1
            case 1, 3, 5, 7, 9:
                sb.append("C"); //Line n2
                break;
        }
        System.out.println(x + ":" + sb.toString()); //Line n3
    }
    static {
        sb.append("Z");
    }
    { x += 1; }
}


class Test12 {
    public static void main(String[] args) {
        /*INSERT*/
        //short arr [] = new short[2]; Es muy chico
        //byte [] arr = new byte[10]; OK
        //short [] arr; arr = new short[3]; OK
        // short [3] arr ; ERROR
        int [] arr = new int[]{0, 0, 0, 0};
        arr[1] = 5;
        arr[2] = 10;
        System.out.println("[" + arr[1] + ", " + arr[2] + "]"); //Line n1
    }
}

class Test18 {
    public static void main(String[] args) {
        try {
            System.out.println(args[1].length());
        } catch (RuntimeException ex) {
            System.out.println("ONE");
//        } catch (FileNotFoundException ex) { NUNCA ES UTILIZADA
//            System.out.println("TWO");
//        }
        System.out.println("THREE");
    }
}}
