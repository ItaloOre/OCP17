package com.oracle.ocp.methods;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class Lion {
    //Variables de instancia
    //Instancia variables
    int hunger = 4; //default=0
    String name; //dafloult is null
    double average; //0.0
    boolean active; //false
    final String miFinal;//El final siempre debe inicializarse
    static int contador = 0;

    public  int total = 10;
    //public static double average2 = total/5; TIENE QUE SER STATIC total

    //{this.miFinal = "name";} SE PUEDE UTILIZAR EN UN BLOQUE DE INICIALIZACION DE INSTANCIA

    public static void main(String[] args) {
        var a = new Lion();
        var b = new Lion();
        System.out.println(Lion.contador);//Imprime 2 porque la variable es de la clase.


    }

    public List<String> asListq(String... a){
        List<String> list = asList("one","two");
        return new ArrayList<>();
    };

    public Lion(){
        this.miFinal = "name";
        {System.out.println(1);};
        contador++;
    }

    {System.out.println(10);};// SE EJECUTA ANTES QUE EL CONSTRUCTOR

    public int feedZooAnimals(){
        int snack;// VARIABLE LOCAL QUE NO TIENE VALOR NO SE PUEDE USAR
        final int snak2; // EL UNICO MODIFICADOR QUE SE LE PUEDE PONER A UNA VARIABLE LOCAL ES FINAL
        return snack = 3;
    }


}
