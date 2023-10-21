package com.oracle.ocp.classDesign;

public class Primate {

    public Primate(){
        System.out.println("Primate-");
    }

    static{
        System.out.println("Primate static");
    }
}

class Ape extends Primate{

    public Ape(int fur){
        System.out.println("Ape1-");
    }

    public Ape(){
        System.out.println("Ape2-");
    }
}

class Chimpanzee extends Ape{
    public Chimpanzee(){
        super(2);
        System.out.println("Chimpanzee-");
    }

    static{
        System.out.println("Chimpanzee static");
    }

    public static void main(String[] args) {
        new Chimpanzee();
    }
}
