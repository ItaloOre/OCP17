package com.oracle.ocp.beyondClasses;

public class Primate {

    public boolean hasHair(){
        return true;
    }
}

interface HasTail{
    boolean isTailStripped();
}

class Lemur extends Primate implements HasTail{
    public int age = 10;

    public void play(){}

    @Override
    public boolean isTailStripped() {
        return false;
    }

    public static void main(String[] args) {
        Lemur lemur = new Lemur();
        System.out.println(lemur.age);
        HasTail hasTail = new Lemur();// I = Climpl SOLO FUNCIONA PORQUE SI O SI IMPLEMENTA LA INTERFAZ
        //HasTail.play(); NO FUNCIONA PORQUE haistail no tiene ese metodo. OJO OJO OOOOOJJJOOOO

        Primate primate = new Lemur();//Cp = Ch
        //primate.isTailStripped(); NO LE PERTENECE A PRIMATE
    }
}
