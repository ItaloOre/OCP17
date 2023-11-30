package com.oracle.ocp.udemyQ.block4.exam5;
import java.io.*;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
record Certification(String studId, String test, int marks) {
    public String toString() {
        return "{" + studId + ", " + test + ", " + marks + "}";
    }
}

public class Test {
    public static void main(String[] args) {
        Certification c1 = new Certification("S001", "OCA", 87);
        Certification c2 = new Certification("S002", "OCA", 82);
        Certification c3 = new Certification("S001", "OCP", 79);
        Certification c4 = new Certification("S002", "OCP", 89);
        Certification c5 = new Certification("S003", "OCA", 60);
        Certification c6 = new Certification("S004", "OCA", 88);

        Stream<Certification> stream = Stream.of(c1, c2, c3, c4, c5, c6);
        Map<String, List<Certification>> map =
                stream.collect(Collectors.groupingBy(Certification::test));
        System.out.println(map.get("OCP"));
    }
}

 class Test2 {
    public static void main(String[] args) throws IOException {
        try (var fis = new FileInputStream("F:\\orig.png");
             var fos = new FileOutputStream("F:\\copy.png")) {
            int res;
            var arr = new byte[500000]; //Line 10
            while((res = fis.read(arr)) != -1){ //Line 11
                fos.write(arr); //Line 12
            }
        }
    }
}

class Test3 {
    public static void main(String[] args) throws IOException {
        System.setOut(new PrintStream("C:\\err.log"));
        try {
            System.out.println("ONE");
            System.out.println(1 / 0);
        } catch (ArithmeticException e) {
            System.err.println("TWO");
        }
    }
}

class Test4 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        var es = Executors.newSingleThreadExecutor();
        //Future<String> f = es.execute(() -> "HELLO");// ERROR
        //System.out.println(f.get());
        es.shutdown();
    }
}

class Shape {
    int side = 0; //Line n1

    int getSide() { //Line n2
        return side;
    }
}

class Square extends Shape {
    private int side = 4; //Line n3

    protected int getSide() { //Line n4
        return side;
    }
}

 class Test5 {
    public static void main(String[] args) {
        Shape s = new Square();
        System.out.println(s.side + ":" + s.getSide());
    }
}

class Report {
    public String generateReport() {
        return "CSV";
    }

    public Object generateReport2() {//OJO, NO PUEDE TENER EL MISMO NOMBRE
        return "XLSX";
    }
}

class Test6 {
    public static void main(String[] args) {
        Report rep = new Report();
        String csv = rep.generateReport();
        Object xlsx = rep.generateReport2();
        System.out.println(String.join(":", csv, (String)xlsx));
    }
}

class SortSwiftCode {
    public static void main(String[] args) {
        List<String> swiftCodes = Arrays.asList(
                "ICICINDD016", "ICICINBBRT4",
                "BOTKINDD075", "BARBINBB011",
                "SBBJINDD062", "ABNATHBK865",
                "BKCHTHBK012");

        Comparator<String> countryLocationBank =
                Comparator
                        .comparing(
                                SortSwiftCode::extractCountry)
                        .thenComparing(
                                SortSwiftCode::extractLocation)
                        .thenComparing(
                                SortSwiftCode::extractBank);

        Collections.sort(swiftCodes, countryLocationBank);
        printCodes(swiftCodes);

    }

    private static String extractCountry(
            String swiftCode) {
        return swiftCode.substring(4, 6);
    }

    private static String extractLocation(
            String swiftCode) {
        return swiftCode.substring(6, 8);
    }

    private static String extractBank(
            String swiftCode) {
        return swiftCode.substring(0, 4);
    }

    private static void printCodes(List<String> list) {
        for (String str : list) {
            System.out.println(str);
        }
    }
}

class Test7 {
    public static void main(String[] args) {
        var list = List.of("MANGO", "BANANA", "ORANGE", "PEARS", "GRAPES");
        Predicate<String> predicate = str -> {
            int ctr = 1;
            boolean result = str.indexOf("N") != -1;
            System.out.print(ctr++ + ".");
            return result;
        };

        list.stream()
                .filter(predicate)
                .sorted().forEach(System.out::println);
    }
}

