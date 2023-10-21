package com.oracle.ocp.lambdasAndFI;

import java.util.ArrayList;

public class TraditionalSearch {

    public static void main(String[] args) {
        var animals = new ArrayList<Animal>();

        animals.add(new Animal("fish",false,true));
        animals.add(new Animal("fish",true,false));
        animals.add(new Animal("fish",true,false));
        animals.add(new Animal("fish",false,true));

        //var invalid = (Animal a) -> a.canHop(); NO SE PUEDE USAR VAR

        print(animals,new CheckIfHopper());
        print(animals, a -> a.canHop());
        print(animals, a -> {return a.canHop();});
    }

    private static void print(ArrayList<Animal> animlas, CheckTrait checkTrail){
        for(Animal a: animlas){
            if(checkTrail.test(a)){
                System.out.print(a + ", ");
            }
            System.out.println();
        }

    }
}
