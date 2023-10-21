package com.oracle.ocp.classDesign;

public class Insect {
    protected  int numberOfLegs = 4;
    String label = "buggy";
}

class Beetle extends  Insect{
    protected int numberOfLegs = 6;
    short age = 3;

    public void printData(){
        System.out.println(this.label);
        System.out.println(super.label);
        System.out.println(this.age);
        //System.out.println(super.age); MP FUNCIONA
        System.out.println(numberOfLegs);
    }

    public static void main(String[] args) {
        var beetle = new Beetle();
        beetle.printData();
    }
}
