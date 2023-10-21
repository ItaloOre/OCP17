package com.oracle.ocp.beyondClasses;

public interface Robot { // ES ABSTRACT DE MANERA IMPLICITO

    double PI = 3.1416;//ES STATIC FINAL DE MANERA IMPLICITO

    void on();// OJO ES PUBLICO y abstracto DE MANERA IMPLICITO
    void of();

    default double getTemperature(){//ES OPCIONAL SU IMPLEMENTACION
        return 10.0;
    }
}

interface Machine{
    default double getTemperature(){//ES OBLIGATORIO SI TIENES 2 DEFOUT CON LA MISMA FIRMA
        return 15.0;
    }
    default double getTemperature2(){//ES OBLIGATORIO SI TIENES 2 DEFOUT CON LA MISMA FIRMA
        return getHotTemperature();
    }

    private static int getHotTemperature(){
        //getTemperature2(); UN STATIC NO PUEDE LLAMAR UN DEFOULRT
        return 999;
    }

     static int getCoolTemperature(){
         getHotTemperature();//puedo llamar a un static pero no a un defult desde uin  static
        return -99;
    }
}

class OriginalRobot implements Robot,Machine{

    @Override
    public void on() {
        System.out.println("ON");
    }
    @Override
    public void of() {
        System.out.println("OF");
    }

    @Override//ES OBLIGATORIO SI TIENES 2 DEFOUT CON LA MISMA FIRMA
    public double getTemperature() {
        on();
        return Robot.super.getTemperature();
    }

    public static void main(String[] args) {
        var c = new OriginalRobot();
        c.getTemperature();
        //Machine.getHotTemperature();
    }


}
