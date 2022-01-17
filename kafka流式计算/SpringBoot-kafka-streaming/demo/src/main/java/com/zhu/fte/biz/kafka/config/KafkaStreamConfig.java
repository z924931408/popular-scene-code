package com.zhu.fte.biz.kafka.config;

import com.alibaba.fastjson.JSON;
import com.sun.org.apache.bcel.internal.generic.ARETURN;
import com.zhu.fte.biz.entity.OrderInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.utils.Bytes;
import org.apache.kafka.streams.*;
import org.apache.kafka.streams.kstream.*;
import org.apache.kafka.streams.state.WindowStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafkaStreams;
import org.springframework.kafka.support.serializer.JsonSerde;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * TODO
 *
 * @author zjq
 * @date 2022/1/16 0:00
 */
@Component
@Slf4j
@EnableKafkaStreams
public class KafkaStreamConfig {

    @Bean
    public KafkaStreams kStream(){
        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "kafka-demo");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "49.234.36.131:9092,120.77.217.245:9092");
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());

        StreamsBuilder builder = new StreamsBuilder();


        KStream<String,String> stream_order = builder.stream("kafka_stream_order");


        stream_order.map((k,v)->new KeyValue<>(k,v)).to("order_topic", Produced.with(Serdes.String(),new JsonSerde<>()));


        //过滤订单金额大于10000的数据，传输到名字为order_topic_greater_than_10000的topic
        stream_order.filter((k,v) -> {
            OrderInfo orderInfo = JSON.parseObject(v, OrderInfo.class);
            BigDecimal orderAmt = orderInfo.getOrderAmt();
            return orderAmt.compareTo(new BigDecimal(10000))>0;
        }).to("order_topic_greater_than_10000",Produced.with(Serdes.String(),new JsonSerde<>()));


        //启动kafka流
        final Topology topology = builder.build();
        KafkaStreams streams = new KafkaStreams(topology,props);
        streams.cleanUp();
        streams.start();
        return streams;
    }


}
