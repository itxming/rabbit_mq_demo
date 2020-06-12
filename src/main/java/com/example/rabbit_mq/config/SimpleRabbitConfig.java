package com.example.rabbit_mq.config;

import com.example.rabbit_mq.simple.SimpleReceiver;
import com.example.rabbit_mq.simple.SimpleSender;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName SimpleRabbitConfig
 * @Description: 简单模式
 * @Author ad
 * @Date 2020/6/12
 * @creed: If you can NOT explain it simply, you do NOT understand it well enough
 * 简单模式是最简单的消息模式，它包含一个生产者、一个消费者和一个队列。生产者向队列里发送消息，消费者从队列中获取消息并消费。
 * @Version V1.0
 **/
@Configuration
public class SimpleRabbitConfig {

    /**
     * 队列
     * @Description: TODO
     * @param 
     * @return: org.springframework.amqp.core.Queue
     * @author: ad
     * @creed: If you can NOT explain it simply, you do NOT understand it well enough
     * @date: 2020.06.12
     */
    @Bean
    public Queue hello() {
        return new Queue("simple.hello");
    }

    /**
     * 生产者
     * @Description: TODO
     * @param 
     * @return: com.example.rabbit_mq.simple.SimpleSender
     * @author: ad
     * @creed: If you can NOT explain it simply, you do NOT understand it well enough
     * @date: 2020.06.12
     */
    @Bean
    public SimpleSender simpleSender(){
        return new SimpleSender();
    }

    /**
     * 消费者
     * @Description: TODO
     * @param 
     * @return: com.example.rabbit_mq.simple.SimpleReceiver
     * @author: ad
     * @creed: If you can NOT explain it simply, you do NOT understand it well enough
     * @date: 2020.06.12
     */
    @Bean
    public SimpleReceiver simpleReceiver(){
        return new SimpleReceiver();
    }

}
