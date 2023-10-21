package com.oracle.ocp.collectionsAndGenerics;

import java.util.*;

public class SortRabbits {

    static record Rabbit(int id){}

    public static void main(String[] args) {
        List<Rabbit> rabbitList = new ArrayList<>();
        rabbitList.add(new Rabbit(3));
        rabbitList.add(new Rabbit(1));
        Comparator<Rabbit> c = (r1,r2) -> r1.id - r2.id;
        Collections.sort(rabbitList,c);
        Collections.reverse(rabbitList);//TIENE QUE ESTAR ORDENADO PARA REVERTIR
        System.out.println(rabbitList);

        List<Integer> list = Arrays.asList(6,9,1,8);
        Collections.sort(list);
        System.out.println(list);
        //SOLO ES PREDECIBLE PARA LISTAS ORDENADAS
        System.out.println(Collections.binarySearch(list,6));
        System.out.println(Collections.binarySearch(list,0));
        //1 3 ,4 ,8 ,9
        //-1 -1 = -1
        System.out.println(Collections.binarySearch(list,3));
        //1 3 ,4 ,8 ,9
        //-2 -1 = -1

        //AQUI NO HEMOS PORDENADO, por tal motivo el resultado es inpredecible
        var names = Arrays.asList("Fluffy","Hoppy");
        Comparator<String> comparator = Comparator.reverseOrder();
        var index = Collections.binarySearch(names,"Hoppy",comparator);
        System.out.println(index);

        
    }
}
