package com.oracle.ocp.udemyQ.block3.exam6;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.TextStyle;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
public class Test {
    public static void main(String [] args) {
        Locale.setDefault(Locale.US);
        var formatter = new DateTimeFormatterBuilder()
                .appendDayPeriodText(TextStyle.FULL)
                .toFormatter();
        System.out.println(formatter.format(LocalTime.of(17, 59, 0)));
    }
}

class Super {
    { System.out.print("A");}
    Super(String str) {
        System.out.print(str);
    }
    static {
        System.out.print("1");
    }
    { System.out.print("B");}
}

class Sub extends Super {
    static { System.out.print("2"); }
    Sub(String str) {
        super(str);
        System.out.print(str);
    }
    { System.out.print("C"); }
    static {
        System.out.print("3");
    }
}

 class Test2 {
    public static void main(String[] args) {
        new Sub("Z");
    }
}

class Test3 {
    public static void main(String[] args) {
        NavigableMap<Integer, String> map = new TreeMap<>();
        map.put(25, "Pune");
        map.put(32, "Mumbai");
        map.put(11, "Sri Nagar");
        map.put(39, "Chennai");

        System.out.println(map.headMap(25));
        System.out.println(map.tailMap(25));
    }
}

interface Dancer {
    default void dance() {
        System.out.println("DANCER");
    }
}

interface TapDancer extends Dancer {
    void dance();
}

class Test4 {
    public static void main(String[] args) {
        TapDancer td = () -> System.out.println("TAPDANCER"); //Line n1
        ((Dancer)td).dance(); //Line n2
    }
}

class Base {
    String msg = "INHALE"; //Line n1
}

class Derived extends Base {
    Object msg = "EXHALE"; //Line n2
}

 class Test5 {
    public static void main(String[] args) {
        Base obj1 = new Base(); //Line n3
        Base obj2 = new Derived(); //Line n4
        Derived obj3 = (Derived) obj2; //Line n5
        var var = obj1.msg + "-" + obj2.msg + "-" + obj3.msg; //Line n6
        System.out.println(var); //Line n7
    }
}

class Test6 {
    public static void main(String [] args) {
        System.out.println(new Object() {
            public String toString() {
                return "ANONYMOUS";
            }
        });
    }
}

 class Test7 {
    public static void main(String[] args) {
        System.out.printf("%2$d + %1$d", 10, 20);
    }
}

class Test8 {
    public static void main(String[] args) {
        LongFunction<LongUnaryOperator> func = a -> b -> b - a; //Line n1
        System.out.println(calc(func.apply(100), 50)); //Line n2
    }

    private static long calc(LongUnaryOperator op, long val) {
        return op.applyAsLong(val);
    }
}

class Test9 {
    public static void main(String[] args) {
        var str1 = Stream.iterate(1, k -> k <= 10, i -> i + 1)
                .reduce("", (i, s) -> i + s, (s1, s2) -> s1 + s2);
        var str2 = Stream.iterate(1, k -> k <= 10, i -> i + 1)
                .parallel()
                .reduce("", (i, s) -> i + s, (s1, s2) -> s1 + s2);
        System.out.println(str1.equals(str2));
    }
}

class Test10 {
    public static void main(String[] args) {
        try {
            main(args);
        } catch (Exception ex) {
            System.out.println("CATCH-"); //Line n1
        }
        System.out.println("OUT"); //Line n2
    }
}

class Test11 {
    public static void main(String[] args) {
        Consumer<Integer> consumer = System.out::print;
        Integer i = 5;
        consumer.andThen(consumer).accept(i++); //Line n1
        LocalDate date = LocalDate.ofEpochDay(-1);
        System.out.println(date);
    }
}

class Outer {
    private String name = "NOW OR NEVER";
    //Insert inner class definition here
    class Inner {
        String name = "NOW OR NEVER 2";
        public void printName(){
            System.out.println(this.name);
            System.out.println(name);
            System.out.println(Outer.this.name);
        }
    }
}

class Test12 {
    public static void main(String [] args) {
        new Outer().new Inner().printName();
    }
}

class Test13 {
    public static void main(String [] args) {
        LocalDate date1 = LocalDate.parse("1980-03-16");
        LocalDate date2 = LocalDate.parse("1980-03-16");
        System.out.println(date1.equals(date2) + " : " + date1.isEqual(date2));
    }
}
class Test14 {
    public static void main(String[] args) {
        Stream<Integer> stream = Arrays.asList(1,2,3,4,5).stream();
        System.out.println(stream.mapToInt(i -> i)
                .average()
                // .getAsInt());//Cannot resolve method 'getAsInt' in 'OptionalDouble'
                );
    }
}

