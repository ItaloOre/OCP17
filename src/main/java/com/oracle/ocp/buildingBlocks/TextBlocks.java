package com.oracle.ocp.buildingBlocks;

/**
 * @author Italo Oré
 *
 * Chapter 1 Building Blocks
 *
 * Probando text Blocks
 *
 */
public class TextBlocks {

    public static final String SEPARADOR = "----------------";

    public static void main(String[] args) {
        test1();
    }

    static void test1(){
        String textBlock = """
            Java Study Guilde
            By Author""";

        String pyramid = """
                *
               * *
              * * *  
                """;//Al hacer enter cuenta con un espaciado adicional

        // Illegal text block start: missing new line after opening quotes
        //String error = """Esto no funciona"""/

        String textBlock2 = """
                Hola\n
                Italo""";

        String textBlock3 = """
                Hola\"\"\"
                Italo2""";//El """ siempre me dara salto de linea.



        System.out.println(textBlock);
        System.out.println(SEPARADOR);
        System.out.println(textBlock2);
        System.out.println(SEPARADOR);
        System.out.println(textBlock3);
        System.out.println(SEPARADOR);
        System.out.println(pyramid);
    }


}
