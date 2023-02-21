package com.zhu.fte.biz.test.singleTest;

public class Singleton3 {
    private Singleton3(){}
    private static volatile Singleton3 SINGLETON_3;
    public static Singleton3 getInstance(){
        if (SINGLETON_3 == null){
            synchronized (Singleton3.class){
                if (SINGLETON_3 == null){
                    SINGLETON_3 = new Singleton3();
                }
            }
        }
        return SINGLETON_3;
    }
}
