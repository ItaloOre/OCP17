package com.oracle.ocp.beyondClasses;

public enum OnlyOne {
    ONCE(true);

    OnlyOne(boolean b) {
        System.out.println("Constructing");
    }
}

class PrintTheOne{
    public static void main(String[] args) {
        System.out.println("Begin, ");

        OnlyOne fistCall = OnlyOne.ONCE;

        OnlyOne secondCall = OnlyOne.ONCE;

        System.out.println("END ");
    }
}
