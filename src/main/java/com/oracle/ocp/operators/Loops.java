package com.oracle.ocp.operators;

public class Loops {

    private static final String SEPARADOR = "----------------";

    public static void main(String[] args) throws Exception {
        test1();
        test2();
        test3();
        test4();
        test5();
    }
    //LOOP FOR
    static void test1(){
        int x = 0;
        //SOLO 3 ";"
        for(long y = 0,z = 4; x<5 && y < 10 ; x++, y++){//OJO var no se puede usar para declaraciones multiples
            System.out.println(y + " ");
        }
        System.out.println(x + " ");

        System.out.println(SEPARADOR);
    }

    //ITERACIONES ANIDADAS
    static void test2(){
        int [][] myCompleyArray = {{5,2,1,3},{3,9,8,9},{5,7,12,7}};
        OUTER_LOOP: for ( int[] mySimpleyArray : myCompleyArray){
            INNER_LOOP: for (int i = 0; i< mySimpleyArray.length;i++){
                System.out.println(mySimpleyArray[i] + "\t");
            }
            System.out.println();
        }

        System.out.println(SEPARADOR);
    }

    //UTILIZANDO PUNTEROS
    static void test3(){
        int []list[] = {{1,13},{5,2},{2,2}};
        int searchValue = 2,positionX = -1,positionY = -1;

        PARENT_LOOP: for (int i = 0; i <= list.length; i++){
            for (int j = 0; j < list[i].length; j++){
                if(list[i][j] ==searchValue){
                    positionX = i;
                    positionY = j;
                    break PARENT_LOOP;
                }
            }
        }
        if(positionX == -1 || positionY == -1){
            System.out.println("Value " + searchValue + " not found");
        } else {
            System.out.println("Value " + searchValue + " found at: " + positionX + "," + positionY);
        }

        System.out.println(SEPARADOR);
    }


    static void test4(){
        CLEANING: for(char stables = 'a';stables<='d';stables++){
            for (int leopard = 1;leopard < 4 ; leopard++){
                if(stables=='b' || leopard==2){
                    continue CLEANING;
                }
                System.out.println("CLEANING " + stables + ", " + leopard);
            }
        }
        System.out.println(SEPARADOR);
    }

    //Ojo con el return int[] es una variable de referencia
    static void test5(){
        int []list[] = {{1,13},{5,2},{2,2}};
        int result[] = searchForValue(list, 2);
        System.out.println( result[0] + "," + result[1] );
    }
    private static int[] searchForValue(int [][] list, int v) {

        int[] array = {5,6,7};
        //int[] array2; OJO, NO SE PUEDE DECLARAR EN LA SEGUNDA LINEA SIN UN NEW
        //array2 = {5,6,7};

        for (int i = 0; i <= list.length; i++){
            for (int j = 0; j < list[i].length; j++){
                if(list[i][j] == v){
                    return new int[]{i,j};// OJO, NMO COLOCAR int[NUMERO], Si tienes {i,j}
                }
            }
        }
        return null;
    }


}
