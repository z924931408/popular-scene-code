package com.zhu.fte.biz.test.ReactorExample;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;
import java.util.Set;

public class SubReactor implements Runnable{
    final Selector selector;

    public SubReactor(Selector selector) {
        this.selector = selector;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                selector.select();
                Set<SelectionKey> keySet = selector.selectedKeys();
                Iterator<SelectionKey> it = keySet.iterator();
                while (it.hasNext()){
                    SelectionKey sk = it.next();
                    dispatch(sk);
                }
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    void dispatch(SelectionKey sk){
        Runnable handler = (Runnable) sk.attachment();
        if (handler != null){
            handler.run();
        }
    }
}
