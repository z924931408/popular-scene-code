package com.zhu.fte.biz.test.ThreadTest;

import io.swagger.models.auth.In;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        int a = Integer.parseInt("itheima");
        System.out.println(a);
    }

    public static void main(String[] args) {
        MyRunnable mr = new MyRunnable();
        Thread t1 = new Thread(mr);
        t1.setUncaughtExceptionHandler(new ThreadExceptionHandler());
        t1.start();
    }
}

class ThreadExceptionHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println(t.getId()+"---"+t.getState());
        e.printStackTrace();
    }
}
