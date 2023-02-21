package com.zhu.fte.biz.test.wrapper;

public class DecorationLogger implements Logger{

    private Logger logger;

    public DecorationLogger(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void writeLog() {
        logger.writeLog();
        System.out.println("Decoration");
    }
}
