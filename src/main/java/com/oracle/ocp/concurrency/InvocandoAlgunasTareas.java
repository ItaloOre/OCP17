package com.oracle.ocp.concurrency;

import java.util.List;
import java.util.concurrent.*;

public class InvocandoAlgunasTareas {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            Callable<Integer> task = () -> (int) (30 + (10 * Math.random()));
            System.out.println("Begin");
            Integer data = service.invokeAny(List.of(task,task,task,task,task));

            System.out.println("End");
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
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
