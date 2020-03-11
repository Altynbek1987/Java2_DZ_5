package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class PassengerThread extends Thread {
    Semaphore semaphore;
    CountDownLatch countDownLatch;
    int passenger;
    int num = 0;

    public PassengerThread(Semaphore semaphore,CountDownLatch countDownLatch, int passenger) {
        this.semaphore = semaphore;
        this.countDownLatch = countDownLatch;
        this.passenger = passenger;
    }
    @Override
    public void run() {
        try {
            while (num < 1) {
                semaphore.acquire();
                System.out.println("Пасажир " + passenger + " Заходит в кассу");
                sleep(0);
                num++;
                System.out.println("Пасажир " + passenger + " Выходит из кассы");
                semaphore.release();
                sleep(0);
                System.out.println("Пасажир " + passenger + " Занял место в автобусе");
                countDownLatch.countDown();
            }
        } catch (InterruptedException a) {
            System.out.println("у пасажира " + passenger + " нет денег");

        }
    }
}
