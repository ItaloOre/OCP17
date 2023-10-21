package com.oracle.ocp.collectionsAndGenerics;

import java.util.ArrayList;
import java.util.List;

public class Genericos {

    public static void main(String[] args) {
        List<?> x1 = new ArrayList<>();//Tipo List
        var x2 = new ArrayList<>();//Tipo ArrayList

        List<Object> objectsList = new ArrayList<>();
        objectsList.add(x1);
        objectsList.add(x2);

        x1 = objectsList;//ok
        //x2 = objectsList; Estas tratando de asignar un list a una clase

        //ArrayList<Number> list = new ArrayList<Integer()>; NO PODEMOS Usar Numeric y number en genericos
        ArrayList<? extends Number> list = new ArrayList<Integer>();//valido


        //List<Bird>
        //List<Sparrow>
        List<? extends Bird> birds = new ArrayList<Bird>();
        //birds.add(new Sparrow()); AMBIGUO
        //birds.add(new Bird()); AMBIGUO

    }

    public static long total(List<? extends Number> list){
        long count = 0L;
        for(Number number: list){
            count += number.longValue();
        }
        return count;
    }
    //public static long total(List list){ //ERASURE
    //long count = 0;
    //for (Object number: list)
    // Number number = (Number) obj;
    //count += number.longValue();
    //}
    //return count;
    //}
    static class Sparrow extends Bird {}
    static class Bird{}
}



