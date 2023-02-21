package com.zhu.fte.biz.test.ThreadTest;



public class SynchronizedTest {
    private final static Object object1 = new Object();
    private final static Object object2 = new Object();

    public static void main(String[] args) {
        new Thread(()->{
            synchronized (object1){
                System.out.println("thread1 get resource object1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (object2){
                    System.out.println("thread1 get resource object2");
                }
            }

        }).start();

        new Thread(()->{
            synchronized (object2){
                System.out.println("thread1 get resource object1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (object1){
                    System.out.println("thread1 get resource object2");
                }
            }


        }).start();
    }
}
