package com.oracle.ocp.udemyQ.block2.exam4;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

interface Operator<T> {
    public abstract T operation(T t1, T t2);
    private void temp() {
        System.out.println("private method");
    }
}

public class Test {
    public static void main(String[] args) {
        Operator<String> opr1 = (s1, s2) -> s1 + s2;
        Operator<Integer> opr2 = (i1, i2) -> i1 + i2;
        opr1.operation("Think", "First");
        opr2.operation(10, 40);
    }
}

class Initializer {
    static int num;
    static int den;
    {
        num = 100;
        den = 10;
    }
    static {
        num = num/den;
    }
}
class Test2 {
    public static void main(String[] args) {
        System.out.println(Initializer.num);
    }
}

class Test3 {
    public static void main(String [] args) {
        LocalDate date = LocalDate.of(2018, 11, 4);
        LocalTime time = LocalTime.of(1, 59, 59);
        ZonedDateTime dt = ZonedDateTime.of(date, time, ZoneId.of("America/New_York"));
        dt = dt.plusSeconds(1);
        System.out.println(dt.getHour() + ":" + dt.getMinute() + ":" + dt.getSecond());
    }
}

class Test4<T> {
    T [] obj;

    public Test4() {
        //obj = new T[100]; No se puede hacer un new T
    }

    public T [] get() {
        return obj;
    }

    public static void main(String[] args) {
        Test4<String> test = new Test4<>();
        String [] arr = test.get();
        System.out.println(arr.length);
    }
}

class MyException extends RuntimeException {}

class YourException extends RuntimeException {}

 class Test5 {
    public static void main(String[] args) {
        try {
            throw new YourException();
        //} catch(MyException s1 | YourException e2){ //NO FUNCIONA
        } catch(MyException | YourException e2){
            System.out.println("Caught");
        }
    }
}

class Animal {
    protected void jump() {
        System.out.println("ANIMAL");
    }
}

class Cat extends Animal {
    public void jump(int a) {
        System.out.println("CAT");
    }
}

class Deer extends Animal {
    public void jump() {
        System.out.println("DEER");
    }
}

class Circus {
    public static void main(String[] args) {
        Animal cat = new Cat();
        Animal deer = new Deer();
        cat.jump();
        deer.jump();
    }
}

class Style {
    String pattern = "*";
}

class TestStyle {
    public static void main(String[] args) {
        var style = new Style(); //Line n1
        System.out.println(style.pattern.repeat(5).length()); //Line n2
    }
}

class Test6 {
    public static void main(String[] args) {
        Stream<Double> stream = Stream.generate(() -> Double.valueOf("1.0"))
                .limit(10);
        System.out.println(stream.filter(d -> d > 2)
                .allMatch(d -> d == 2));
    }
}

interface Writer {
    void print(Object obj);
}

class Test7 {
    public static void main(String[] args) {
        Writer obj = System.out::print;
        obj.print("BE HONEST");
    }
}

class Test8 {
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        try (var con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ocp", "root", "password");)
        {
            connection = con;
        }
        var stmt = connection.createStatement();
        stmt.executeUpdate("INSERT INTO EMPLOYEE VALUES(101, 'John', 'Smith', 12000)");
        stmt.close();
        connection.close();
    }
}

class Test9 {
    public static void main(String[] args) {
        char var = 10;
        switch(var) {
            case 10:
                System.out.println("TEN");
                break;
            default:
                System.out.println("DEFAULT");
        }
    }
}

class Test10 {
    private static void m(int x) {
        System.out.println("INT VERSION");
    }

    private static void m(char x) {
        System.out.println("CHAR VERSION");
    }

    public static void main(String [] args) {
        int i = '5';
        m(i);
        m('5');
    }
}

class Test11 {
    public static void main(String[] args) {
        List list = new ArrayList<String>();
        list.add(1);
        list.add("2");
        list.forEach(System.out::print);
    }
}

interface GetSetGo {
    int count = 1; //Line n1
}

 class Test12 {
    public static void main(String[] args) {
        GetSetGo [] arr = new GetSetGo[5]; //Line n2
        for(GetSetGo obj : arr) {
            //obj.count++; //Line n3
        }
        System.out.println(GetSetGo.count); //Line n4
    }
}

class Test13 {
    public static void main(String[] args) {
        var set1 = Set.of(new StringBuilder("GOD"),
                new StringBuilder("IS"), new StringBuilder("GREAT"));
        var set2 = Set.of(new StringBuilder("GOD"),
                new StringBuilder("IS"), new StringBuilder("GREAT"));
        System.out.println((set1 == set2) + ":" + set1.equals(set2));//false:false
    }
}

record Employee(String name, double salary) {
    @Override
    public String toString() {
        return "{" + name + ", " + salary + "}";
    }

    public static int salaryCompare(double d1, double d2) {
        return Double.valueOf(d2).compareTo(d1);
    }
}

class Test14 {
    public static void main(String[] args) {
        Stream<Employee> employees = Stream.of(
                new Employee("Aurora", 10000),
                new Employee("Naomi", 12000),
                new Employee("Hailey", 7000)
        );

        highestSalary(employees);
    }

    private static void highestSalary(Stream<Employee> emp) {
        System.out.println(emp.map(e -> e.salary())
                .max(Employee::salaryCompare));
    }
}




sealed interface Flyable permits Kite, Helicopter, Mosquito { //Line n1
    void fly();
}

record Kite() implements Flyable { //Line n2
    public void fly() {
        System.out.println("Kite is flying");
    }
}

non-sealed class Helicopter implements Flyable { //Line n3
    public void fly() {
        System.out.println("Helicopter is flying");
    }
}

final class Mosquito implements Flyable { //Line n4
    public void fly() {
        System.out.println("Mosquito is flying");
    }

}

 class Test15 {
    public static void main(String... args) {
        Flyable [] arr = new Flyable[] {new Kite(), new Helicopter(), new Mosquito()};
        for (var x : arr) {
            x.fly();
        }
    }
}