package com.oracle.ocp.udemyQ.block4.exam6;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;
interface Printer {
    String print();
// OJO, el to String genera error
//    default String toString() {
//        return "*";
//    }

}

public class Test {
    public static void main(String[] args) {
        Printer obj = () -> "PRINTER";
        System.out.print(obj);
        System.out.print(obj.print());
    }
}

class Test2 {
    public static void main(String[] args) {
        var var = 0; //Line n1
        var: for (; var < 3; var++) {  //Line n2
            if (var % 2 == 0) {
                continue var; //Line n3
            }
            var++; //Line n4
        }
        System.out.println(var);
    }
}

class Message {
    String msg = "LET IT GO!";

    public void print() {
        System.out.println(msg);
    }
}

class TestMessage {
    public static void change(Message m) { //Line n5
        m.msg = "NEVER LOOK BACK!"; //Line n6
    }
    public static void main(String[] args) {
        Message obj = new Message(); //Line n1
        obj.print(); //Line n2
        change(obj); //Line n3
        obj.print(); //Line n4
    }
}

class Test3 {
    public static void main(String[] args) {
        LongStream stream = LongStream.empty();
        System.out.println(stream.average());//OptionalDouble.empty
    }
}

class Test4 {
    public static void main(String[] args) {
        System.out.println("Result is: " + (10 != 5));
    }
}

class Test5 {
    public static void main(String[] args) {
        var strs1 = Stream.of("E", "a");//OJO, con of es inmutable
        var strs2 = Stream.of("I", "u", "O");

        var list1 = strs1.map(s -> s.toUpperCase())
                .sorted()
                .toList();
        var list2 = strs2.map(s -> s.toUpperCase())
                .sorted()
                .collect(Collectors.toList());

        list1.addAll(list2);

        System.out.println(list1.stream()
                .collect(Collectors.joining(", ")));
    }
}

class Test6 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("ALL", "IS");
        //list.add("WELL");//PJP, MP SOPRTADO
        list.forEach(System.out::print);
    }
}

class Test7 {
    public static void main(String[] args) {
        extractInt(10.99);
        extractInt(23);
        extractInt(null);// OJO NO genera error
    }

    private static void extractInt(Object obj) {
        if(obj instanceof Double d)
            System.out.println(d.intValue());
        if(obj instanceof Integer i)
            System.out.println(i.intValue());
    }
}

record Counter() {
    static int count = 1;
}

class Test8 {
    public static void main(String[] args) {
        Consumer<Integer> add = i -> Counter.count += i;
        Consumer<Integer> print = System.out::println;
        add.andThen(print).accept(10); //Line n1
    }
}

class Base {
    static void print() { //Line n1
        System.out.println("BASE");
    }
}

class Derived extends Base {
    static void print() { //Line n2
        System.out.println("DERIVED");
    }
}

class Test9 {
    public static void main(String[] args) {
        //Base b = new Base();// OJO, esto da error
        Base b = null;
                Derived d = (Derived) b; //Line n3
        d.print(); //Line n4
    }
}

record Point(int x, int y, int z){}

class Test10 {
    public static void main(String[] args) {
        var p1 = new Point(1, 2, 3);
        var p2 = new Point(1, 2, 3);
        System.out.println((p1 == p2) + ":" + p1.equals(p2));//false:true
    }
}

class Test11 {
    public static void main(String[] args) {
        //var list = new ArrayList<String>(); ERROR
        var list = new CopyOnWriteArrayList<String>();
        list.add("Melon");
        list.add("Apple");
        list.add("Banana");
        list.add("Mango");
        for(String s : list) {
            list.removeIf(str -> str.startsWith("M"));
            System.out.println(s);
        }
    }
}
 class Test12 {
    public static void main(String[] args) {
        Optional<Integer> optional = Optional.ofNullable(null);
        System.out.println(optional);//retorna empty si se le pasa nullo
    }
}

class Counter2 {
    int count;
    Counter2(int count) {
        this.count = count;
    }

    public String toString() {
        return "Counter-" + count;
    }
}

class Test13 {
    public static void main(String[] args) {
        ArrayList<Counter2> original = new ArrayList<>(); //Line n1
        original.add(new Counter2(10)); //Line n2

        ArrayList<Counter2> cloned = (ArrayList<Counter2>) original.clone();
        cloned.get(0).count = 5;

        System.out.println(original);//SI CAMBIA SU VALOR A 5
    }
}

class Test14 {
    public static void main(String[] args) {
        //System.out.println(create(new char[]{'o', 'u', 't'}, String::new).length()); //Line n1
    }

    private static String create(char [] c, Function<char[], String> func) { //Line n2
        return func.apply(c);
    }

    private static String create(char [] c, Supplier<String> supplier) { //Line n3
        return supplier.get();
    }
}

class Test15 {
    public static void main(String[] args) {
        var stream = Stream.of("J", "A", "V", "A");
        var text = stream.parallel().
                reduce(String::concat)
                .get();
        System.out.println(text);
    }
}