package com.zhu.fte.biz.test.singleTest;

public class Singleton2 {
    private Singleton2(){}
    private static Singleton2 SINGLETON_2;

    public static Singleton2 getInstance(){
        if (SINGLETON_2 == null){
            SINGLETON_2 = new Singleton2();
        }
        return SINGLETON_2;
    }
}
