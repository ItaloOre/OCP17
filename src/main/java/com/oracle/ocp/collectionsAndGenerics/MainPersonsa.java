package com.oracle.ocp.collectionsAndGenerics;

import java.util.ArrayList;
import java.util.List;

public class MainPersonsa {

    public static void main(String[] args) {
        List<Persona> personaList = new ArrayList<>();
        personaList.add(new Persona("Italo"));
        personaList.add(new Persona("Arles"));

        imprimir(personaList);
    }

    private static void imprimir(List<Persona> personaList) {
        for (Persona p : personaList){
            System.out.println(p.getNombre());
        }
    }
}
