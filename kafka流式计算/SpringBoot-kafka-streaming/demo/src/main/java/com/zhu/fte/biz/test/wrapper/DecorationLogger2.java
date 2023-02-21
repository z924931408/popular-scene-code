package com.zhu.fte.biz.test.wrapper;

public class DecorationLogger2 implements Logger{
    private Logger logger;

    public DecorationLogger2(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void writeLog() {
        logger.writeLog();
        System.out.println("Decoration2");
    }
}
