package com.zhu.fte.biz.test.singleton;

public class LazzySingleton {
    private LazzySingleton(){}
    private static final LazzySingleton lazzy = new LazzySingleton();
    public LazzySingleton getSingleTon(){
        return lazzy;
    }
}
