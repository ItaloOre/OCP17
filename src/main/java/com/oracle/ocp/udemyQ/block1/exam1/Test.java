package com.oracle.ocp.udemyQ.block1.exam1;

import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Caller implements Callable<Void> {
    String str;

    public Caller(String s) {
        this.str = s;
    }

    public Void call() throws Exception {//OJO CON EL Void en mayuscula, el return no es relevante.
        System.out.println(str.toUpperCase());
        return null;
    }
}

public class Test {
    public static void main(String[] args)
            throws InterruptedException, ExecutionException {
        var es = Executors.newSingleThreadExecutor();
        var future = es.submit(new Caller("Call"));
        System.out.println(future.get());
    }
}



class Test2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(
                Arrays.asList("Z", "Y", "X"));
        var a = list.stream()
                .sorted()
                .findFirst()
                .get();
        System.out.println(a);
        System.out.println(list.get(2));
    }
}

class Test3 {
    public static void main(String[] args) {
        try {
            check();
        } catch(RuntimeException e) {
            System.out.println(e.getClass()
                    .getName()); //Line n1
        }
    }

    private static void check() {//MUCHO OJO CON ESTA PREGUNTA
        try {
            RuntimeException re =
                    new RuntimeException(); //Line n2
            throw re; //Line n3
        } catch(RuntimeException e) {
            System.out.println(1);
            //OJO, RECUERDA QUE UN  RuntimeException e NO SE PUEDE CASTEAR ASI
            ArithmeticException ex =
                    (ArithmeticException)e; //Line n4
            System.out.println(2);
            throw ex;
        }
//    } catch (ArithmeticException e) {
//        System.out.println(1);
//        RuntimeException ex = (RuntimeException)e; // Conversión válida de subclase a superclase
//        System.out.println(2);
//        throw ex;
//    }
    }
}

class Test4 {
    public static void main(String [] args) {
        LocalDate startDate = LocalDate
                .of(2023, Month.MARCH, 1);
        LocalDate endDate = LocalDate
                .of(2023, Month.MARCH, 11);

        System.out.println(
                Period.between(endDate, startDate));
    }
}

interface ITester {
    void test();
}

 class Test5 {
    public static void main(String[] args) {
        ITester obj = () -> System.out.println("KEEP CALM");
    }
}


 class Test6 {
    public static void main(String[] args) {
        Stream<Double> stream =
                Arrays.asList(1.8, 2.2, 3.5).stream();

        /*INSERT*/
        //System.out.println(stream.reduce(0.0,Double::sum));
        //System.out.println(stream.reduce(0.0,(d1,d2) -> d1 + d2));
    }
}


class Test7 {
    public static void main(String[] args) throws IOException {
        var console = System.console();
        console.writer().printf(
                "Enter a number between 1 and 7: "); //Line n1
        var num = Integer.parseInt(
                "" + (char)console.reader().read()); //Line n2  OJO, read solo lea una letra, readLine lee la linea
        var flag = IntStream.rangeClosed(1, 7)//OJO ES ES INCLUSIVC
                .anyMatch(i -> i == num);
        if(flag)
            console.printf("*".repeat(num)); //Line n3
        else
            console.writer().format("INVALID"); //Line n4
    }
}


enum Color {
    RED, GREEN, BLUE;
}

record Rope(int length, Color color) {}

record Group(Map<Color, List<Rope>> map1,
             Map<Integer, List<Rope>> map2) {}

class Test8 {
    public static void main(String[] args) {
        var ropes = Stream.of(
                new Rope(100, Color.RED),
                new Rope(200, Color.BLUE),
                new Rope(200, Color.RED),
                new Rope(300, Color.RED),
                new Rope(100, Color.BLUE));

        var result = ropes.collect(
                Collectors.teeing(
                        Collectors.groupingBy(Rope::color),
                        Collectors.groupingBy(Rope::length),
                        Group::new
                ));

        System.out.println(result.map1().size() +
                result.map2().size());
    }
}


class Test9 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("P");
        list.add("O");
        list.add("T");

        List<String> subList = list.subList(1, 2); //Line n1  subList(int fromIndex,int toIndex)

        subList.set(0, "E"); //Line n2
        System.out.println(String.join("", list));
    }
}

class Test10 {
    public static void main(String [] args)  {
        var df1 = new DecimalFormat("###,##,#");//OJO Es 1,2,3,1
        var df2 = new DecimalFormat("##,###,#");//OJO Es 1,2,3,1
        System.out.println(df1.format(1231));
        System.out.println(df2.format(1231));
        System.out.println(df1.format(1231)
                .equals(df2.format(1231)));
    }
}

class MyResource implements AutoCloseable {
    @Override
    public void close() {
        System.out.println("Closing");
    }
}

 class Test11 {
    public static void main(String[] args) throws Exception { // El throws Exception es fundamental y determinante
        try(AutoCloseable resource = new MyResource()) {

        }
    }
}

class M {
    private int num1 = 100;
    class N {
        private int num2 = 200;
    }

    public static void main(String[] args) {
        M outer = new M();
        M.N inner = outer.new N();
        System.out.println(outer.num1 + inner.num2);//300
    }
}
