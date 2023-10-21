package com.oracle.ocp.lambdasAndFI;

import java.util.ArrayList;
import java.util.function.Predicate;

public class DuckHelper {
    public static void teacher(String name, LearnToSpeak trainer){
        trainer.speak(name);
    }
}

class Duckling {
    public static void makeSound(String sound){
        //I = Lambda implementa
        LearnToSpeak learner = System.out::println;
        DuckHelper.teacher(sound,learner);
    }

    public void variable(int a ){
        Predicate<Integer> p1 = x -> {
          int b = 0;
          int c = 0;
          return b == c;
        };

        new ArrayList<>();
    }
}
