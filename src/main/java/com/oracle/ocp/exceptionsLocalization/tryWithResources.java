package com.oracle.ocp.exceptionsLocalization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class tryWithResources {

    public void readFile(String file) {
        // se cierran en orden inverso al que son declarador.
        try(var is = new FileInputStream("hola.txt");
            var out = new FileOutputStream("adios.txt")) {//Se cierra automaticamente porque tiene closeable
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

class MyFileClass implements AutoCloseable{

    private final int num;

    MyFileClass(int num) {
        this.num = num;
    }
    @Override
    public void close() throws Exception {
        System.out.println("Clousing=" + num);
    }
}
