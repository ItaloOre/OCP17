package com.oracle.ocp.operators;

/**
 * @author Italo Oré
 *
 * Chapter 2 Operators
 *
 * Jugando un poco
 *
 */
public class Operators {

    private static final String SEPARADOR = "----------------";

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
        test8();
    }

    static void test1(){
        int cookies = 4;
        double reward = 3 + 2 * --cookies;
        System.out.println(reward);
        System.out.println(SEPARADOR);
    }

    static void test2(){
        boolean isAnimalAsleep = false;
        System.out.println(isAnimalAsleep);
        System.out.println(!isAnimalAsleep);

        int value = 3; //0011
        int complement = ~value;//1100
        System.out.println(value);
        System.out.println(complement);

        System.out.println(-1*value-5);

        //int pelican = !5 NO COMPILA
        //boolean bool = -bool NO COMPILA
        System.out.println(SEPARADOR);
    }
    static void test3(){
        int count = 0;
        System.out.println(count++); //0 y luego 1
        System.out.println(count);//1
        System.out.println(++count);//2
        System.out.println(count);//2
    }

    static void test4(){
        int x = 1;
        long y = 7;
        var z = x*y;//LO PASA A LONG
        System.out.println(z);

        double a = 39.21;
        float b = 2.1f;
        var c = a + b;// LO PASA A DOUBLE
        System.out.println(c);

        short xx = 10;
        short yy = 5;
        var zz = xx + yy; // LO PASA A INT
        System.out.println(zz);

        short p = 5;
        float q = 10.4F;
        double r = 20;
        double s = p*q/r;
        System.out.println(s);//SE PASA A DOUBLE

        System.out.println(SEPARADOR);
    }

    static void test5(){
        int fur = (int) 5.51d;//No lo redondea
        int hair = (short) 2;
        short tail = (short)(4 + 10);

        long feathers = 10;
        float egg = (float)2.0;

        int tadpole = (int)(5 *2l);
        int tadpole2 = (5 *(int)2l);

        short mouse = 10;
        short cat = 5;
        short tom = (short)(mouse + cat);

        //-128 a 127
        byte hat = 127;
        //byte hat = 12 * 12; NO COMPILA

        System.out.println(fur);
        System.out.println(hair);
        System.out.println(tail);
        System.out.println(SEPARADOR);
    }

    static void test6(){
        int camel = 2,giraffe = 3;
        camel = camel * giraffe;
        camel *= giraffe;

        long goat = 10;
        int sheep = 5;
        //sheep = sheep * goat; NO COMPILA
        sheep *= goat;// COMPILA PORQUE LO CASTEA A LA VARIABLE DE LA DERECHA
        System.out.println(sheep);
        System.out.println(Boolean.valueOf("TRUE"));
        System.out.println(SEPARADOR);
    }

    static void test7(){
        Integer zooTime = Integer.valueOf(9);
        Number num = zooTime;
        Object obj = zooTime;

        if(obj instanceof Integer)
            System.out.println("Es integer");

        System.out.println(null instanceof Integer);//IMPRIME FALSE

        Boolean a = Boolean.TRUE;
        Boolean b = Boolean.FALSE;
        System.out.println(a ^ b);// UNO TIENE QUE SER TRUE Y EL OTRO FALSE PARA QUE SEA TRUE

        boolean c = (boolean) Boolean.TRUE;
        System.out.println(c);
        System.out.println(SEPARADOR);
    }

    static void test8(){
        //int note = 1 * 2 + (long)3; NO COMPILA
        int note =5 ;
        short melody = (byte)(double)(note *= 2);
        double song = melody;
        float symphony = (float)((song == 10F) ? song * 2L : song);
        System.out.println(symphony);
        System.out.println(SEPARADOR);
    }


}
