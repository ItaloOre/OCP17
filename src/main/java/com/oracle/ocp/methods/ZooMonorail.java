package com.oracle.ocp.methods;

import java.io.IOException;

public class ZooMonorail {

    public void oneException() throws IOException {}

    public void play(){
        try{
            oneException();
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public void play2() throws IOException {//ducking exception
        oneException();
    }

    public void  twoException() throws IllegalArgumentException{}
    public void roar(){
        twoException();
    }
}
