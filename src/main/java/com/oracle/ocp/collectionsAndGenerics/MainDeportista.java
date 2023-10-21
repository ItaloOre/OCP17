package com.oracle.ocp.collectionsAndGenerics;

import java.util.ArrayList;
import java.util.List;

public class MainDeportista {

    public static void main(String[] args) {
        List<Deportista> deportistaList = new ArrayList<>();
        deportistaList.add(new Deportista("Italo","Running"));
        deportistaList.add(new Deportista("Arles", "Futbol"));

        imprimir(deportistaList);
    }

    //private static void imprimir(Persona> deportistaList) { NO FUNCIONA
    private static void imprimir(List<? extends Persona> deportistaList) {
        for (Persona p : deportistaList){
            System.out.println(p.getNombre());
        }
    }
}
