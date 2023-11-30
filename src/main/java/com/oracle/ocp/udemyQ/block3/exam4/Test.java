package com.oracle.ocp.udemyQ.block3.exam4;
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
    public static void main(String [] args) {
        Locale.setDefault(new Locale("en", "US"));
        var date = LocalDate.parse("2022-09-10");
        System.out.println(date.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy")));//El mes en minuscula
    }
}

class Test2 {
    public static void main(String[] args) {
        List<? extends String> list = new ArrayList<>(Arrays.asList("A", "E", "I", "O")); //Line n1
        //list.add("U"); //Line n2 Lista desconocida, no hay garantias
        list.forEach(System.out::print);
    }
}

class Test3 {
    enum JobStatus {
        SUCCESS, FAIL; //Line n1
    }

    enum TestResult {
        PASS, FAIL; //Line n2
    }

    public static void main(String[] args) {
        JobStatus js = JobStatus.FAIL;
        TestResult tr = TestResult.FAIL;

        System.out.println(js.equals(tr)); //Line n3
        //System.out.println(js == tr); //Line n4 ESTO ES ILEGAN EN CONSTANTES
    }
}
 class Test4 {
    public static void main(String[] args) throws IOException {
        try(var br = new BufferedReader(new InputStreamReader(System.in));) {
            System.out.print("Enter any number between 1 and 10: ");
            var num = br.read();
            System.out.println(num);//OJO, NO IMPRIME EL NUMERO
        }
    }
}

class TestException extends Exception {
    public TestException() {
        super();
    }

    public TestException(String s) {
        super(s);
    }
}
class Test5 {
    public void m1() throws Exception {
        throw new TestException();
    }
}

record Point(int x, int y) {
    @Override
    public String toString() {
        return "Point(" + x + ", " + y + ")";
    }
}

 class Test6 {
    public static void main(String [] args) {
        List<Point> points = new ArrayList<>();
        points.add(new Point(4, 5));
        points.add(new Point(6, 7));
        points.add(new Point(2, 2));

        Collections.sort(points, new Comparator<Point>() {
            //TIENE QUE TENER compere
            @Override
            public int compare(Point o1, Point o2) {
                return o1.x() - o2.x();
            }
            //ESTO NO FUNCIONA
            public int compareTo(Point o1, Point o2) {
                return o1.x() - o2.x();
            }
        });

        System.out.println(points);
    }
}

class M { }
class N extends M { }
class O extends N { }
class P extends O { }

class Test7 {
    public static void main(String args []) {
        M obj = new O();
        if(obj instanceof M)
            System.out.print("M");
        if(obj instanceof N)
            System.out.print("N");
        if(obj instanceof O)
            System.out.print("O");
        if(obj instanceof P)
            System.out.print("P");
    }
}

 class Test8 {
    public static void main(String[] args) {
        OptionalLong optional = OptionalLong.empty();
        System.out.println(optional.isPresent() + " : " + optional.getAsLong());
    }
}

 class Test9 {
    public static void main(String[] args) {
        final String password = "Oracle";
        UnaryOperator<String> opr1 = s -> s.replace('a', '@'); //Line n1
        UnaryOperator<String> opr2 = s -> password.concat(s); //Line n2
        System.out.println("Password: " + opr1.apply(opr2.apply("!"))); //Line n3
    }
}

class Test10 {
    public static void main(String[] args) {
        do {
            System.out.print("SLOW-");
        } while (false);

        System.out.println("DOWN");
    }
}

class Test11 {
    public static void main(String[] args) {
        Set<Character> set = Set.of('A', 'F', 'I', 'O', 'U'); //Line n1
        //set.remove(Character.valueOf('F')); // Line n2 NO SE PUEDE REMOVER
        System.out.println(set.size());
    }
}

class Test12 {
    public static void main(String[] args) {
        var map = new LinkedHashMap<Integer, String>();
        map.put(1,  null);
        map.put(2,  "TWO");
        map.put(3, "THREE");
        map.merge(1, "ONE", String::concat); //Line n1
        map.merge(2, "2", (s1, s2) -> s2 + ":" + s1); //Line n2
        map.merge(3, "3", (s1, s2) -> null); //Line n3
        System.out.println(map);
    }
}

class Test13 {
    public static void main(String [] args) {
        var val = 9;
        System.out.println(val += 10 - -val-- - --val);
    }
}

class Test14 {
    public static void main(String[] args) {
        boolean flag = false;
        do {
            if(flag = !flag) { //Line n1
                System.out.print(1); //Line n2
                continue; //Line n3
            }
            System.out.print(2); //Line n4
        } while(flag); //Line n5
    }
}

class Test15 {
    private static void getReport() throws SQLException {
        try {
            throw new SQLException();
        } catch (Exception e) {
            throw null; //Line n1
        }
    }

