package com.zhu.fte.biz.test.singleTest;

public class Singleton4 {
    private Singleton4(){}
    private static Singleton4 singleton4;
    private static Singleton4 getInstance(){
        return SingletonHandler.singleton;
    }
    private static class SingletonHandler{
        private static final Singleton4 singleton = new Singleton4();
    }
}
