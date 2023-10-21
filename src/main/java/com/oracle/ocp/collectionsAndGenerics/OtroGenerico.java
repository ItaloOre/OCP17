package com.oracle.ocp.collectionsAndGenerics;

import java.util.ArrayList;
import java.util.List;

public class OtroGenerico {


    public static void main(String[] args) {
        List<?> list1 = new ArrayList<A>();
        List<? extends A> list2 = new ArrayList<A>();
        List<? super A> list3 = new ArrayList<A>();


        list1 = new ArrayList<A>();
        list1 = new ArrayList<B>();
        list1 = new ArrayList<C>();
        list1 = new ArrayList<String>();
        // ...

        list2 = new ArrayList<A>();
        list2 = new ArrayList<B>();
        list2 = new ArrayList<C>();

        list3 = new ArrayList<Object>();

        //SOLO CUANDO USO SUPER PUEDO USAR ADD
        list3.add(new A());
        list3.add(new B());

    }

}

class A{}
class B extends A{}
class C extends B{}