package com.oracle.ocp.udemyQ.block4.exam4;
import java.sql.SQLException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

enum TrafficLight {
    RED, YELLOW, GREEN;
}

public class Test {
    public static void main(String[] args) {
        TrafficLight tl1 = TrafficLight.GREEN;
        //TrafficLight tl2 = tl1.clone(); //Line n1 ERROR, no se puede usar clone
        System.out.println("tl2"); //Line n2
    }
}


class A {
    public void print() {
        System.out.println("A");
    }
}

class B extends A {
    public void print() {
        System.out.println("B");
    }
}

 class C extends A {
    public void print() {
        System.out.println("C");
    }
}
class Test2 {
    public static void main(String[] args) {
        A obj1 = new C();
        A obj2 = new B();
        C obj3 = (C)obj1;
        C obj4 = (C)obj2;
        obj3.print();
    }
}

class Test3 {
    public static void main(String[] args) {
        var map = new LinkedHashMap<String, String>();
        map.put("1",  null);
        map.put("2",  "John");
        map.put("3", "Evelyn");
        map.merge("1", "Harper", String::concat); //Line n1 RARO PERO FUNCIONA
        map.merge("2", "Lucy", (s1, s2) -> s2 + ":" + s1); //Line n2
        map.merge("3", "Juliet", (s1, s2) -> s1.concat(":").concat(s2)); //Line n3
        System.out.println(map);
    }
}

class Greet {
    public void sayHello() {
        System.out.println("Hello!");
    }
}

class Test4 {
    public static void main(String[] args) {
        Greet obj = new Greet() {
            public void SayHello() {
                System.out.println("HELLO!");
            }
        };
        obj.sayHello();
    }
}

 class Test5 {

    public static void main(String[] args) {
        var a = DoubleStream.iterate(Double.valueOf(1.0), i -> i <= 3.0, i -> i + 1);
        var b = a.mapToObj(i -> "" + i)
                .collect(Collectors.joining(", "));
        System.out.println(b);
    }
}

interface DoubleToByte {
    byte getValue();
}

class Test6 {
    public static void main(String[] args) {
        int ref = 10;
        List<Integer> list = new ArrayList<>();
        list.stream().anyMatch(i -> {
            System.out.println("DON'T PANIC");
            return true; //> ++ref; tuebe que ser efectivmaente final
        });
    }
}

class MyException1 extends RuntimeException {}

class MyException2 extends RuntimeException {}

class Test7 {//REVIAR, TUVE SUERTE
        private static void m() {
        try {
            throw new RuntimeException();
        } catch(RuntimeException ex) {
            throw new MyException1();
        } finally {
            throw new MyException2();
        }
    }

    public static void main(String[] args) {
        try {
            m();
        } catch(MyException1 e) {
            System.out.println("MyException1");
        } catch(MyException2 e) {
            System.out.println("MyException2");
        } catch (RuntimeException e) {
            System.out.println("RuntimeException");
        }
    }
}

 class Test8 {
    private static void availableSeats() throws SQLException {
        throw null; //Line n1
    }

    public static void main(String[] args) {
        try {
            availableSeats(); //Line n2
        } catch(SQLException e) {
            System.out.println("SEATS NOT AVAILABLE");
        }
    }
}

class Test9 {
    public static void main(String[] args) {
        var list = new ArrayList<>(); //Line n1
        list.add("TAKE");
        list.add("THE");
        list.add("RISK");
        System.out.println(String.join(".", (CharSequence) list)); //Line n2
        //System.out.println(String.join(".", list)); //Line n2 Error en lista de objeto
    }
}

class Accumulator {
    private List<Integer> list = new ArrayList<>();

    public synchronized void accumulate(int i) {
        list.add(i);
    }

    public List<Integer> getList() {
        return list;
    }
}

 class Test10 {
    public static void main(String [] args) {
        var s = Executors.newFixedThreadPool(1000);
        var a = new Accumulator();
        for(var i =1 ; i <= 1000; i++) {
            var x = i;
            s.execute(() -> a.accumulate(x));
        }
        s.shutdown();
        System.out.println(a.getList().size());
    }
}

record Point(int x, int y) {
    @Override
    public String toString() {
        return "Point(" + x + ", " + y + ")";
    }
}

class Test11 {
    public static void main(String [] args) {
        List<Point> points = new ArrayList<>();
        points.add(new Point(4, 5));
        points.add(new Point(6, 7));
        points.add(new Point(2, 2));

        Collections.sort(points, new Comparator<Point>() {
            public int compare(Point o1, Point o2) {
                return o2.x() - o1.x();
            }
        });

        System.out.println(points);
    }
}


interface Display {
    void disp(String s);
}

class Test12 {
    public static void main(String[] args) {
        method(s -> System.out.println(s.toUpperCase()),"lambda");
    }

    private static void method(Display obj, String text) {
        obj.disp(text);
    }
}

class Test13 {
    public static void main(String[] args) {
        var list = List.of("A", "E", "I", "O", "U"); //Line n1
        var set1 = Set.copyOf(list); //Line n2

        var map = Map.of(1, "U", 2, "O", 3, "I", 4, "E", 5, "A"); //Line n3
        var set2 = Set.copyOf(map.values()); //Line n4

        System.out.println(set1.equals(set2)); //Line n5 TRUE
    }
}

class Test14 {
    public static void main(String[] args) {

        List<? super String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        //ERROR
//        for(String str : list) {
//            System.out.print(str);
//        }
    }
}

class Test15 {
    public static void main(String [] args) {
        var date = LocalDate.now();
        var time = LocalTime.now();
        var dateTime = LocalDateTime.of(date, time);
        var zonedDateTime = ZonedDateTime.now();

        /*INSERT*/
        System.out.println(zonedDateTime.format(DateTimeFormatter.ofPattern("'It''s' dd-mm-yyyy")));
    }
}