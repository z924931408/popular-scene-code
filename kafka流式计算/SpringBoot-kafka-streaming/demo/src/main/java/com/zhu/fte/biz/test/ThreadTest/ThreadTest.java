package com.zhu.fte.biz.test.ThreadTest;

import java.util.concurrent.*;

public class ThreadTest implements Callable<String> {
    @Override
    public String call() throws Exception {
        for (int i = 0; i < 10; i++){
            System.out.println("不要彩礼好吗" + i);
        }
        return "好的";
    }
}

class MCallable{
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2,5,2, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());
        Future future1 = poolExecutor.submit(new ThreadTest());
        Future future2 = poolExecutor.submit(new ThreadTest());
        System.out.println(future1.get());
        System.out.println(future2.get());
        poolExecutor.shutdown();
    }
}
