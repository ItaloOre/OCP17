package com.oracle.ocp.buildingBlocks;

/**
 * @author Italo Oré
 *
 * Chapter 1 Building Blocks
 *
 * Probando declaracion de variables
 *
 */
public class ValidFiles {

    public static final String SEPARADOR = "----------------";

    //var name = "Italo"; NO SE PUEDE USAR EN VARIABLES DE INSTANCIA

    public static void main(String[] args) {
        test1();
    }

    public static void test1(){
        long fafsafa;
        float $euro;
        boolean _false;
        char ___a;
        //No se puede iniciar con numero
        //int 3dPoint
        //No se puede usar @ ni *
        //int holly@coffe*;

        int i1,i2,i3=2; //solo se inicia i3 con valor 3
        //double a, doubleb //No compila
        //double i3;i4 //No compila

        var silly = 2; //SI SE PUEDE USAR EN VARIAVLES LOCALES

    };

}
