package com.zhu.fte.biz.test.ThreadTest;

import com.baomidou.mybatisplus.extension.api.R;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class CarThreadRunnable implements Runnable{
    private Semaphore semaphore = new Semaphore(2);

    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + "----->>正在经过十字路口");

            Random random = new Random();
            int nextInt = random.nextInt(7);
            TimeUnit.SECONDS.sleep(nextInt);
            System.out.println(Thread.currentThread().getName() + "------>>驶出十字路口");
            semaphore.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
//        CarThreadRunnable carThreadRunnable = new CarThreadRunnable();
//        for (int i = 0; i < 5; i++){
//            new Thread(carThreadRunnable).start();
//        }

        System.out.println(Runtime.getRuntime().freeMemory());
        System.out.println(Runtime.getRuntime().totalMemory());
    }
}
