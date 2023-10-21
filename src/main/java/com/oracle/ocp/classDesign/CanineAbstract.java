package com.oracle.ocp.classDesign;

public abstract class CanineAbstract {

    public abstract String getSound();

    public void bark(){
        System.out.println(getSound());
    }

    public static void main(String[] args) {
        CanineAbstract w = new Dog();
        w.getSound();//llama metodo de padre
        //w.getSound2(); OJO, EN TIEMPO DE COMPILACION SALE ERROR
    }
}

class Wolf extends CanineAbstract{

    @Override
    public String getSound() {
        return "AUUUU";
    }
}

class Dog extends CanineAbstract{

    @Override
    public String getSound() {
        return "GUAUU";
    }

    public String getSound2() {
        return "GUAUU2";
    }
}
