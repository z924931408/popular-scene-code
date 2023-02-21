package com.zhu.fte.biz.test.wrapper;

public class BaseLogger implements Logger{
    @Override
    public void writeLog() {
        System.out.println("writeLog");
    }
}
