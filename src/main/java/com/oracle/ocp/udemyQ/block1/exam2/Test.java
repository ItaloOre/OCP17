package com.oracle.ocp.udemyQ.block1.exam2;

import java.io.*;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Function;
import java.util.function.LongFunction;
import java.util.function.LongUnaryOperator;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

record CryptoCurrency(String name, int unit) {}

public class Test {
    public static void main(String[] args) {
        Function<CryptoCurrency, Integer> extractor = curr -> curr.unit();
        UnaryOperator<Integer> operator = i -> i % 100;
        int val = Stream.of(new CryptoCurrency("DOGE", 8921),
                        new CryptoCurrency("ETH", 99),
                        new CryptoCurrency("LTC", 17689))
                .map(extractor.andThen(operator))
                .reduce(0, (a, b) -> a + b);
        System.out.println(val);
    }
}

class Test2 {
    public static void main(String[] args) {
        try {
            try {
                System.out.println(args[1]); //Line n1
            } catch(RuntimeException e) {
                System.out.print("INHALE-"); //Line n2
                throw e; //Line n3
            } finally {
                System.out.print("EXHALE-"); //Line n4
            }
        } catch(RuntimeException e) {
            System.out.print("INHALE-"); //Line n5
        } finally {
            System.out.print("EXHALE"); //Line n6
        }
    }
}


interface Parent {
    default void earn() {
        System.out.println("Earning for the family");
    }

    static void plan() {
        planRetirement();
        planChildrenEducation();
    }

    private static void planChildrenEducation() {
        //valid codes
    }

    private static void planRetirement() {
        //valid codes
    }

    String toString();
}

interface Child extends Parent {
    void play();
}

class Test3 {
    public static void main(String[] args) {
        Child child = () -> System.out.println("PLAYING CRICKET..."); //Line n1
        child.play(); //Line n2
    }
}

class Test4 {
    public static void main(String[] args) {
        int i = 0;
        String res = null; //OJO, EN ESTE CASO EL JOIN MEZCLA LOS CHAR DE UNA
        for(String [] s = {"A", "B", "C", "D"};;res = String.join(".", s)) { //Line n1
            if(i++ == 0)
                continue;
            else
                break;
        }
        System.out.println(res); //Line n2
    }
}

record Student(String name, int age) {
    public String toString() {
        return "Student (" + name + ", " + age + ")";
    }

    public static int compareByAge(Student s1, Student s2) {
        return s1.age - s2.age;
    }
}

class Test5 {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("john", 25),
                new Student("lucy", 21),
                new Student("ivy", 23));
        Collections.sort(students, Student::compareByAge);
        System.out.println(students);
    }
}

class Test6 { //OJO, El OPTIONAL NO IMPLEMENTA SEREALIZABLE
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        var optional = Optional.of(List.of("O", "N"));
        try (var oos = new ObjectOutputStream(new FileOutputStream(("F:\\data.ser")));
             var ois = new ObjectInputStream(new FileInputStream("F:\\data.ser")))
        {
            oos.writeObject(optional);

            var object = (Optional<?>)ois.readObject();
            System.out.println(object.get());
        }
    }
}


class Test7 {
    public static void main(String[] args) {
        record Color(int r, int g, int b){
            public Color {
                if(r < 0 || r > 255)
                    throw new IllegalArgumentException("r value is not between 0 and 255");//HIJO DE RUNTIME
                if(g < 0 || g > 255)
                    throw new IllegalArgumentException("g value is not between 0 and 255");
                if(b < 0 || b > 255)
                    throw new IllegalArgumentException("b value is not between 0 and 255");
            }
        }

        var c1 = new Color(20, 100, 255);
        var c2 = new Color(100, 200, 0);
        System.out.println(new Color(c1.r() + c2.r(), c1.g() + c2.g(), c1.b() + c2.b()));
    }
}
//JUGAR ON los static
class Outer {
    Outer() {
        System.out.print(2);
    }
    /*INSERT 1*/
    static{
        System.out.print(1);
    }

    class Inner {
        Inner() {
            System.out.print(4);
        }
        /*INSERT 2*/
        {
            System.out.print(3);
        }
    }
}

class Test8 {
    public static void main(String[] args) {
        new Outer().new Inner();
    }
}

class Test9 {
    public static void main(String[] args) {
        var path = Paths.get("C:", "..", ".", "..").normalize();
        System.out.println(path.getNameCount() + ":" + path.getName(0).toString().length());
    }
}

abstract class Animal {
    abstract void jump() throws RuntimeException;
}

class Deer extends Animal {
    void jump() { //Line n1
        System.out.println("DEER JUMPS");
    }

    void jump(int i) {
        System.out.println("DEER JUMPS TO " + i + " FEET");
    }
}

class Test10 {
    public static void main(String[] args) {
        Animal animal = new Deer();
        ((Deer)animal).jump(); //Line n2
        ((Deer)animal).jump(5); //Line n3
    }
}

class Test11 { //Deque no puede tener nulos
    public static void main(String[] args) throws Exception {
        List<String> list = Arrays.asList("oca", null, "ocp", "java", "null"); //Line n1
        Deque<String> deque = new ArrayDeque<String>(list); //Line n2
        System.out.println(deque.size()); //Line n3
    }
}

 class Test12 {
    public static void main(String[] args) {
        long seed = 10;
        var stream = Stream.iterate(seed, i -> i <= 12, i -> i + 2); //Line n1
        LongFunction<LongUnaryOperator> func = m -> n -> n / m; //Line n2
        stream.mapToLong(i -> i).map(func.apply(2)).forEach(System.out::println); //Line n3
    }
}

class Test13 {
    public static void main(String [] args) throws InterruptedException, ExecutionException, TimeoutException {
        var es = Executors.newSingleThreadExecutor();
        var f1 = es.submit(() -> {});
        var f2 = es.submit(() -> 2);
        var f3 = es.submit(() -> {}, 3);
        System.out.println(f1.get(1, TimeUnit.HOURS));
        System.out.println(f2.get(2, TimeUnit.HOURS));
        System.out.println(f3.get(3, TimeUnit.HOURS));
        es.shutdown();
    }
}

interface Workable {
    void work();
}

abstract class Work implements Workable {
public void work() {
    System.out.println("COMO ES POSIBLE ESTE SUCESO");
} //Line n1
    abstract void work2();

}
class Work2 extends Work {
    @Override
    void work2() {}
}