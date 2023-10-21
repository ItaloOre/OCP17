package com.oracle.ocp.collectionsAndGenerics;

import java.util.List;

public class Generico2 {

    private void anyFlyer(List<Flyer> flyer){}

    private void groupOfFlyers(List<? extends Flyer> flyers){}


}

interface Flyer {void fly();}

class HangGlider implements Flyer{
    public void fly(){}
}

class Goose implements Flyer{
    public void fly(){};
}