enum CURRENCY {
    DOLLAR, POUND, YEN
}
class Test15 {
    public static void main(String[] args) {
        var amount = 1000;
        var curr = CURRENCY.DOLLAR;
        switch (curr) {
            case DOLLAR:
                String sign = "$";
                System.out.println(sign + amount);
            case POUND:
                //String sign = "£"; NO SE PUEDE USAR EL MISMO
                String sign2 = "£";
                System.out.println(sign2 + amount);
            case YEN:
                //String sign = "¥"; NO SE PUEDE USAR EL MISMO
                String sign3 = "¥";
                System.out.println(sign3 + amount);

        }
    }
}

class Test16 {
    public static void main(String[] args) throws IOException { //FUNDAMENTAL
        try(FileReader fr = new FileReader("C:/temp.txt")) {

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}


class Test17 {
    public static void main(String[] args) {
        Stream.of(true, false, true)
                .map(b -> b.toString().toUpperCase())
                .peek(System.out::println)
                .count();
    }
}

class Test18 {
    public static void main(String[] args) {
        var var = 3; //Line n1
        String [][] arr = new String[--var][var++]; //Line n2
        arr[1][1] = "X"; //Line n3
        arr[1][2] = "Y"; //Line n4
        for(String [] arr1 : arr) {
            for(String s : arr1) {
                if(s != null)
                    System.out.print(s);
            }
        }
    }
}

class Test19 {
    public static void main(String[] args) {
        List list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add("3"); //Line n1
        //list.removeIf(i -> i % 2 == 1); //Line n2 ERROR
        System.out.println(list);
    }
}

interface Test20 extends Dancer {

    void test();
    default void test(String name) {
        System.out.println("Testing " + name);
    }

    static void test(int x) {
        System.out.println(x);
    }

    //private default void log1() {}

    private void log2() {}

    private static void log3() {}

}

class Test21 {
    public static void main(String[] args) {
        Optional<Integer> optional = Optional.of(null);
        System.out.println(optional);//null pointer
    }
}

class Test22 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(4);
        list.add(0, "MOVE");
        //OJO, SI NO PONGO EL UNO Y LUEGO ITERO ESTO GENERA UN RUNTIME
        list.add(2, "ON");

        System.out.println(list);
    }
}

record Student(String name, String exam) implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return s2.name.compareToIgnoreCase(s1.name);
    }

    @Override
    public String toString() {
        return '{' + name + ", " + exam + '}';
    }
}

class Test23 {
    public static void main(String[] args) {
        Student stud1 = new Student("John", "OCA");
        Student stud2 = new Student("Jack", "OCP");
        Student stud3 = new Student("Rob", "OCP");
        List<Student> list = Arrays.asList(stud1, stud2, stud3);
        list.sort(new Student(null, null));
        list.forEach(System.out::println);
    }
}

class Test24 {
    public static void main(String[] args) {
        Stream.of(List.of('A', 'N', 'T'), List.of('A', 'Q', 'U', 'A'))
                .filter(Predicate.not(l -> l.size() > 3))
                .flatMap(l -> l.stream())
                .toList()
                .forEach(System.out::print);
    }
}

class Test25 {
    public static void main(String[] args) {
        var locale = new Locale("temp", "UNKNOWN"); //Line 7
        System.out.println(locale.getLanguage() + ":" + locale.getCountry()); //Line 8
        System.out.println(locale); //Line 9
    }
}


class Test26 {
    public static void main(String[] args) {
        var list1 = List.of("Melon", "Apple", "Banana", "Mango");
        var list2 = new CopyOnWriteArrayList<>(list1);
        for(String s : list2) {
            if(s.startsWith("M")){
                list2.remove(s);
            }
        }
        System.out.println(list1);
        System.out.println(list2);
    }
}

record Fruit(String name, String countryOfOrigin) implements Comparable<Fruit>, Comparator<Fruit> {
    Fruit() {this(null, null);}

    @Override
    public String toString() {
        return name + ":" + countryOfOrigin;
    }

    @Override
    public int compareTo(Fruit o) {
        return this.name.compareToIgnoreCase(o.name);
    }

    @Override
    public int compare(Fruit o1, Fruit o2) {
        return o1.countryOfOrigin.compareToIgnoreCase(o2.countryOfOrigin);
    }

    public static int comp(String s1, String s2) {
        return s2.compareToIgnoreCase(s1);
    }
}

class Test27 {
    public static void main(String[] args) {
        List<Fruit> list = new ArrayList<>();
        list.add(new Fruit("Olive", "Middle East"));
        list.add(new Fruit("Mango", "India"));
        list.add(new Fruit("Cranberry", "North America"));
        list.add(new Fruit("Watermelon", "Africa"));
        list.add(new Fruit("Peach", "China"));
        list.add(new Fruit("Fig", "Middle East"));
        list.add(new Fruit("Blueberry", "North America"));

        /* INSERT */
        //.stream().sorted(Comparator.comparing(f -> f.countryOfOrigin(), Fruit::comp)).forEach(System.out::println);
        //list.stream().sorted(new Fruit().reversed()).forEach(System.out::println);
        //list.stream().sorted().forEach(System.out::println);
        list.stream().sorted(new Fruit()).forEach(System.out::println);
    }
}