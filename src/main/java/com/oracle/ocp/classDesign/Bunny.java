package com.oracle.ocp.classDesign;

public class Bunny {


    public static void main(String[] args) {
        var bunny = new Bunny(8);
        //Me crrea un constructor vacia con el super(); Constructor sin argumentos del padre

    }
    //public bunny(){} NO COMPILA, NO TIENE EL NOMBRE DE LA CLASE
    //public void Bunny NO COMPILA, USA VOID
    //public Bunny(var a){} NO COMPILA, NO SE PUEDE USAR var EN UN CONSTRUCTOR;[=

     // OJO, SI DECLARO OTRO CONSTRUCTOR, DESAPARECE EL CONSTRUCTOR POR DEFECTO

    Bunny(int a){
        //el super() lo agrega de manera automatica
    }

    public Bunny(){super();}
}
