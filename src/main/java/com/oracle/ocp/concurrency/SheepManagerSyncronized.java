package com.oracle.ocp.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SheepManagerSyncronized {

    private int sheepCount = 0;

    private void incrementAndReport() {
        //Lo hago atomico, me aseguro que los demas hilos se bloqueen cuando entra aqui
        synchronized (this){ //ASEGURAMOS NO REPETIDO Y ORDENADO
            System.out.print((++sheepCount)+" ");
        }
    }
    public static void main(String[] args) {
        //COLOCA EL NUMERO DE HILOS
        ExecutorService service = Executors.newFixedThreadPool(20);
        try {
            SheepManagerSyncronized manager = new SheepManagerSyncronized();
            for (int i = 0; i < 10; i++)
                service.submit(() -> manager.incrementAndReport());
        } finally {
            service.shutdown();
        }
    }
}
