package com.oracle.ocp.concurrency;

import java.util.concurrent.*;

public class WaitAllTaskFinishing {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            Future<Integer> result1 = service.submit(() -> 30 + 11);
            Future<Integer> result2 = service.submit(() -> 30 + 11);
            Future<Integer> result3 = service.submit(() -> 30 + 11);
            Future<Integer> result4 = service.submit(() -> 30 + 11);
            //System.out.println(result.get());
        } finally {
            if(service!=null)
                service.shutdown();
        }

        service.awaitTermination(1, TimeUnit.MINUTES);//Esperamos 1 minutos a que trerminen las tareas
        if(service.isTerminated()){
            System.out.println("Finished");
        }else {
            System.out.println("Al menos una tarea se esta ejecutando");
        }
    }
}
