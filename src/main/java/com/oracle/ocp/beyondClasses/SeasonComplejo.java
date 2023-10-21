package com.oracle.ocp.beyondClasses;

public enum SeasonComplejo {
    WINTER("Low"),SPRING ("Medium"),SUMMER ("Hight"),FALL ("Medium");

    private final String expectedVisitors;//BUENA PRACTICA QUE ESTOS VALORES SEAN INMUTABLES


    SeasonComplejo(String expectedVisitors) {//PRIVADO POR DEFECTO
        System.out.println("Constructing");
        this.expectedVisitors = expectedVisitors;
    }

    public void printExpectedVisitors(){//Season.SPRING.printExpectedVisitors
        System.out.println("printExpectedVisitors");
        System.out.println(expectedVisitors);
    }


}

class PrintSeason{
    public static void main(String[] args) {
        SeasonComplejo s = SeasonComplejo.SPRING;
        SeasonComplejo W = SeasonComplejo.WINTER;
    }
}
