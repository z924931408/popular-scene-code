package com.zhu.fte.biz.test.singleTest;

import java.io.Serializable;

public class Singleton5 implements Serializable {
    private static final long serialVersionUID = -2675976638179016828L;
    private Singleton5(){

    }
    private static Singleton5 SINGLETON4;

    public static Singleton5 getInstance(){
        return SingletonHander.instance.singleton5;
    }

    private enum SingletonHander{
        instance;
        private final Singleton5 singleton5;
        SingletonHander(){
            singleton5 = new Singleton5();
        }
    }

}
