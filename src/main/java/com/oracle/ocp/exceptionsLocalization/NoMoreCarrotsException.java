package com.oracle.ocp.exceptionsLocalization;

import java.io.IOException;

public class NoMoreCarrotsException extends Exception{

}

class Bunny{

    public static void main(String[] args){ //Si uso  throws se cae el sistema
        //eatCarrot() NO COMPILA
        try {
            eatCarrot();
        } catch (NoMoreCarrotsException e) {
            e.printStackTrace();
        }
    }

    private static void eatCarrot() throws NoMoreCarrotsException{

    }
}

class MsBunny{
    public static void main(String[] args){
        try {
            pong();
        }  catch (ArithmeticException | IllegalArgumentException e) {
            e.printStackTrace();
            System.out.println("Error no checkeado");
        }
        catch (IOException e) {
            System.out.println("Error en IO");
            //e.printStackTrace();
        } finally {
            System.out.println("Entro al final");
        }
    }
    private static void pong() throws IOException {
        throw new IOException("GAAAA");
    }

    //RECUERDA QUE NO PUEDES TENER UN TRY SOLITO, SIEMPRE CON CATCH O FINAL

}