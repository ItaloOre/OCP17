package com.oracle.ocp.udemyQ.block3.exam5;
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
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
public class Test {
    public static void main(String[] args) {
        Boolean [] arr = new Boolean[2];
        List<Boolean> list = new ArrayList<>();
        list.add(arr[0]);
        list.add(arr[1]);

        if(list.remove(0)) {
            list.remove(1);
        }

        System.out.println(list);
    }
}

class Season {
    public void printCurrentSeason() {
        System.out.println("SUMMER");
    }
}

class Test2 {
    public static void main(String[] args) {
        var season = new Season() { //Line n1
            //@Override NO FUNCIONA SI COLOCAS ESTO
            public void PrintCurrentSeason() { //Line n2
                System.out.println("WINTER");
            }
        };
        season.PrintCurrentSeason(); //Line n3
    }
}

class Test3 {
    public static void main(String[] args) {
        //for: NO SE PUEDE USAR, ES RESERVADO
        for9:
        for (int i = 2; i <= 100; i = i + 2) {
            for(int j = 1; j <= 10; j++) {
                System.out.print(i * j + "\t");
            }
            System.out.println();
            if(i == 10) {
                break for9;
            }
        }
    }
}

 class Test4 {
    public static void main(String[] args) {
        List<Integer> list = Collections.synchronizedList(new ArrayList<>());
        IntStream stream = IntStream.rangeClosed(1, 7);
        stream.parallel().map(x -> {
            list.add(x); //Line 13
            return x;
        }).forEach(System.out::print); //Line 15
        System.out.println();
        list.forEach(System.out::print); //Line 17
    }
}

class Test5 {
    public static void main(String[] args) {
        var flag1 = "Java" == "Java".replace('J', 'J'); //Line n1
        var flag2 = "Java" == "Java".replace("J", "J"); //Line n2
        System.out.println(flag1 && flag2);
    }
}

 class Test6 {
    public static void main(String [] args) {
        LocalDate date = LocalDate.parse("2020-08-31");
        System.out.println(date.plusMonths(-6));
    }
}

class Father {}

class Son extends Father {}

class GrandSon extends Son {}

abstract class Super {
    abstract List<Father> get();
}

class Sub extends Super {
    /*INSERT*/
    List<Father> get() {return null;}

    ArrayList<Father> get2() {return null;}

    //List<Son> get3() {return null;}

    //ArrayList<Son> get4() {return null;}

    //List<GrandSon> get5() {return null;}

    //ArrayList<GrandSon> get6() {return null;}

    //List<Object> get7() {return null;}

    //ArrayList<Object> get8() {return null;}
}

class Test7 {
    public static void main(String[] args) {
        var list = List.of(11, 20, 8);

        System.out.println(list.stream().max(Comparator.comparing(a -> a)).get()); //Line 1

        System.out.println(list.stream().max(Integer::compareTo).get()); //Line 2

        System.out.println(list.stream().max(Integer::max).get()); //Line 3
    }
}

class Test8 {
    public static void main(String [] args) {
        LocalDate date = LocalDate.of(2068, 4, 15);
        System.out.println(date.getMonth() + ":" + date.getMonthValue());//APRIL:4
    }
}

class Test9 {
    public static void main(String[] args) {
        List<String> emails = Arrays.asList("udayan@outlook.com", "sachin@outlook.com", "sachin@gmail.com",
                "udayan@gmail.com");
        Collections.sort(emails, Comparator.comparing(str -> str.substring(str.indexOf("@") + 1)));
        for(String email : emails) {
            System.out.println(email);
        }
    }
}

class MyException extends RuntimeException {}

class YourException extends RuntimeException {}

class Test10 {
    public static void main(String[] args) {
        try {
            throw new YourException();
        } catch(MyException | YourException e){
            //e = null; e es final
        }
    }
}

class Currency {
    String notation = "-"; //Line n1

    String getNotation() { //Line n2
        return notation;
    }
}

class USDollar extends Currency {
    String notation = "$"; //Line n3

    String getNotation() { //Line n4
        return notation;
    }
}

