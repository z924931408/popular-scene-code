package com.zhu.fte.biz.test.proxy;

public class LoggerSubject implements Logger{
    @Override
    public void writeLog() {
        System.out.println("writeLog by LoggerSubject");
    }
}
