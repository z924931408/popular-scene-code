package com.zhu.fte.biz.test.ReactorExample;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.atomic.AtomicInteger;

public class MultiThreadEchoServerReactor {

    ServerSocketChannel serverSocketChannel;

    AtomicInteger next = new AtomicInteger(0);

    Selector[] selectors = new Selector[2];

    SubReactor[] subReactors = null;

    public MultiThreadEchoServerReactor() throws IOException {
        selectors[0] = Selector.open();
        selectors[1] = Selector.open();
        serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress address = new InetSocketAddress(8088);
        serverSocketChannel.socket().bind(address);
        serverSocketChannel.configureBlocking(false);
        SelectionKey sk = serverSocketChannel.register(selectors[0],SelectionKey.OP_ACCEPT);
        sk.attach(new AcceptorHandler());
        SubReactor subReactor1 = new SubReactor(selectors[0]);
        SubReactor subReactor2 = new SubReactor(selectors[1]);
        subReactors = new SubReactor[]{subReactor1,subReactor2};
    }

    private void startService(){
        new Thread(subReactors[0]).start();
        new Thread(subReactors[1]).start();
    }



     class AcceptorHandler implements Runnable{

        @Override
        public void run() {
            try {
                SocketChannel channel = serverSocketChannel.accept();
                if (channel != null){
//                    new MultiThreadEchoHandler(selectors[next.get()],channel);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (next.incrementAndGet() == selectors.length){
                next.set(0);
            }
        }
    }
}
