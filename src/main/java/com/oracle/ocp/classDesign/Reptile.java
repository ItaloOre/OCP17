package com.oracle.ocp.classDesign;


class ReptileFather{
    protected int speed = 5;
}

public class Reptile {

    protected int speed = 10;

}

class Crocodile extends Reptile{

    protected int speed = 20;

    public int getSpeed() {
        //return super.speed; LLAMAMOS EL ATRIBUTO DEL PADRE
        return speed;//LLAMAMOS EL ATRIBUTI ACTUAL
    }

    public static void main(String[] args) {
        var croc = new Crocodile();
        System.out.println(croc.getSpeed());
    }
}
