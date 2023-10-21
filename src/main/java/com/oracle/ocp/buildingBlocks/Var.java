package com.oracle.ocp.buildingBlocks;

/**
 * @author Italo Oré
 *
 * Chapter 1 Building Blocks
 *
 * Probando var
 *
 */
public class Var { //NO SE PUEDE CREAR UNA CLASE O INTERFAZ CON NOMBRE var
    //var d = 3; // NO SE PUEDE USAR EN VARIABLES DE INSTANCIA
    public static void main(String[] args) {
        test1();
        test2();
    }

    public static void test1(){
        var name = "Hello";//SI SE PUEDE USAR EN VARIABLES LOCALES
        var size = 7;
        //var size = "www"; NO PUEDES CAMBIAR EL TIPO DE DATO.

        //var question; SE DEBE DEFINIR EN LA MISMA LINEA LA VARIABLE SI SE USA VAR
        //question = 3;
    }

//    public static void error1(var a, var b){} // NO SE PUEDE USAR COMO PARAMERO

    public static void test2(){

    }
}
