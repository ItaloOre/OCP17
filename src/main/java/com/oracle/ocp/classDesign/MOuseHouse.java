package com.oracle.ocp.classDesign;

public class MOuseHouse {

    private final int volumen;
    private final String name;

    //{volumen = 10;}



//    public MOuseHouse(){
//        this.name = "Empty House";
//    }
//
//    {volumen = 10;}
    {
        volumen = 10;
        System.out.println("A");
    }

    public MOuseHouse(){
        System.out.println("C");
        this.name = "Empty House";
    }

    public static void main(String[] args) {
        new MOuseHouse();
    }

    {
        System.out.println("B");
    }

}
