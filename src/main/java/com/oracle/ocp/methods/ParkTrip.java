package com.oracle.ocp.methods;

public class ParkTrip {

    public final static void skip(){}; // No se puede sobreescribir
    void skip2(){}; //se puede usar a nivel de paquete
    protected void skip3(){} //Se pude heredar por sus hijos

    public void swim(int  distance){
        if(distance == 0){
            return;//Es posible utilizar return en un void.
        }
        System.out.println("Hola");
    }

    String hike(int a){
        if(a == 1){//OJO con los if, revisar si hay retorno en todas las sentencias.
            return "1";
        } else {
            return "Otro";
        }
    }

    Long returnLong(){
        //return 5;// NO LO CASTEA TIENE QUE SER LONG SI O SI
        return 5l;
    }

    public void jod1(){};
    //public void 2d(){}; NO COMPILA
    //public void _(){}; NO COMPILA
    ////public void #d[]*(){}; NO COMPILA
}