class Test8 {
    public static void main(String[] args) {
        int day = '3';
        switch(day) {
            case '3':
                System.out.println("BUY 2 GET 1 FREE");
                break;
            default:
                System.out.println("SORRY!!! NO SALE");
        }
    }
}

abstract class Greetings {
    abstract void greet();
}

 class Test9 {
    public static void main(String[] args) {
        var obj = new Greetings() {
            @Override public void greet() {
                System.out.println("BELIEVE IN YOURSELF");
            }
        };
        obj.greet();
    }
}

abstract class Parent {
    public abstract void find() throws IOException;
}

class Child extends Parent {
    @Override
    public void find() throws IOException {
        throw new FileNotFoundException();
    }
}

class Test10 {
    public static void main(String[] args) {
        Parent p = new Child();
        try {
            p.find();
        } catch (FileNotFoundException e) {
            System.out.print("X");
        } catch (IOException e) {
            System.out.print("Y");
        } finally {
            System.out.print("Z");
        }
    }
}

class Test11 {
    public static void main(String[] args) {
        try(Scanner scan = new Scanner(System.in)) {
            String s = scan.nextLine();
            System.out.println(s);
            //scan = null; ES FINAL
        }
    }
}

interface Operation {
    int operate(int x, int y);
}

class Test12 {
    public static void main(String[] args) {
       //int x = 10; DA ERROR
        //int y = 20; DA ERROR
        Operation o1 = (x, y) -> x * y;
        System.out.println(o1.operate(5, 10));
    }
}

 class Test13 {
    public static void main(String[] args) {
        var stream = Stream.of(
                new StringBuilder("S"),
                new StringBuffer("L"),
                new String("A"),
                "S",
                new StringBuilder("H").toString());

        var result = stream.<String>mapMulti((cs, con) -> {
            if(cs instanceof String s)
                con.accept(s);
        }).collect(Collectors.joining());

        System.out.println(result);
    }
}

class Test14 {
    public static void main(String[] args) {
        List<Integer> list = Collections.synchronizedList(new ArrayList<>());
        IntStream stream = IntStream.rangeClosed(1, 7);
        stream.parallel().map(x -> {
            list.add(x); //Line 13
            return x;
        }).forEachOrdered(System.out::print); //Line 15
        System.out.println();
        list.forEach(System.out::print); //Line 17
    }
}

class Test15 {
    public static void main(String[] args) {
        var path = Paths.get("F:\\A\\B\\C\\Book.java");
        /*INSERT*/
        //LOS CCUATRO RETORNAN LO MISMO
        for(var p : path) {
            System.out.println(p);
        }
        for(var i = 0; i < path.getNameCount(); i++) {
            System.out.println(path.getName(i));
        }
        var iterator = path.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        path.forEach(System.out::println);
    }
}


interface Buyable {
    int salePercentage = 85;

    public static String salePercentage() {
        return salePercentage + "%";
    }
}

//Book.java
class Book implements Buyable {}


//Test.java

class Test16 {
    public static void main(String[] args) {
        Buyable [] arr = new Buyable[2];
        for(Buyable b : arr) {
            System.out.println(b.salePercentage); //Line n1
            //System.out.println(b.salePercentage()); //Line n2 ERROR
        }

        Book [] books = new Book[2];
        for(Book b : books) {
            System.out.println(b.salePercentage); //Line n3
            //System.out.println(b.salePercentage()); //Line n4 ERROR
        }
    }
}

 class Test17 {
    public static void main(String[] args) {
        String[] names = { "Smith", "Brown", "Thomas", "Taylor", "Jones" };
        List<String> list = new ArrayList<>();
        for (int x = 0; x < names.length; x++) {
            list.add(names[x]);
            switch (x) {
                case 2:
                    continue;
            }
            break;
        }
        System.out.println(list.size());
    }
}

class Super {
    void Super() {
        System.out.print("KEEP_");
    }
}

class Base extends Super {
    Base() {
        Super();
        System.out.print("GOING_");
    }
}

 class Test18{
    public static void main(String[] args) {
        new Base();
    }
}