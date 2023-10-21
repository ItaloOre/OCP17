package com.oracle.ocp.classDesign;

//Sirve para definir jerarquia y mejetodos que los hijos hereden
public abstract class PersonAbstract {

    //public abstract void play(){} No tienen cuerpo los metodos abstracto
    public void play(){
        System.out.println("Oli");
    }
    //Alguien va a tener que implementar este metodo si o si
    public abstract void run();

}

abstract class PeronaNatural extends PersonAbstract{

}

class ItaloOre extends PeronaNatural {

    @Override
    public void run() { } // IMPLEMENTACION OBLIGATORIA

}
