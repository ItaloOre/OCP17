package com.oracle.ocp.beyondClasses;

interface MyBirld{}

//RECORD sirven para crear objetos inmutables
public record Crane(int numberEggs,String name) implements MyBirld{//implicito final

    //constructores
    public Crane{ //constructor COMPACTO
        if(numberEggs <= 0) throw new IllegalArgumentException();//SOLO RUNTIME
        name = name.replace('a','A');
        //this.numberEggs = numberEggs; IMPLICITO
    }

//    public Crane(int numberEggs,String name){
//        if(numberEggs <= 0) throw new IllegalArgumentException();
//        this.numberEggs = numberEggs;
//        this.name = name;
//    }
    //metodos
    //constantes
}

//NO HAY HERENCIA DE RECORD PORQUE ES FINAL

class CraneMain{
    public static void main(String[] args) {
        var mommny = new Crane(4,"Cammy");
        System.out.println(mommny.numberEggs());
        System.out.println(mommny.name());

        //var mommny2 = new Crane("Cammy",4); ERROR, LA FIRMA TIENE QUE SER IGUAL

        var father = new Crane(0,"Craig");
        System.out.println(father);

        var copyFather = new Crane(0,"Craig");

        System.out.println(father.equals(copyFather));// LOS RECORS SON IGUALES SI SE CONSTRUYEN IGUAL

        var cousin = new Crane(2,"Jenny");
        var friend = new Crane(cousin.numberEggs(), "Katerine");
        System.out.println(cousin.equals(friend));
    }
}
