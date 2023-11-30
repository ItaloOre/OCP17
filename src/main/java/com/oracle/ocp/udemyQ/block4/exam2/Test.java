package com.oracle.ocp.udemyQ.block4.exam2;
import java.io.*;
import java.sql.SQLException;
import java.time.LocalDate;

public class Test {
    public static void main(String [] args) {//LOOP INFINITO
        LocalDate date = LocalDate.parse("2000-06-25");
        while(date.getDayOfMonth() >= 20) {
            System.out.println(date);
            date.plusDays(-1);
        }
    }
}

 class Test2 {
    private static void m(int i) {
        System.out.print(1);
    }

    private static void m(int i1, int i2) {
        System.out.print(2);
    }

    private static void m(char... args) {
        System.out.print(3);
    }

    public static void main(String... args) {
        m('A');
        m('A', 'B');
        m('A', 'B', 'C');
        m('A', 'B', 'C', 'D');
    }
}
class Test3 {
    record R1() {
        R1 {
            System.out.println("10");
        }
        static {
            System.out.println("20");
        }
        //Instance initializer is not allowed in record
//        {
//            System.out.println("30");
//        }
        public String toString() {
            return "40";
        }
    }
    public static void main(String[] args) {
        System.out.println(new R1());
    }
}

class Printer<T extends String> {}

class Test4 {
    public static void main(String[] args) {
        Printer<String> printer = new Printer<>();
        System.out.println(printer);
    }
}

class Test5 {
    public static void main(String[] args) {
        int x = 4;
        switch (x) {
            default -> System.out.println("Unknown");
            case 1 -> System.out.println("x is equal to 1");
            case 2 -> System.out.println("x is equal to 2");
            case 3 -> System.out.println("x is equal to 3");
        }
    }
}

class Test6 {
    public static void convert(String s)
            throws IllegalArgumentException, RuntimeException, Exception {
        if(s.length() == 0) {
            throw new RuntimeException("LENGTH SHOULD BE GREATER THAN 0");
        }
    }
    public static void main(String [] args) {
        try {
            convert("");
        }
//        catch(IllegalArgumentException | RuntimeException | Exception e) { //Line n1
//            System.out.println(e.getMessage()); //Line n2
//        } //Line n3
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}

class MyResource implements AutoCloseable {
    @Override
    public void close() throws IOException{

    }

    public void execute() throws SQLException {
        throw new SQLException("SQLException");
    }
}

class Test7 {
    public static void main(String[] args) {
        try(MyResource resource = new MyResource()) {
            resource.execute();
        } catch(Exception e) {
            System.out.println(e.getSuppressed().length);
        }
    }
}

class Test8 {
    public static void main(String [] args) {
        final int i7 = 10;
        short s7 = i7;

        var tb1 = """
            Let the \
            race begin.\
        """;
        var tb2 = """
            Let the race begin.""";
        var tb3 = "Let the race begin.";

        System.out.print(tb1 == tb2);
        System.out.print(tb2 == tb3);
        System.out.print(tb1 == tb3);
    }
}

class Animal {
    @Deprecated
    public void eat() { //Line n1
        System.out.println("Generic Animal eating");
    }
    @Deprecated
    public void speak() { //Line n2
        System.out.println("Generic Animal speaking");
    }
}

class Dog extends Animal {
    @Override
    public void eat() { //Line n3
        System.out.println("Dog is eating biscuits");
    }

    @Override
    public void speak() { //Line n4
        System.out.println("Dog is barking");
    }
}

 class Test9 {
    public static void main(String[] args) {
        Dog animal = new Dog();
        animal.speak(); //Line n5
        animal.eat(); //Line n6
    }
}

 class Test10 {
    private static String print(String... args) {
        return String.join("-", args); //Line n1
    }

    private static Object print(Object... args) {
        String str = "";
        for(Object obj : args) {
            if(obj instanceof String) { //Line n2
                str += (String) obj; //Line n3
            }
        }
        return str; //Line n4
    }

    public static void main(String... args) {
        Object obj1 = new String("SPORT"); //Line n5
        Object obj2 = new String("MAD"); //Line n6
        System.out.println(print(obj1, obj2)); //Line n7
    }
}

class Foo {
    static { //static initializer block
        System.out.print("A");
    }
    class Bar {
        static { //static initializer block
            System.out.print("B");
        }
    }
}

class Test11 {
    public static void main(String [] args) {
        new Foo().new Bar();
    }
}

interface Blogger {
    default void blog() throws Exception {
        System.out.println("GENERIC");
    }
}

class TravelBlogger implements Blogger {
    public void blog() {
        System.out.println("TRAVEL");
    }
}

class Test12 {
    public static void main(String[] args) {
        Blogger blogger = new TravelBlogger(); //Line n1
        ((TravelBlogger)blogger).blog(); //Line n2
    }
}
