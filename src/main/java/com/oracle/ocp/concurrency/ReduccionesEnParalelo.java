package com.oracle.ocp.concurrency;

import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReduccionesEnParalelo {

    public static void main(String[] args) {
        System.out.println(List.of(1,2,3,4,5,6).stream().findAny().get());

        //EL RESULTADO ES IMPREDECIBLE
        System.out.println(List.of(1,2,3,4,5,6).parallelStream().findAny().get());

        System.out.println(List.of('i','t','a','l','o')
                .stream()
                .reduce("",(s1,c) -> s1+c,(s2,s3)->s2+s3));

        //PUEDE TRABAJAR EN PAREJAS
        //EL API STREAM EVITA EL PROBLEMA SEL RANDOM SI EL ACUMULADOR Y EL COMBINADOR RETORNAN SIN IMPORTAR EL ORDEN
        //EN EL QUE SON LLAMADOS
        System.out.println(List.of('i','t','a','l','o')
                .parallelStream()
                .reduce("",(s1,s2) -> s1+s2,(s1,s2)->s1+s2));

        //ROMPIENDO LA REGLA
        System.out.println(List.of(1,2,3,4,5,6)
                .parallelStream()
                .reduce(0,(a,b) -> (a-b)));

        System.out.println(List.of("i","t","a","l","o")
                .parallelStream()
                .reduce("X",String::concat));

        //UTILIZANDO COLLECT

        Stream<String> stream = Stream.of("w", "o", "l", "f").parallel();
        SortedSet<String> set = stream.collect(ConcurrentSkipListSet::new,
                Set::add,
                Set::addAll);
        System.out.println(set); // [f, l, o, w]

        Stream<String> ohMy = Stream.of("lions", "tigers", "bears").parallel();
        ConcurrentMap<Integer, String> map = ohMy
                .collect(Collectors.toConcurrentMap(String::length,
                        k -> k,
                        (s1, s2) -> s1 + "," + s2));
        System.out.println(map); // {5=lions,bears, 6=tigers}
        System.out.println(map.getClass()); // java.util.concurrent.ConcurrentHashMap
    }

}
