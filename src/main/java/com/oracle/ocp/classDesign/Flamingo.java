package com.oracle.ocp.classDesign;

public class Flamingo {

    private static final String SEPARADOR = "----------------";

    public static void main(String[] args) {
        var f = new Flamingo();
        f.setColor("PINK");
        f.setData(1,2);
        System.out.println(f.lenght + "-"+ f.height + "-"+ f.color);
    }

    private String color = null;

    private int height;

    private int lenght;

    public void setColor(String color) {
        this.color = color;
    }

    public void setData(int lenght, int theHeight){
        lenght = this.lenght;
        this.height = theHeight;
        this.color = "white";

    }

}
