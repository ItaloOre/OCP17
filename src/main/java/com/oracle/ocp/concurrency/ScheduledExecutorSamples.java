package com.oracle.ocp.concurrency;

import java.util.concurrent.*;

public class ScheduledExecutorSamples {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        Runnable task1 = () -> System.out.println("Hello Zoo");
        Callable<String> task2 = () -> "Monkey";

        //Funciona si hay hilos disponibles
        //ScheduledFuture<? > r1 = service.schedule(task1, 10, TimeUnit.SECONDS);
        //ScheduledFuture<?> r2 = service.schedule(task2, 8, TimeUnit.MINUTES);
        //System.out.println(r1.get());
        // System.out.println(r2.get());

        //scheduleAtFixedRate DEJA QUE SE CRUCEN LAS EJECUCIONES
        ScheduledFuture<String> r1 = (ScheduledFuture<String>) service.
                scheduleAtFixedRate(() -> System.out.println("Peru"),1,5,TimeUnit.SECONDS);

        //scheduleWithFixedDelay NUNCA DEJA QUE SE CRUCEN LAS EJECUCIONES
        ScheduledFuture<String> r2 = (ScheduledFuture<String>) service.
                scheduleWithFixedDelay(() -> System.out.println("Peru"),1,5,TimeUnit.SECONDS);


    }
}
