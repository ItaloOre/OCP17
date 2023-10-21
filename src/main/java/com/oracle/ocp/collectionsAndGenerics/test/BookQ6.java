package com.oracle.ocp.collectionsAndGenerics.test;

import com.oracle.ocp.collectionsAndGenerics.SortRabbits;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BookQ6{

}

/**
 * @author Italo Oré
 *
 * PREGUNTA 6, mucho ojo con el ordenamiento
 *
 */
record Platypus(String name, int beakLength) {

    @Override public String toString() {return "" + beakLength;}

    public static void main(String[] args) {
        Platypus p1 = new Platypus("Paula", 3);
        Platypus p2 = new Platypus("Peter", 5);
        Platypus p3 = new Platypus("Peter", 7);

        List<Platypus> list = Arrays.asList(p1, p2, p3);
        List<Platypus> list2 = Arrays.asList(p1, p2, p3);
        //A PESAR QUE COMPARATOR Usa compare se puede usar Comparator.comparing(p -> p.name)
        new Comparator<Platypus>() {
            @Override
            public int compare(Platypus o1, Platypus o2) {
                return o1.beakLength - o2.beakLength;
            }
        };

        Comparator<Platypus> c = (r1, r2) -> r1.beakLength - r2.beakLength;
        Comparator<Platypus> c2 = Comparator.comparingInt(r -> r.beakLength);

        //-------

        Collections.sort(list, Comparator.comparing(Platypus::beakLength).reversed());
        System.out.println(list);

        Collections.sort(list2, Comparator.comparing(Platypus::name)
                .thenComparingInt(Platypus::beakLength)
                .reversed());

        System.out.println(list2);

    }
}
