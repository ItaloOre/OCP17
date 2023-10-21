package com.oracle.ocp.classDesign;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Camel {

    public int getNumberOfHumps(){
        return 1;
    }

    protected void sleep() throws IOException{}

    protected void hide() {}

    public void swim(){}

    protected void exitShell() throws FileNotFoundException{}

    protected  CharSequence getName(){return "Rhino";} // RETORNO COVARIANTE

    private String getSize(){return "2";} // privado no se hereda

    public static void eat(){
        System.out.println("padre");
    }// OJO CON LOS ESTATICOS
}

class BactrianCamel extends Camel{

    @Override
    public int getNumberOfHumps(){// TIENE QUE SE PUBLIC, no puede ser mas restrictivo que su padre
        return 2;
    }


    //protected void sleep() throws Exception{}; No puede se la excepcion mas amplia de lo declarado.

    // protected void hide() throws FileNotFoundException{} NO COMPILA,si el padre no declara yo no puedo declarar

    //protected void exitShell() throws Exception{} NO COMPILA, no puedo usar en un hijo una excepcion padre

    protected void hide() throws NullPointerException{}// VALIDO, no hay problema con Runtime

    public static void main(String[] args) {
        var batrian = new BactrianCamel();
        System.out.println(batrian.getNumberOfHumps());
        Camel.eat();
        BactrianCamel.eat();
    }

    protected String getName(){return "Rhino";} // RETORNO COVARIANTE

    //@Override No hay sobreescritura porque la firma es distinta, esto es sobreescritura (overload )
    public void swim(int speed){}

    private String getSize(){return "2";} // privado no se hereda, este es otro metrodo

    public static void eat(){
        System.out.println("Hijo");
    }// OJO CON LOS ESTATICOS, es ocultamento de metodo
}


