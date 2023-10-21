package com.oracle.ocp.beyondClasses;

public record OtroCrane(int numberEggs,String name) {

    private static int type = 10;
    //private int size; SOLO ESTATICOS
    //NO HAY INICIADORES DE INSTANCIA


//CUIDADO CON LA RECURSIVIDAD
//    public OtroCrane(String name){
//        this(1);
//    }
//
//    public OtroCrane(int numberEggs){
//        this("");
//    }

    public OtroCrane{

    }

//    public OtroCrane(int numberEggs,String name){
//
//    }

    public OtroCrane(int numberEggs){
        this(numberEggs,"");//PUEDO TENER AMBOS siempre y cuando llame al this compacto
    }

    @Override
    public int numberEggs() {
        return numberEggs;
    }

    @Override
    public String name() {
        return name;
    }


}
