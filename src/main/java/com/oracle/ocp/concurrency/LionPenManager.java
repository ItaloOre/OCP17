package com.oracle.ocp.concurrency;

import java.util.concurrent.*;
public class LionPenManager {
    private void removeLions() { System.out.println("Removing lions"); }
    private void cleanPen() { System.out.println("Cleaning the pen"); }
    private void addLions() { System.out.println("Adding lions"); }


    public void performTask(CyclicBarrier c1, CyclicBarrier c2) {

        try {
            removeLions();//AQUI ESPERA LOS 4
            c1.await();
            cleanPen();//YA NO PODEMOS REUTILIZARLO
            c2.await();
            addLions();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        var service = Executors.newFixedThreadPool(4);
        try {
            var manager = new LionPenManager();
            var c1 = new CyclicBarrier(4);//Coherente con la cantidad de hilos
            var c2 = new CyclicBarrier(4);
            for (int i = 0; i < 4; i++)
                service.submit(() -> manager.performTask(c1,c2));
        } finally {
            service.shutdown();
        }
    }
}