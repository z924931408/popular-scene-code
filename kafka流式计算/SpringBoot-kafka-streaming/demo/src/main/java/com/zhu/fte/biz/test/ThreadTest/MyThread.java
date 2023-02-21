package com.zhu.fte.biz.test.ThreadTest;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws Exception {
        for (int i = 0; i < 10; i++){
            System.out.println("不要彩礼" + i);
        }
        return "好的";
    }
}

class MyCallable{
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThread myThread = new MyThread();
        FutureTask<String> ft = new FutureTask<>(myThread);
        Thread t1 = new Thread(ft);
        t1.start();
        System.out.println(ft.get());
    }
}
