package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(4);
        CountDownLatch countDownLatch = new CountDownLatch(100);
        for (int i = 1; i <= 100; i++) {
            new PassengerThread(semaphore, countDownLatch, i).start();
        }
        try {
            countDownLatch.await();
            System.out.println(" Автобус полный ");
        } catch (InterruptedException e) {
            

        }
    }
}