    public static void main(String[] args) {
        try {
            getReport(); //Line n2
        } catch(SQLException e) {
            System.out.println("REPORT ERROR");
        }
    }
}

class Message {
    public void printMessage() {
        System.out.println("Hello!");
    }
}
 class Test16 {
    public static void main(String[] args) {
        Message msg = new Message() {}; //Line n1
        msg.printMessage(); //Line n2
    }
}


class MyResourceBundle extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        Object [][] arr = {{"surprise", "SURPRISE!"}};
        return arr;
    }
}

class MyResourceBundle_en_CA extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        Object [][] arr = {{"surprise", 12.64}};
        return arr;
    }
}

//3. Test.java

class Test17 {
    public static void main(String[] args) {
        Locale.setDefault(new Locale("fr", "IT"));
        var loc = new Locale("en", "US");
        var rb = ResourceBundle.getBundle("com.udayankhattry.ocp.MyResourceBundle", loc);
        System.out.println(rb.getObject("surprise"));
    }
}

class Test18 {
    public static void main(String[] args) {
        var list = new ArrayList<>();
        list.add(null);
        list.add(null);
        list.add(null);
        System.out.println(list.remove(0) + ":" + list.remove(null));
    }
}

 class Test19 {
    public static void main(String[] args) {
        List<String> colors = new ArrayList<>();
        colors.add("RED");
        colors.add("GREEN");
        colors.add("BLUE");
        Iterator<String> iter = colors.iterator();
        while(iter.hasNext()) {
            //iter.remove();
            iter.next();
        }
        System.out.println(colors.size());
    }
}

sealed interface Payable { }

/*INSERT*/
non-sealed interface OnlinePyament extends Payable {
    default void pay() {
        System.out.println("ONLINE-PAYMENT");
    }
}

class Test20 {
    public static void main(String [] args) {
        new OnlinePyament(){}.pay(); //Line n1
    }
}

class Test21 {
    static Optional<Integer> search1(List<Integer> list, int num) {
        return list.stream()
                .filter(i -> i.equals(num))
                .findFirst();
    }

    static Optional<Integer> search2(List<Integer> list) {
        return list.stream()
                .filter(i -> i % 10 == 0)
                .findFirst();
    }

    public static void main(String[] args) {
        var numbers = List.of(11, 22, 7, 23, 82, 9);
        System.out.println(search1(numbers, 43)
                .or(() -> search2(numbers))
                .stream()
                .count());
    }
}

class Test22 {
    public static void main(String[] args) {
        var list1 = List.of(List.of('A', 'R'), List.of('O', 'S'));
        var list2 = List.of(List.of('N', 'A'), List.of('M', 'O'));
        list1.parallelStream()
                .flatMap(i -> i.stream())
                .findFirst()
                .stream()
                .forEach(System.out::print);
        list2.parallelStream()
                .flatMap(i -> i.stream())
                .findFirst()
                .stream()
                .forEach(System.out::print);
    }
}

class Test23 {
    public static void main(String[] args) {
        int[] arr1 = { 10, 100, 1000 }; //Line n1
        char[] arr2 = { 'x', 'y', 'z' }; //Line n2
        //arr1 = arr2; // Line n3NO SE PUEDE EN ARRAY
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " "); //Line n4
        }
    }
}

class Counter {
    int count = 0;
}

interface SetCounter {
    void set(Counter ctr);
}

class Test24 {
    public static void main(String[] args) {
        Counter ctr = new Counter(); //Line n1
        SetCounter obj = x -> x.count = 20; //Line n2
        ctr.count = 100; //Line n3
        obj.set(ctr); //Line n4
        System.out.println(ctr.count); //Line n5
    }
}

class Test25 {
    public static void main(String [] args) {
        LocalDate date1 = LocalDate.of(2019, 1, 1);
        Duration d = Duration.ofDays(1);
        System.out.println(date1.plus(d));
    }
}


class Test26 {
    public static void main(String[] args) {
        var stream = Stream.of(9, 2, 1, 8, 9, 2, 9);
        System.out.println(stream.distinct()
                .map(i -> "" + i)
                .collect(Collectors.joining())
        );
    }
}

class Square {
    int length;
    Square sq;

    Square(int length) {
        this.length = length;
    }

    void setInner(Square sq) {
        this.sq = sq;
    }

    int getLength() {
        return this.length;
    }
}

 class TestSquare {
    public static void main(String[] args) {
        Square sq1 = new Square(10); //Line n1
        Square sq2 = new Square(5); //Line n2
        sq1.setInner(sq2); //Line n3
        System.out.println(sq1.sq.length); //Line n4
    }
}

class Test27 {
    public void print(final String message) {
        interface Printable { //Line n1
            public void print();
        }

        record Printer() implements Printable { //Line n2
            public void print() {
                //System.out.print(message.toUpperCase()); //Line n3
            }
        }
    }
    public static void main(String[] args) {
        new Test27().print("Life won't wait");
    }
}
