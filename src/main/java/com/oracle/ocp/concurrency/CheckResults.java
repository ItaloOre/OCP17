package com.oracle.ocp.concurrency;

/**
 * @author Italo Oré
 *
 * Chapter 13 Concurrency
 *
 * Polling with Sleep
 */
public class CheckResults {

    private static int counter = 0;
    public static void main(String[] args) {
        new Thread(() -> {
            for(int i = 0; i < 1_000_000; i++) counter++;
        }).start();
        while(counter < 1_000_000) {
            //System.out.println("Not reached yet");
            System.out.println("Not reached yet");
            try {
                Thread.sleep(1_000); // 1 SECOND
            } catch (InterruptedException e) {
                System.out.println("Interrupted!");
            }
        }
        System.out.println("Reached: "+ counter);
    }
}