package com.oracle.ocp.collectionsAndGenerics.test;

public class BookQ5 {


}

/**
 * @author Italo Oré
 *
 * PREGUNTA 5, mucho ojo con los genericos
 *
 */
record Hello<T>(T t) {

    public Hello(T t) { this.t = t; }
    private <T> void println(T message) {
        System.out.print(t + "-" + message);
    }
    public static void main(String[] args) {
        new Hello<String>("hi").println(1);
        new Hello("hola").println(true);
    }
}
