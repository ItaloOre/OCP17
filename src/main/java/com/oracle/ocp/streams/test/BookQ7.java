package com.oracle.ocp.streams.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BookQ7 {

    private static final String SEPARADOR = "----------------";

    public static void main(String[] args) {
        List<String> lista = List.of("A","B","C","D","E","F");
        System.out.println(tes1(lista));

    }
    /**
     A.
     return list.stream()
     .compare((a, b) -> b.compareTo(a))
     .collect(Collectors.toList());
     B.
     return list.stream()
     .compare((a, b) -> b.compareTo(a))
     .sort();
     C.
     return list.stream()
     .compareTo((a, b) -> b.compareTo(a))
     .collect(Collectors.toList());
     D.
     return list.stream()
     .compareTo((a, b) -> b.compareTo(a))
     .sort();
     E.
     return list.stream()
     .sorted((a, b) -> b.compareTo(a))
     .collect();
     F.
     return list.stream()
     .sorted((a, b) -> b.compareTo(a))
     .collect(Collectors.toList());
     */
    private static List<String> tes1(List<String> list) {

        //stream no tiene compare ni compareTo
        return list.stream()
                .sorted((a, b) -> b.compareTo(a))
                .collect(Collectors.toList());

    }

    private static List<String> sort(List<String> list) {
        var copy = new ArrayList<String>(list);
        Collections.sort(copy, (a, b) -> b.compareTo(a));
        return copy;
    }

}
