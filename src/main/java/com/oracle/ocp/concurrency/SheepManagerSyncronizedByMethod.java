package com.oracle.ocp.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SheepManagerSyncronizedByMethod {

    private int sheepCount = 0;

    private synchronized void incrementAndReport() { //ASEGURAMOS NO REPETIDO Y ORDENADO
        //Lo hago atomico, me aseguro que los demas hilos se bloqueen cuando entra aqui
            System.out.print((++sheepCount)+" ");

    }
    public static void main(String[] args) {
        //COLOCA EL NUMERO DE HILOS
        ExecutorService service = Executors.newFixedThreadPool(20);
        try {
            SheepManagerSyncronizedByMethod manager = new SheepManagerSyncronizedByMethod();
            for (int i = 0; i < 10; i++)
                service.submit(() -> manager.incrementAndReport());
        } finally {
            service.shutdown();
        }
    }
}
