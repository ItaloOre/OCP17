package com.oracle.ocp.classDesign;

public class Hamster {

    private String color;

    private int weight;

    public Hamster(int weight,String color){
        this.color = color;
        this.weight = weight;
    }

    public Hamster(int weight){
        this(weight,"Black"); // LLAMAR UN CONSTRUCTOR DESDE OTR CONTRUCTOR
        //OJO this SIEMPRE EN PRIMERIA LINEA
        System.out.println("el this siempre en primera linea, yo estoy bien por que estoy segundo.");
    }

    //public Hamster(int a){this(5)}; LLAMADA RECURSIVA



}

class Hamster2 extends Hamster{

    public Hamster2(int weight, String color) {
        //OJO, NO SE PUEDEN USAR AMBOS
        //this(weight);
        super(weight, color);

    }

    public Hamster2(int weight) {
        super(weight);
    }

}
