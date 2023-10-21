package com.oracle.ocp.methods;

public class Toucan {

    public static void main(String[] args) {
        var t = new Toucan();
        //t.fly(1,2,3,4,5); NO FUNCIONA con int[] args
        t.fly(new int[]{1,2,3});
    }

    public void fly(int[] args){};

    //public void fly(int... args){};
}
