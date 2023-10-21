package com.oracle.ocp.buildingBlocks;
/**
 * @author Italo Oré
 *
 * Chapter 1 Building Blocks
 *
 * Probando la destruccion de objetos
 *
 */
public class ObjectDes {

    public static void main(String... args) {//public static SE PUEDEN INVERTIR, tambien se puede usar final
        Cap1  m1 = new Cap1();
        m1.length = 7;
        Cap1 m2 = new Cap1();
        m1.length = 5;
        m1 = m2;

        if(true){
            Cap1 m3 = new Cap1();
        } // m3 es elegido para el GC
        var m4 = new Cap1();
    } // m1,m2,m3,m4 son elegidos para el GC

    static void scope(){
        String one,two;
        one = new String("A");
        two = new String("B");
        one = two; // ONE Y TWO APUNTA a B

        String three = one;// ONE,TWO Y THREE APUNTA a B
        one = null; //APUNTA A NADA
    }

}
