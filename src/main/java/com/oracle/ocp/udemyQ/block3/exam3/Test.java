package com.oracle.ocp.udemyQ.block3.exam3;
import java.io.*;
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
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
public class Test {
    public static void main(String[] args) {
        IntStream stream = IntStream.generate(() -> new Random().nextInt(100)).limit(5);
        //stream.filter(i -> i > 0 && i < 10).findFirst().ifPresent(System.out::println);
        stream.filter(i -> i > 0 && i < 10).findFirst().stream();
    }
}

class Test2 {
    public static void main(String[] args) {
        final String fName = "James";
        String lName = "Gosling";
        String name1 = fName + lName;
        String name2 = fName + "Gosling";
        String name3 = "James" + "Gosling";
        System.out.println(name1 == name2);//FALSE
        System.out.println(name2 == name3);//TRUE
        System.out.println(name1 == name3);//FALSE
    }
}

class Resource implements AutoCloseable {
    public void close() {
        System.out.println("CLOSE");
    }
}

 class Test3 {
    public static void main(String[] args) {
        try(Resource r = null) {
            System.out.println("HELLO");//SOLO HELLO, PORQUE ES UNA INSTANCIA NULL
        }
    }
}

record MyString(String str) {}

class Test4 {
    public static void main(String[] args) {
        var list = List.of(new MyString("Y"),
                new MyString("E"), new MyString("S"));

        list.stream()
                .map(s -> s)
                .forEach(System.out::print);//MyString[str=Y]MyString[str=E]MyString[str=S]
    }
}

 class Test5 {
    public static void main(String [] args) throws Exception {
        Callable<String> r = () -> {
            int sum = 0;
            for(int i = 1; i < 1000; i++) {
                var a = new Random().nextInt(50);
                System.out.println(a);
                sum += i / a;
            }
            return "" + sum;
        };

        var es = Executors.newSingleThreadExecutor();
        var f = es.submit(r);
        System.out.println(f.get()); //Line n1
        es.shutdown();
    }
}

interface I01 {
    void m1();
}

 class Implementer extends Object implements I01 {
     @Override
     public void m1() {

     }
     //protected void m1() { }//NO VALIDO
}
interface Creator<T> {
    T create();
}

abstract class Gift {
    public Gift() {
        super();
    }

    public String toString() {
        return "Gift";
    }
}

class Book extends Gift {
    public Book() {
        super();
    }

    public String toString() {
        return "Book";
    }
}

 class Test6 {
    public static void main(String[] args) {
        //Creator<Gift> obj = Gift::new;
        //System.out.println(obj.create());
    }
}

abstract class Log {
    abstract long count(); //Line n1
    abstract Object get(); //Line n2
}

class CommunicationLog extends Log {
    long count() {
        // int count() { //Line n3 OJO, ESTO GENERA ERROR
        return 100;
    }

    String get() { //Line n4
        return "COM-LOG";
    }
}

class Test7 {
    public static void main(String[] args) {
        Log log = new CommunicationLog(); //Line n5
        System.out.print(log.count());
        System.out.print(log.get());
    }
}

class Test8 {//CORRECTO
    public static void main(String[] args) {
        List<String> objects = new ArrayList<>();
        objects.add("Watch");
        objects.add("Arrow");
        objects.add("Anchor");
        objects.add("Drum");

        ListIterator<String> iterator = objects.listIterator();
        while(iterator.hasNext()) {
            if(iterator.next().startsWith("A")) {
                iterator.remove();
            }
        }

        System.out.println(objects);
    }
}

class StringUtil {
    /**
     * @deprecated This method has been deprecated,
     * use rev(String) method instead
     */
    @Deprecated(since = "11", forRemoval = true)
    public static String reverse(String str) {
        return str.chars() //IntStream
                .mapToObj(c -> (char)c) //Convert int to char
                .reduce("", (s1,s2) -> s2+s1, (s1,s2) -> s2+s1);

    }

    public static String rev(String str) {
        return new StringBuilder(str).reverse().toString();
    }
}

class Test9 {
    //Line n1
    public static void main(String[] args) {
        System.out.println(StringUtil.rev("HELLO")); //Line n2
        System.out.println(StringUtil.reverse("HELLO")); //Line n3
    }
}

class Test10 {
    public static void main(String[] args) {
        NavigableMap<Integer, String> map = new TreeMap<>();
        BiConsumer<Integer, String> consumer = map::putIfAbsent;
        consumer.accept(1, null);
        consumer.accept(2, "two");
        consumer.accept(1, "ONE");
        consumer.accept(2, "TWO");

        System.out.println(map);
    }
}

record Timer(Duration duration) {
    //public Timer(int minutes) {this.duration = Duration.ofMinutes(minutes); }


}

 class Test11 {
    public static void main(String[] args) {
        //var timer = new Timer(10);
        System.out.println("timer");
    }
}

class Division {
    int num;
    int den;
    int res;

    Division(int num, int den) {
        this.num = num;
        this.den = den;
    }

    void divide() {
        try {
            res = num / den;
        } catch(RuntimeException e) {}
    }

    public String toString() {
        if (den == 0)
            return num + "/" + den + " = " + "Infinity";
        else
            return num + "/" + den + " = " + res;
    }
}

class Test12 {
    public static void main(String[] args) {
        var list = List.of(new Division(100, 4), new Division(27, 0), new Division(25, 5));
        list.forEach(d -> d.divide()); //Line n1
        list.forEach(d -> System.out.println(d)); //Line n2
    }
}

class Test13 {
    static String var = "FRIENDS"; //Line n1
    public static void main(String[] args) {
        int var = (var = Test13.var.length()); //Line n2
        System.out.println(var); //Line n3
    }
}

class Test14 {
    public static void main(String [] args) {
        LocalDate d1 = LocalDate.parse("1999-09-09");
        LocalDate d2 = LocalDate.parse("1999-09-09");
        LocalDate d3 = LocalDate.of(1999, 9, 9);
        LocalDate d4 = LocalDate.of(1999, 9, 9);
        System.out.println((d1.equals(d4)) + ":" + (d2 == d3) + ":" + (d3 == d4));//false:false:false
    }
}

class Test15 {
    public static void main(String[] args) {
        IntStream.rangeClosed(1, 10)
                .parallel()
                .forEach(System.out::println);
    }
}

class Test16 {
    public static void main(String[] args) {
        NavigableSet<String> set = new TreeSet<>(Arrays.asList("red", "green", "blue", "gray"));
        System.out.println(set.ceiling("gray"));
        System.out.println(set.floor("gray"));
        System.out.println(set.higher("gray"));
        System.out.println(set.lower("gray"));
    }
}

class Test17 {
    private static void div(int i, int j) {
        try {
            System.out.println(i / j);
        } catch(ArithmeticException e) {
            throw (RuntimeException)e;
        }
    }

    public static void main(String[] args) {
        try {
            div(5, 0);
        } catch(ArithmeticException e) {
            System.out.println("AE");
        } catch(RuntimeException e) {
            System.out.println("RE");
        }
    }
}