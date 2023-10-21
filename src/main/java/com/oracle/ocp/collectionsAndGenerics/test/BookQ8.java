package com.oracle.ocp.collectionsAndGenerics.test;

import java.util.Arrays;
import java.util.Comparator;

public class BookQ8 {
}

/**
 * @author Italo Oré
 *
 * PREGUNTA 8, mucho ojo con el ordenamiento
 * Primero son numero, mayusculas y minusculas
 *
 */
class MyComparator implements Comparator<String> {
    public int compare(String a, String b) {
        return b.toLowerCase().compareTo(a.toLowerCase());
    }

    public static void main(String[] args) {
        String[] values = { "123", "Abb", "aab" };
        Arrays.sort(values, new MyComparator());

        for (var s: values)
            System.out.print(s + " "); // Abb aab 123
    }
}
