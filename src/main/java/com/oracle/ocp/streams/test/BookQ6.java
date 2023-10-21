package com.oracle.ocp.streams.test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class BookQ6 {

    private static final String SEPARADOR = "----------------";

    public static void main(String[] args) {
        tes1();
    }
/**
 * A. allMatch
 * B. anyMatch
 * C. findAny
 * D. findFirst
 * E. noneMatch
 * F. None of the above
 */
    private static void tes1() {

        var s = Stream.generate(() -> "meow");
        var match = s.allMatch(String::isEmpty);
        System.out.println(match);
    }


}
