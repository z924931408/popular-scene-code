package com.zhu.fte.biz.test.ThreadTest;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class MyCallableTest implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "call()方法执行中");
        return 1;
    }

    public static void main(String[] args) {
        FutureTask<Integer> task = new FutureTask<>(new MyCallableTest());
        new Thread(task).start();
        try {
            Thread.sleep(1000);
            System.out.println("返回值为" + task.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
