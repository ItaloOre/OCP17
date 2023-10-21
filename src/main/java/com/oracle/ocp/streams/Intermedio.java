package com.oracle.ocp.streams;

import java.util.stream.Stream;

public class Intermedio {

    private static final String SEPARADOR = "----------------";

    public static void main(String[] args) {
        prueba1();
    }

    private static void prueba1() {

        //Ejemplo PEEK, se usa para debuggiar
        var stream = Stream.of("Black bear", "brown bear", "grizzly");

        long count = stream.filter(s -> s.startsWith("g"))
                        .peek(System.out::println).count();
        System.out.println(count);
        System.out.println(SEPARADOR.concat(SEPARADOR));
    }

}
