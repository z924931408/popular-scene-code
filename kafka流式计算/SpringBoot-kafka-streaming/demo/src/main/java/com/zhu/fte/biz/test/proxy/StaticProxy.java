package com.zhu.fte.biz.test.proxy;

public class StaticProxy {
    private static void write(Logger logger){
        logger.writeLog();
    }

    public static void main(String[] args) {
        Logger logger = new Proxy();
        write(logger);
    }
}
