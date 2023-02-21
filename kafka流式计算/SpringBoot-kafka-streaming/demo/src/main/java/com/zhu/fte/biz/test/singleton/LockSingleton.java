package com.zhu.fte.biz.test.singleton;

public class LockSingleton {

    private volatile LockSingleton SINGLETON;

    private LockSingleton(){}

    public LockSingleton getSINGLETON(){
        if(SINGLETON == null){
            synchronized (LockSingleton.class){
                if(SINGLETON == null){
                    SINGLETON = new LockSingleton();
                }
            }
        }
        return SINGLETON;
    }
}
