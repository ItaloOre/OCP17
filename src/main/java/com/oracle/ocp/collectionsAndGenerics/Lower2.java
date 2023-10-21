package com.oracle.ocp.collectionsAndGenerics;

import java.util.ArrayList;
import java.util.List;

public class Lower2 {

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("tweet");

        List<Object> objects = new ArrayList<>(strings);
        addSound(strings);
        addSound(objects);
        
    }

    private static void addSound(List<? super String> list) {
        list.add("quack");
        System.out.println(list);
    }

    //QUE PASARIA SE SE ENVIA UN INTEGER? AMBIGUO, ERROR
    private static void addSound2(List<? extends Object> list) {
        //list.add("quack");Error
        System.out.println(list);
    }

    //LISTA DESCONOCIDA, No te deja agregarlo
    private static void addSound3(List<?> list) {
        //list.add("quack"); ERROR Comp
        System.out.println(list);
    }

}
