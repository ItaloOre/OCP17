package com.oracle.ocp.beyondClasses;

public enum Season {
    WINTER,SPRING,SUMMER,FALL//EL PUNTO Y COMA ES OPCIONAL SI ES UN ENUM SIMPLE
}

class TestEnum {
    public static void main(String[] args) {
        var s = Season.SUMMER;
        System.out.println(s = Season.SUMMER);

        for(var season:Season.values()){
            System.out.println(season.name() + "-" + season.ordinal());
        }

        Season s2 = Season.valueOf("WINTER");

        //Season s3 = Season.valueOf("spring"); java.lang.IlegarArgumentException

        String message = switch (s){
            case WINTER -> "WINTER";
            case SUMMER -> "SUMMER";
            case FALL -> "FALL";
            case SPRING -> "SPRING";
            default -> "ERROR";
        };
        System.out.println(message);

    }


}
