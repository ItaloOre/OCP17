package com.oracle.ocp.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class SheepManagerConAtomic {

    //COMO ATOMIC GARANTIZAMOS QUE NO HAY REPETIDOS, PERO EL ORDEN NO ES GARANTIZADO
    private AtomicInteger sheepCount = new AtomicInteger(0);
    private void incrementAndReport() {
        System.out.print(sheepCount.incrementAndGet()+" ");
    }
    public static void main(String[] args) {
        //COLOCA EL NUMERO DE HILOS
        ExecutorService service = Executors.newFixedThreadPool(20);
        try {
            SheepManagerConAtomic manager = new SheepManagerConAtomic();
            for (int i = 0; i < 10; i++)
                service.submit(() -> manager.incrementAndReport());
        } finally {
            service.shutdown();
        }
    }
}
