package com.zhu.fte.biz.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author zjq
 * @date 2022/1/16 0:41
 */
@Component
public class KafkaStreamListener {
    @KafkaListener(topics = "order_topic_greater_than_10000")
    public void onMessage1(String message) {
        // 处理
        System.out.println("stream_test处理之后的"+message);
    }

    @KafkaListener(topics = "kafka_stream_test")
    public void onMessage2(String message) {
        System.out.println("kafka_stream_test处理之前的"+message);
    }
}
