package com.oracle.ocp.operators;

import jdk.swing.interop.SwingInterOpUtils;
import org.hibernate.event.spi.SaveOrUpdateEvent;

public class Switch {

    private static final String SEPARADOR = "----------------";

    public static void main(String[] args) throws Exception {
        test1();
        test2();
        test3();
        test4();
        test5(Season.SPRING);
    }

    //SWITCH BASICO
    static void test1(){
        int animal = 3;
        switch (animal){
            case 1:
            case 2:
                System.out.println("Lion");
                break;
            case 3,4,5: //AHORA YA SE PUEDE USAR CON COMAS
                System.out.println("Tiger");
                //break; //SI NO SE EJECUTA BREAK, SE EJECUTA LO DEMAS
            default:
                System.out.println("default");
                break;
            case 6:
                System.out.println("cat");
        }
        System.out.println(SEPARADOR);
    }

    //TIPOS DE DATOS SWITCH
    static void test2(){
        feefAnimals();
        System.out.println(SEPARADOR);
    }

    static final int getCookies(){
        return 4;
    }

    //CASE solo variables final, literales o Enum
    static void feefAnimals(){
        final int banana = 1;
        int apples = 2;
        int numberOfAnimals = 3;
        final int cookies = getCookies();
        switch (numberOfAnimals){
            case banana:
                System.out.println("BANANA");
            //case apples: NO ES FINAL
            //case cookies: // NO SE PUEDE UTILIZAR cookies porque bo es resuelta en tiempo de compilacion.
            case 3 * 5:
                System.out.println("15");
            default:
                System.out.println("Defecto");
        }
    }

    //NUEVO SWITCH (garantizado con resultado)
    static void test3() throws Exception{
        printDayOfWeek(6);
        printSeasonFrom(5);    }

    static void printDayOfWeek(int day) throws Exception{
        //SE DEBEN DE CUBRIR TODOS LOS ESCENARIOS
        var result = switch (day){
            case 0 -> "Sunday";
            case 1 -> "Mondey";
            //...
            case 6 -> "Saturday";
            default -> throw new Exception("Error");// OBLIGATORIO UN DEFAULT
        }; // ; OBLIGATORIO.
        System.out.println(result);
        System.out.println(SEPARADOR);
    }

    //YA NO USO EL break;
    static void printSeasonFrom(int month){
        switch (month){
            case 1,2,3 -> System.out.println("Winter");
            case 4,5,6 -> System.out.println("Spring");
            case 7,8,9 -> System.out.println("Summer");
            case 10,11,12 -> System.out.println("Fall");
        }
        System.out.println("continua con mi trabajo");
    }

    //APLICANDO BLOQUE CASE
    static void test4(){

        int fish = 5,length = 12;

        var name = switch (fish){
            case 1 -> "GoldFish";
            case 2 -> {yield "Trout";} //El ; VA DENTRO DEL BLOQUE CASE
            case 3 -> {
                if(length > 10){
                    yield "Blofish";//EN LUGAR DE RETURN SE USA yield
                } else {
                    yield "Green";
                }
            }
            default -> "SwordFish";
            //case 4 -> {} NO COMPILA
        }; // OJO CON ES EPUNTO Y COMA
        System.out.println(SEPARADOR);
    }

    // No es necesario de defoult con Enum
    static void test5(Season value){
        switch (value){
            case WINTER  -> System.out.println("WINTER");
            case FALL ->  System.out.println("FALL");
            case SPRING -> System.out.println("SPRING");
            case SUMMER -> System.out.println("SUMMER");
        }
        System.out.println(SEPARADOR);
    }


}
