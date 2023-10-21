package com.oracle.ocp.collectionsAndGenerics;

import java.util.Arrays;
import java.util.List;

public class LowerWilcardDemo {

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(4,5,6,7);
        printOnlyIntegersClassOrSuperClass(list1);
        List<Number> list2 = Arrays.asList(1,2,3,4);
        printOnlyIntegersClassOrSuperClass(list2);
    }

    private static void printOnlyIntegersClassOrSuperClass(List<? super Integer> list) {
        //list.add(3); SACA un RUNTIME porque es impuntable
        System.out.println(list);
    }

}

