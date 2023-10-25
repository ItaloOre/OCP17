package com.oracle.ocp.udemyQ.block1.exam4;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
interface Creator<T> {
    T create();
}

public class Test {
    public static void main(String[] args) {
        Creator<String> obj = process("  abc d")::toUpperCase;
        System.out.println(">" + obj.create() + "<");
    }

    private static String process(String str) {
        return str.trim();
    }
}

class Test2 { //OJO CON ESTA PREGUNTA
    public static void main(String[] args) {
        StringBuilder[] array1 = { new StringBuilder("Manners"), new StringBuilder("maketh"),
                new StringBuilder("Man") };
        StringBuilder[] array2 = { new StringBuilder("Manners"), new StringBuilder("maketh"),
                new StringBuilder("man") };
        System.out.print(Arrays.mismatch(array1, array2));//Sale 0 porque index 0 tienen objetos distintos
        System.out.print(Arrays.compare(array1, array2));//-32
    }
}

class Logger {
    public void log() {
        System.out.println("GO FOR IT");
    }
}

class Test3 {
    public static void main(String[] args) {
        Logger obj = new Logger() {
            public void Log() {
                System.out.println("LET IT BE");
            }
        };
        obj.log();
    }
}

class Test4 {
    public static void main(String[] args) {
        UnaryOperator<String> opr1 = s -> {
            System.out.print(1);
            return s.toUpperCase();
        };
        UnaryOperator<String> opr2 = s -> {
            System.out.print(2);
            return new StringBuilder(s).reverse().toString();
        };
        UnaryOperator<String> opr3 = s -> {
            System.out.print(3);
            return s.substring(2);
        };

        opr1.andThen(opr2).compose(opr3); //Line n1
        System.out.println(opr1.apply("amar")); //Line n2
    }
}

 class Test5 {
    public static void main(String[] args) throws ParseException { //OJO ParseException OBLIGATORIO
        var dateFormatter = DateTimeFormatter.ofPattern("dd-MM-uuuu"); //Line n1
        System.out.println(dateFormatter.parse("10-5-2019")); //Line n2
        var currFormatter = NumberFormat.getCurrencyInstance(Locale.US); //Line n3
        System.out.println(currFormatter.parse("$7.00")); //Line n4
    }
}

class Test6 {
    static int a = 10000;
    static {
        a = -a--;
    }
    { //NO SE EJECUTA SI NO HAGO UN NEW
        a = -a++;
    }

    public static void main(String[] args) {
        System.out.println(a);
    }
}

class Util {
    static  int ctr = 0;
    private static Util obj;
    private Util() {
        ++ctr;
    }
    static synchronized Util get() {
        if(obj == null)
            obj = new Util();
        System.out.println(ctr);
        return obj;
    }
}
class Test7 {
    public static void main(String[] args) {
        var es = Executors.newFixedThreadPool(100);
        IntStream.rangeClosed(1, 10000)
                .parallel()
                .forEach(x -> es.submit(() -> Util.get()));
        es.shutdown();
        //Line n1
    }
}

class Test8 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("M", "R", "A", "P");
        Collections.sort(list, null);//SI se le pasa null a la derecha lo ordena de manera natural bb
        System.out.println(list);
    }
}

interface Counter {
    int count = 10; //Line n1
}
class Test9 {
    public static void main(String[] args) {
        Counter [] arr = new Counter[2]; //Line n2
        for(Counter ctr : arr) {
            System.out.print(ctr.count); //Line n3
        }
    }
}

sealed abstract class A { } //Line n1

final class B extends A { } //Line n2

non-sealed class C extends A { } //Line n3

//final record D() extends A { } //Line n4 lo records no puedes heredar de otra clase

class Test10 {
    public static void main(String [] args) {
        System.out.println("SEALED CLASS");

    }
}

class Test11 {
    public static void main(String[] args) {
        var list = new ArrayList<>(); //Line n1
        list.add(7);
        list.add(14);
        list.add(21);

        var sum = 0; //Line n2
//        for(int i : list){ //Line n3 ES UN OBJECT NO INT
//            sum += i;
//        }
        System.out.println(sum);
    }
}

class Test12 {
    public static void main(String[] args) {//el takeWhile toma los elementos hasta su condicion
        String str = Stream.of("an", "and", "after", "ad", "before")
                .takeWhile(s -> s.length() < 4)
                .collect(Collectors.joining(", "));
        System.out.println(str);
    } //an, a
}

class Test13 {
    public static void main(String[] args) {

        String furniture = new String(new char[] {'S', 'o', 'f', 'a'});
        switch (furniture) {
            default:
                System.out.println("CHAIR");
            case "Recliner":
                System.out.println("RECLINER");
            case "Sofa":
                System.out.println("SOFA");
            case "Bed":
                System.out.println("BED");
                break;
        }
    }
}

class Sport {
    String name = "";

    public String Sport() {
        return name;
    }

    public void Sport(String name) {
        this.name = name;
    }


    public void Sport(String... sports) {
        name = String.join(",", sports);
    }

    public Sport() {
        name = "";
    }


    public Sport(String name) {
        this.name = name;
    }

    public Sport(String name1, String name2) {
        name = String.join(",", name1, name2);
    }

}

class MyException extends RuntimeException {
    public void log() {
        System.out.println("Logging MyException");
    }
}

class YourException extends RuntimeException {
    public void log() {
        System.out.println("Logging YourException");
    }
}

class Test14 { //OJO, NO SE PUEDE LLAMAR METODO ENTRO DEL ex
    public static void main(String[] args) {
        try {
            throw new MyException();
        } catch(MyException | YourException ex){
            //ex.log;
        }
    }
}


class Test15 {
    private static final <X extends Integer, Y extends Integer> void add(X x, Y y) {
        System.out.println(x.intValue() + y.intValue());
    }

    public static void main(String[] args) {
        add(10, 20);
    }
}

class MyException2 extends RuntimeException{}

class Test16 {
    public static void main(String[] args) {
        OptionalDouble optional = OptionalDouble.empty();
        System.out.println(optional.orElseThrow(MyException2::new));
    }
}