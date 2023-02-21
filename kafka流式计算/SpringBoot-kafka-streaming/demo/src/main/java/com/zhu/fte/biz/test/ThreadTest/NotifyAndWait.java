package com.zhu.fte.biz.test.ThreadTest;

public class NotifyAndWait {
    private static Object object = new Object();
    private static int i = 0;

    public static void main(String[] args) {
        new Thread(()->{
            while (true){
                System.out.println("进入奇数线程");
                synchronized (object){
                    if (i % 2 == 1){
                        System.out.println("奇数线程" + i++);

                        try {
                            System.out.println("奇数线程notify");
                            object.notify();
                            System.out.println("奇数线程wait");
                            object.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }else {
                        System.out.println("奇数线程wait");
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }).start();

        new Thread(()->{
            while (true){
                System.out.println("进入偶数线程");
                synchronized (object){
                    if (i % 2 == 0){
                        System.out.println("偶数线程" + i++);
                        try {
                            System.out.println("偶数线程notify");
                            object.notify();
                            System.out.println("偶数线程wait");
                            object.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
                if (i == 100){
                    System.out.println(i);
                    break;
                }
            }
        }).start();
    }
}