class Euro extends Currency {
    protected String notation = "€"; //Line n5

    protected String getNotation() { //Line n6
        return notation;
    }
}

class Test11 {
    public static void main(String[] args) {
        Currency c1 = new USDollar();
        System.out.println(c1.notation + ":" + c1.getNotation());

        Currency c2 = new Euro();
        System.out.println(c2.notation + ":" + c2.getNotation());
    }
}


 class Test12 {
    public static void main(String[] args) {
        var sb = new StringBuilder("Breathe Deeply");
        var str1 = sb.toString();//Viene a partir de un objeto
        var str2 = "Breathe Deeply";

        System.out.println(str1 == str2);
    }
}

class Test13 {
    public static void main(String[] args) {
        /*INSERT*/
        char var = 7;
        switch(var) {
            case 7:
                System.out.println("Lucky no. 7");
                break;
            default:
                System.out.println("DEFAULT");
        }
    }
}
class Test14<T> {
    //static T obj; NO PUEDE TENER STATIC OJOOO
}

class Test15 {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("d", "cc", "bbb", "aaaa");
        stream.sorted((S1,S2) -> S1.length() - S2.length())
                .forEach(System.out::println);
    }
}

class Test16 {
    static Double d1;
    static int x = d1.intValue();

    public static void main(String[] args) {
        System.out.println("HELLO");
    }
}

class Test17 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("A", "E", "I", "O", "U"));
        if(verify(list, l -> l.remove("I"))) //Line n1
            if(verify(list, l -> l.add("I"))){} //Line n2

        System.out.println(list);
    }

    private static boolean verify(List<String> list, Predicate<List<String>> predicate) {
        return predicate.test(list); //Line n3
    }
}

interface ILogger {
    void log();
}

class Test18 {
    public static void main(String[] args) {
        ILogger [] loggers = new ILogger[2]; //Line n1
        for(ILogger logger : loggers)
            logger.log(); //Line n2
    }
}

record Certification(String studId, String test, int marks) {
    public String toString() {
        return "{" + studId + ", " + test + ", " + marks + "}";
    }
}

class Test19 {
    public static void main(String[] args) {
        Certification c1 = new Certification("S001", "OCA", 87);
        Certification c2 = new Certification("S002", "OCA", 82);
        Certification c3 = new Certification("S001", "OCP", 79);
        Certification c4 = new Certification("S002", "OCP", 89);
        Certification c5 = new Certification("S003", "OCA", 60);
        Certification c6 = new Certification("S004", "OCA", 88);

        Stream<Certification> stream = Stream.of(c1, c2, c3, c4, c5, c6);
        Map<Boolean, List<Certification>> map =
                stream.collect(Collectors.partitioningBy(s -> s.equals("OCA")));
        System.out.println(map.get(true));
    }
}

class Test20 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList (2, 3, 4);
        //UnaryOperator<Long> operator = s -> s*s*s;
        UnaryOperator<Integer> operator = s -> s*s*s;
        list.replaceAll(operator);
        list.forEach(System.out::println);
    }
}

class Test21 {
    public static void main(String[] args) {
        var stream = Stream.of(1, 2, 3);

        var result = stream.<String>mapMulti((x, y) -> {
            y.accept(x + "");
            y.accept(x * x + "");
            y.accept(x * x * x + "");
        }).collect(Collectors.joining(", "));

        System.out.println(result);
    }
}

class Test22 {
    public static void main(String[] args) {
        BinaryOperator<List<String>> operator = BinaryOperator.minBy((s1, s2) -> s1.size() - s2.size()); //Line n1
        var list = List.of(List.of("CAPRE ", "DIEM ", "!"), List.of("BON ", "VOYAGE")); //Line n2
        operator.apply(list.get(0), list.get(1)).forEach(System.out::print); //Line n3
    }
}

class Test23 {
    public static void main(String [] args) {
        var date = LocalDate.of(2012, 1, 11);
        var period = Period.ofMonths(2);
        var formatter = DateTimeFormatter.ofPattern("MM-dd-yy");
        System.out.print(formatter.format(date.minus(period)));
    }
}
