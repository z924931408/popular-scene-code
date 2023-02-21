package com.zhu.fte.biz.test.ThreadTest;

public class Thread1 extends Thread{
    @Override
    public void run() {
        System.out.println("测试一个线程");
    }

    public static void main(String[] args) {
        Thread thread = new Thread1();
        thread.start();
    }
}
