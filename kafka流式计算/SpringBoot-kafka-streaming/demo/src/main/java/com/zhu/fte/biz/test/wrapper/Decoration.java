package com.zhu.fte.biz.test.wrapper;

public class Decoration {
    public static void main(String[] args) {
        Logger logger = new DecorationLogger2(new DecorationLogger(new BaseLogger()));
        logger.writeLog();
    }
}
