package com.oracle.ocp.udemyQ.block4.exam3;
import java.io.*;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Test {
    public static void main(String[] args) throws IOException {
        //Importante la exepcion es necesaria para real path pero no para basolute path
        var file = Paths.get("F:\\A\\.\\B\\C\\D\\..\\Book.java");
        System.out.println(file.toRealPath());
    }
}

record Point(int x, int y) {
    @Override
    public String toString() {
        return "Point(" + x + ", " + y + ")";
    }

    boolean filter() {
        return this.x == this.y;
    }
}

 class Test2 {
    public static void main(String[] args) {
        var list = List.of(new Point(0, 0),
                new Point(1, 2), new Point(-1, -1));
        list.stream()
                .filter(Point::filter)
                .forEach(System.out::println);
    }
}

class Base {
    //OJO, EN LOS CONSTRUCTORES, REVISA EL ORDEN AL INVERSO DE LA EXCEPCION
    Base() throws FileNotFoundException {
        System.out.print(1);
    }
}

class Derived extends Base {
    Derived() throws IOException  {
        System.out.print(2);
    }
}

class Test3 {
    public static void main(String[] args) throws Exception {
        new Derived();
    }
}

class Test4 {
    @SafeVarargs Test4(String... strings) {} //Line n1

    //@SafeVarargs public Test5(String msg) {} //Line n2 @SafeVarargs is not allowed on methods with fixed arity

    //@SafeVarargs public void greet(String... msg) {} //Line n3 @SafeVarargs is not allowed on non-final instance methods

    @SafeVarargs private void print(String... strings) {} //Line n4

    @SafeVarargs final Integer sum(Integer... integers) {return null;} //Line n5
}

class Resource implements AutoCloseable {
    public void close() {
        System.out.println("CLOSE");
    }
}

 class Test5 {
    public static void main(String[] args) {
        try(Resource r = null) {
            //r = new Resource(); Error, el try inicia los valores en FINAL
            System.out.println("HELLO");
        }
    }
}


class Parent {
    public void produce() {
        record Child1(String name) {} //Line n1
        enum Child2 {ZERO, ONE} //Line n2
        interface Child3 { public void play(); } //Line n3
        class Child4 implements Child3 {public void play(){} } //Line n4
        System.out.println("DONE");
    }
}
 class Test6 {
    public static void main(String[] args) {
        new Parent().produce();
    }
}

interface Leveller {
    int level();
}

class Test7 {
    int i = 100; //Line n1

    Leveller level = () -> {
        int i = 200; //Line n2
        return this.i; //Line n3
    };

    public static void main(String[] args) {
        System.out.println(new Test7().level.level()); //Line n4
    }
}

interface Creator<T> {
    T create(String type);
}

enum AnimalType {
    MAMMAL, BIRD, REPTILE;
}

abstract class Animal {
    private AnimalType type;

    public Animal(AnimalType type) {
        this.type = type;
    }

    public AnimalType getType() {
        return type;
    }
}

class Dog extends Animal {
    public Dog(String type) {
        super(AnimalType.valueOf(type.toUpperCase())); //Line n1
    }
}

class Test8 {
    public static void main(String[] args) {
        Creator<Dog> obj = Dog::new; //Line n2
        var d = obj.create("mammal"); //Line n3
        System.out.println(d.getType()); //Line n4
    }
}

class MyThread implements Runnable {
    private String str;

    MyThread(String str) {
        this.str = str;
    }

    public void run() {
        System.out.println(str.toUpperCase());
    }
}

class Test9 {
    public static void main(String[] args) throws ExecutionException, InterruptedException{
        var es = Executors.newSingleThreadExecutor();
        var thread = new MyThread("ocp");
        var future = es.submit(thread);
        var tmp = (Integer) future.get(); //Line 22
        System.out.println(tmp);
        es.shutdown();
    }
}

class Test10 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(15);
        list.add(25);
        list.add(15);
        list.add(25);
        list.remove(Integer.valueOf(15));

        System.out.println(list);
    }
}

class Test11 {
    public static void main(String[] args) {
        final int i1 = 1;
        final Integer i2 = 1;
        final String s1 = ":ONE";

        String str1 = i1 + s1;
        String str2 = i2 + s1;

        System.out.println(str1 == "1:ONE");
        System.out.println(str2 == "1:ONE");
    }
}

 class Test12 {
    public static void main(String[] args) {
        //<Integer> set = Set.of(10, null, 20, 40, null); //Line n1 Cannot invoke "Object.hashCode()" because "pe" is null
        //System.out.println(set.size());
    }
}

class Animal2 {}

class Dog2 extends Animal2 {}

class Cat2 extends Animal2 {}

class A<T> {
    T t;
    void set(T t) {
        this.t = t;
    }

    T get() {
        return t;
    }
}

 class Test13 {
    public static <T> void print1(A<? extends Animal2> obj) {
//        obj.set(new Dog2()); //Line n1 ERROR
//        System.out.println(obj.get().getClass());
    }

    public static <T> void print2(A<? super Dog2> obj) {
        obj.set(new Dog2()); //Line n2
        System.out.println(obj.get().getClass());
    }

    public static void main(String[] args) {
        A<Dog2> obj = new A<>();
        print1(obj); //Line n3
        print2(obj); //Line n4
    }
}

class Test14 {
    public static void main(String[] args) {
        P p = new R(); //Line n1
        System.out.println(p.compute("Go")); //Line n2
    }
}

class P {
    String compute(String str) {
        return str.repeat(3);
    }
}

class Q extends P {
    String compute(String str) {
        return super.compute(str.toLowerCase());
    }
}

class R extends Q {
    String compute(String str) {
        return super.compute(str.replace('o', 'O'));
        //2nd argument is uppercase O
    }
}

class Test15 {
    private static void m() throws SQLException {
        try {
            throw new SQLException();
        } catch (Exception e) {
            throw e;
        }
    }

    public static void main(String[] args) {
        try {
            m();
        } catch(SQLException e) {
            System.out.println("CAUGHT SUCCESSFULLY");
        }
    }
}

class Test16 {
    public static void main(String [] args) {
        var text = """
            *
            *
            *
            *
            *
        """;
        System.out.println(text.indent(-100)); //Line n1

    }
}

class Test17 {
    public static void main(String[] args) {
        boolean[] arr1 = { true, false, true, false };
        boolean[] arr2 = { true, true, true, false };

        if (!Arrays.equals(arr1, arr2)) {
            System.out.println(Arrays.compare(arr1, arr2));
        } else {
            System.out.println(Arrays.mismatch(arr1, arr2));
        }
    }
}


class Test18 {
    public static void main(String[] args) {
        Consumer<Integer> printer = i -> System.out.println("$" + i + ".00");
        BiConsumer<List<Integer>, Consumer<Integer>> obj = (list, cons) -> list.forEach(cons);
        obj.accept(List.of(10, 15, 20), printer);
    }
}