package com.oracle.ocp.classDesign;

public class ZooTickets {

    private String name = "BestZoo";

    {
        System.out.println(name + "-");
    }

    private static int COUNT = 0;
    static {
        System.out.println(COUNT + "-");
    }
    static{
        COUNT+=10;
        System.out.println(COUNT + "-");
    }

    public ZooTickets(){
        System.out.println("z-");
    }

    public static void main(String[] args) {
        //Los static se ejecutan incluso sin llamar al objeto.
        new ZooTickets();
    }

}
