package com.zhu.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * TODO
 *
 * @author zhujiqian
 * @date 2023/2/22 20:43
 **/
public class ZookeeperLock implements Watcher {
    private int threadId;

    private ZooKeeper zk = null;
    //当前节点
    private String currPath;
    //等待前一个节点
    private String waitPath;
    //当前线程
    private String  CURREND_OF_THRESAD;
    //连接超时
    private static final int SESSION_TIMEOUT = 10000;
    //父节点
    private static final String GROUP_PATH = "/locks";
    //锁竞争的节点
    private static final String SUB_PATH = "/locks/sub";
    //zookeeper服务器地址
    private static final String CONNECTION_STRING = "127.0.0.1:2181";
    //开启测试线程
    private static final int THREAD_NUM = 10;
    //确保连接zk成功
    private CountDownLatch countDownLatch = new CountDownLatch(1);
    //测试线程
    private static final CountDownLatch semaphpre = new CountDownLatch(THREAD_NUM);

    public ZookeeperLock(int threadId) {
        this.threadId = threadId;
        CURREND_OF_THRESAD = "【第" + threadId + "个线程]";
    }

    /**
     * 创建ZK连接
     * @param connectString
     * @param sessionTimeout
     * @throws IOException
     * @throws InterruptedException
     */
    public void createConnection(String connectString, int sessionTimeout) throws IOException, InterruptedException {
        zk = new ZooKeeper(connectString, sessionTimeout, this);
        countDownLatch.await();
    }

    public void closeConnection(){
        if (this.zk != null){
            try {
                this.zk.close();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(CURREND_OF_THRESAD + "释放连接");
        }
    }



    /**
     * 创建节点
     * @param path 节点path
     * @param data 初始数据内容
     * @param
     * @return
     * @throws InterruptedException
     * @throws KeeperException
     */
    public boolean createPath(String path, String data, boolean needWatch) throws InterruptedException, KeeperException {
        if (zk.exists(path, needWatch) == null){
            System.out.println(CURREND_OF_THRESAD + "节点创建成功，Path：" + this.zk.create(path, data.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT) +", content:" + data);
        }
        return true;
    }


    /**
     * 获取锁
     * @throws InterruptedException
     * @throws KeeperException
     */
    private void getLock() throws InterruptedException, KeeperException {
        currPath = zk.create(SUB_PATH, null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        System.out.println(CURREND_OF_THRESAD + "创建锁路径：" + currPath);

    }



    /**
     * 检查自己是不是最小节点
     * @return
     * @throws InterruptedException
     * @throws KeeperException
     */
    public boolean checkMinPath() throws InterruptedException, KeeperException {
        List<String> subNodes = zk.getChildren(GROUP_PATH,false);
        //对节点进行排序
        Collections.sort(subNodes);
        int index = subNodes.indexOf(currPath.substring(GROUP_PATH.length() + 1));
        switch (index){
            case -1:{
                System.out.println(CURREND_OF_THRESAD + "本节点已不在了..." + currPath);
                return false;
            }
            case 0:{
                System.out.println(CURREND_OF_THRESAD + "子节点中，我果然是老大" + currPath);
                return true;
            }

            default:
                this.waitPath = GROUP_PATH + "/" + subNodes.get(index - 1);
                System.out.println(CURREND_OF_THRESAD + "获取子节点中，排在我前面的" + waitPath);
                try {
                    zk.getData(waitPath, true, new Stat());
                    return false;
                }catch (KeeperException e){
                    if (zk.exists(waitPath,false) == null){
                        System.out.println(CURREND_OF_THRESAD + "子节点中，排在前面的" + waitPath + "已失踪，幸福来得太突然");
                        return checkMinPath();
                    }else {
                        throw e;
                    }
                }

        }
    }

    @Override
    public void process(WatchedEvent watchedEvent) {

    }
}
