package com.zhu.fte.biz.test.proxy;

public class Proxy implements Logger{
    Logger logger;

    public Proxy() {
        this.logger = new LoggerSubject();
    }

    @Override
    public void writeLog() {
        System.out.println("logger write before");
        logger.writeLog();
        System.out.println("logger write after");
    }
}


