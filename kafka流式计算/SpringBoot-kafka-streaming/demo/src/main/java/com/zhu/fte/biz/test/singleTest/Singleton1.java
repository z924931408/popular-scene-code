package com.zhu.fte.biz.test.singleTest;

public class Singleton1 {
    private Singleton1(){}
    private static final Singleton1 SINGLETON_1 = new Singleton1();
    public static Singleton1 getSingleton1(){
        return SINGLETON_1;
    }
}
