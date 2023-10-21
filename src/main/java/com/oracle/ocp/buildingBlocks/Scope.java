package com.oracle.ocp.buildingBlocks;

/**
 * @author Italo Oré
 *
 * Chapter 1 Building Blocks
 *
 * Probando alcance
 *
 */
public class Scope {

    static int count = 0;//VARIABLE DE CLASE (INDEPENDIENTE DE LA INSTANCIA)

    int length = 2; //VARIABLE DE INSTANCIA

    static final int MAX_LENGTH = 5;

    public static void main(String[] args) {
        eat(true);
        //System.out.println(length); NO PUEDO USAR VARIABLES NO ESTATIVAS DENTRO DE UN METODO ESTATICO
    }

    public static void eat(boolean hungry){
        if(hungry){
            int bitesOdCheese = 1; //VARIABLE LOCAL
        }
        //System.out.println(bitesOdCheese); FUERA DE ALCANCE
    }

    public void grow(int inches){
        //int a;System.out.println(a); LAS VARIABLES LOCALES NO TIENEN UN VALOR POR DEFECTO
        System.out.println(count);
        System.out.println(length);

    }



}
