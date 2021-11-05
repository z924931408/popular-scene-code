package com.zhu.fte.biz;

import com.zhu.fte.biz.util.RedisUtil;
import javafx.application.Application;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CacheWebApplication.class)
@Slf4j
public class Test1 {


    @Resource
    RedisUtil redisUtil;


    @Test
    public void getLearn(){
        redisUtil.set("zhu","121234123");
        log.info("打印成功");
    }

}
