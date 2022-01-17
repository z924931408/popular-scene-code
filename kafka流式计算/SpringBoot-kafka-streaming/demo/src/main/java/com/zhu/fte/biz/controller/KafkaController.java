package com.zhu.fte.biz.controller;

import com.zhu.fte.biz.entity.OrderInfo;
import com.zhu.fte.biz.kafka.KafkaProducer;
import io.swagger.annotations.Api;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.UUID;

/**
 * TODO
 *
 * @author zjq
 * @date 2022/1/15 19:32
 */

@RestController
@RequestMapping("/kafka")
@Api()
public class KafkaController {


    @Resource
    private KafkaProducer kafkaProducer;

    @GetMapping("/sendKafka")
    public void sendMsg(){
        for(int i = 0; i < 100; i++){
            OrderInfo orderInfo = new OrderInfo();
            orderInfo.setId((long) i);
            orderInfo.setOrderNo(UUID.randomUUID().toString());
            orderInfo.setOrderTime(System.currentTimeMillis());
            orderInfo.setUserId("王五"+i);
            orderInfo.setOrderAmt(new BigDecimal(Math.random()*20000+1));
            kafkaProducer.send(orderInfo);

        }
    }

}
