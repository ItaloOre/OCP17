package com.oracle.ocp.udemyQ.block2.exam6;
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
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        var numbers = Stream.of(100, 200, 300, 400, 500);
        var average = numbers.collect(
                Collectors.teeing(
                        Collectors.summingLong(Long::valueOf),
                        Collectors.counting(),
                        (sum, count) -> sum/count
                )
        );
        System.out.println(average);//300
    }
}

 class Test2 {
    public static void main(String [] args) {
        String text = null;
        //.out.println(text.repeat(3)); EEROR, REPEAT NO ACPETA NULOS
        System.out.println(null + "null" + null);
        //System.out.println(text*=3); ESTO NO APLICA PARA STRING
        //System.out.println(null+null+null);//NO FUNCIONA
        System.out.println(text+text+text);

        //text += null;
        //System.out.println((text.concat(null))); no se puede usar concat si es null

        System.out.println(text+= "null".repeat(2));

    }
}

 class Test3 {
    public static void main(String[] args) {
        int sum = 0;
        for(var i = 0; i < 7; i++) { //Line n1
            if(i == 4)
                break;
            else
                continue;
            //sum += i; //Line n2 OJO, CODIGO UNREDABLE
        }
        System.out.println(sum); //Line n3
    }
}

class A {}

class B extends A {}

class C extends B {}

class D extends C {}

 class Test4 {
    public static void main(String... args) {
        A a = new C();
        if(!(a instanceof D d))
            System.out.print("Not an instance of D.");
        else
            System.out.println(d);
    }
}

interface Operator<T> {
    public abstract T operation(T t1, T t2);
}

class Test5 {
    public static void main(String[] args) {
        //System.out.println((String s1, String s2) -> s1+s2); NO SE PUEDE LLAMAR A UN VOID AQUI
    }
}


class Test6 {
    public static void main(String[] args) {
        //SOLO VALORES DEL 1 AL 10
        var map = Map.of(
                1, "A",
                2, "B",
                3, "C",
                4, "D",
                5, "E",
                6, "F",
                7, "G",
                8, "H",
                9, "I",
                10, "J"
        );

        var res = "";
        for(String str : map.values()) {
            res += str;
        }
        System.out.println(res);
    }
}

class T {
    @Override
    public String toString() {
        return "T";
    }
}
class Printer<T> {
    private T t;
    Printer(T t){
        this.t = t;
    }
    @Override
    public String toString(){
        return t.toString();
    }
}
 class Test7 {
    public static void main(String[] args) {
        Printer<T> obj = new Printer<>(new T());
        System.out.println(obj);

    }
}


class Test8 {
    public static void main(String[] args) {
        List<String> trafficLight = new ArrayList<>();
        trafficLight.add(1, "RED");
        trafficLight.add(2, "ORANGE");
        trafficLight.add(3, "GREEN");

        trafficLight.remove(Integer.valueOf(2));

        System.out.println(trafficLight);
    }
}

class Test9 {
    public static void main(String[] args) {
        var stream = Stream.of("SON", "WIFE", "MOTHER", "FATHER", "UNCLE", "DAUGHTER");
        var map = stream.parallel()
                .collect(Collectors.groupingByConcurrent(s -> s.length() > 4));
        System.out.println(map.get(false).size());
    }
}

class Test10 {
    public static void main(String[] args) {
        String text = "I am going to pass OCP exam in first attempt";
        Stream<String> stream = Arrays.stream(text.split(" "));
        IntSummaryStatistics stat = stream.mapToInt(s -> s.length())//map to Int tiene statistic el map no
                .summaryStatistics();
        System.out.println(stat.getMax());
    }
}


interface Perishable1 {
    default int maxDays() {
        return 1;
    }
}

interface Perishable2 extends Perishable1 {
    default int maxDays() {
        return 2;
    }
}

class Milk implements Perishable2, Perishable1 {}

class Test11 {
    public static void main(String[] args) {
        Perishable1 obj = new Milk();
        System.out.println(obj.maxDays());//SALE 2
    }
}

class M {
    public void main(String[] args) { //Line n1
        System.out.println("M");
    }
}

class N extends M {
    //public static void main(String[] args) { //Line n2
     //   new M().main(args); //Line n3
    //}
}

class Test12 {
    public static void main(String[] args) {
        //N.main(args); //Line n4
    }
}

class Test13 {
    public static void main(String[] args) {
        try {
            play();
            return;
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
            return;
        } finally {
            System.out.println("MATCH ABANDONED");
        }
        //System.out.println("DONE"); OJO, GENERA ERROR POR EL return
    }

    static void play() throws Exception {
        throw new Exception("INJURED");
    }
}