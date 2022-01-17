//package com.zhu.fte.biz.kafka;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.zhu.fte.biz.entity.OrderInfo;
//import org.apache.kafka.common.serialization.Serdes;
//import org.apache.kafka.streams.*;
//import org.apache.kafka.streams.kstream.KStream;
//import org.apache.kafka.streams.kstream.Produced;
//import org.springframework.kafka.support.serializer.JsonSerde;
//
//import java.math.BigDecimal;
//import java.util.Properties;
//
///**
// * TODO
// *
// * @author zjq
// * @date 2022/1/16 16:43
// */
//public class Pipe {
//
//    public static void main(String[] args) throws Exception {
//        Properties props = new Properties();
//        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "kafka-demo");
//        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "49.234.36.131:9092,120.77.217.245:9092");
//        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
//        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());
//
//         StreamsBuilder builder = new StreamsBuilder();
//
//        KStream<String,String> stream = builder.stream("Stream5");
//        stream.map((k,v)->new KeyValue<>(k,v)).to("tableTopic", Produced.with(Serdes.String(),new JsonSerde<>()));
//        stream.filter((k,v) -> {
//            OrderInfo orderInfo = JSON.parseObject(v, OrderInfo.class);
//            BigDecimal orderAmt = orderInfo.getOrderAmt();
//            return orderAmt.compareTo(new BigDecimal(10))<0;
//        }).to("order_topic",Produced.with(Serdes.String(),new JsonSerde<>()));
//        System.out.println("处理完成");
//        final Topology topology = builder.build();
//        KafkaStreams streams = new KafkaStreams(topology,props);
//        streams.cleanUp();
//        streams.start();
//    }
//}
