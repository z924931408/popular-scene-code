package com.zhu.fte.biz.test.ThreadTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnableTest implements Runnable{
    @Override
    public void run() {
        System.out.println("测试这是一个Runnable");
    }

    public static void main(String[] args) {
      ExecutorService executorService = Executors.newSingleThreadExecutor();
      for (int i = 0; i <= 5; i++){
          executorService.execute(new RunnableTest());
      }
    }
}
