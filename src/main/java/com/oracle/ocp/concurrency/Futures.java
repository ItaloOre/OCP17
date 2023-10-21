package com.oracle.ocp.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Futures {

    public static void main(String[] args) {

        ExecutorService service = null;


        try{
            service = Executors.newSingleThreadExecutor();
            Future<?> futureHello = service.submit(() -> System.out.println("Future hello"));

            System.out.println(futureHello.isDone());
            System.out.println(futureHello.isCancelled());
            //futureHello.isDone();
            //futureHello.isCancelled();

        } finally {
            if(service != null)
                service.shutdown();
        }
    }

}
