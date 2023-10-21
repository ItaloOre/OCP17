package com.oracle.ocp.concurrency.test;


import java.util.concurrent.locks.*;
        import java.util.stream.*;

public class BookQ2 {
    private Lock vault = new ReentrantLock();
    private int total = 0;

    public void deposit(int value) {
        try {
            vault.tryLock();//CUADO CON ESTO, SI ES FALSE PUEDE DAR UN RUNTIME
            total += value;
        } finally {
            vault.unlock();
        }
    }

    public static void main(String[] unused) {
        var bank = new BookQ2();
        IntStream.range(1, 10).parallel()
                .forEach(s -> bank.deposit(s));
        System.out.println(bank.total);
    }
}