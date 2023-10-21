package com.oracle.ocp.buildingBlocks;

/**
 * @author Italo Oré
 *
 * Chapter 1 Building Blocks
 *
 * Probando bloques de inicializacion
 *
 */
public class IniBlock {

    public IniBlock(){
    number = 5;
    }

    public static void main(String[] args) {
        {System.out.print("HOLA mundo");} //Bloque de inicializacion *(Se ejectuta antes del constructod)
        var egg = new IniBlock();
        System.out.println(egg.number);

        test1();
    }

    private int number = 3;

    {
        number = 4;//Tienes que definirse number antes de usarlo en un bloque de inicializacion de instancia.
    }

    static void test1() {

        System.out.println(Boolean.valueOf("true")); //pasar de primitivo a referencia
        Integer a = Integer.parseInt("100");//pasar de referencia a primitivo
        Double apple = Double.valueOf("200.99");
        System.out.println(apple.byteValue());
    }



}
