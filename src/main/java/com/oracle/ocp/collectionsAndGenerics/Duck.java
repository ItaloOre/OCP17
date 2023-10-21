package com.oracle.ocp.collectionsAndGenerics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Duck implements Comparable<Duck>{

    private String name;

    private int weight;

    public Duck(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Duck{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Duck o) {
        return name.compareTo(o.name);
    }

    public static void main(String[] args) {
        var lista = new ArrayList<Duck>();
        lista.add(new Duck("Puddles",900));
        lista.add(new Duck("Quacks",120));
        Collections.sort(lista);
        System.out.println(lista);

        var lista2 = new ArrayList<Avatar>();
        lista2.add(new Avatar("Amadeo"));
        lista2.add(new Avatar("Katerine"));

        //Collections.sort(lista2); NO IMPLEMENTA COMPARABLE, SALE ERROR.


//        @Override
//        public int compare(Duck d1, Duck d2) {
//            return d1.getWeight() - d2.getWeight();
//        }

        //VERSION CON LAMBDAS
        Comparator<Duck> byWeght = (d1, d2) -> d1.getWeight() - d2.getWeight();

        Collections.sort(lista,byWeght);
        System.out.println(lista);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
