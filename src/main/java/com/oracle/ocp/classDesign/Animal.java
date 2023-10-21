package com.oracle.ocp.classDesign;

public class Animal {
    static {
        System.out.println("A");
    }
    public Animal(){
        System.out.println("D");
    }
}

class Hipo extends  Animal {

    public Hipo(){
        System.out.println("E");
    }

    public static void main(String[] args) {//CARGA HIPO Y ANIMAL
        System.out.println("C");
        new Hipo();
        //new Hipo();
        //new Hipo();
    }

    static {
        System.out.println("B");
    }
}
