package com.example.rabbit_mq.simple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName SimpleSender
 * @Description: 生产者
 * @Author ad
 * @Date 2020/6/12
 * @creed: If you can NOT explain it simply, you do NOT understand it well enough
 * @Version V1.0
 **/
public class SimpleSender {
    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleSender.class);

    @Autowired
    private RabbitTemplate template;

    private static final String queueName = "simple.hello";

    public void send() {
        String message = "Hello World!";
        this.template.convertAndSend(queueName, message);
        LOGGER.info(" [x] 生产消息 '{}'", message);
    }
}
