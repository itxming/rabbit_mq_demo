package com.example.rabbit_mq.config;

import com.example.rabbit_mq.work.WorkReceiver;
import com.example.rabbit_mq.work.WorkSender;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName WorkRabbitConfig
 * @Description: 工作模式
 * @Author ad
 * @Date 2020/6/12
 * @creed: If you can NOT explain it simply, you do NOT understand it well enough
 * @Version V1.0
 **/
@Configuration
public class WorkRabbitConfig {

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
    public Queue workQueue() {
        return new Queue("work.hello");
    }

    /**
     * 消费者
     * @Description: TODO
     * @param 
     * @return: com.example.rabbit_mq.work.WorkReceiver
     * @author: ad
     * @creed: If you can NOT explain it simply, you do NOT understand it well enough
     * @date: 2020.06.12
     */
    @Bean
    public WorkReceiver workReceiver1() {
        return new WorkReceiver(1);
    }

    /**
     * 消费者
     * @Description: TODO
     * @param 
     * @return: com.example.rabbit_mq.work.WorkReceiver
     * @author: ad
     * @creed: If you can NOT explain it simply, you do NOT understand it well enough
     * @date: 2020.06.12
     */
    @Bean
    public WorkReceiver workReceiver2() {
        return new WorkReceiver(2);
    }

    /**
     * 生产者
     * @Description: TODO
     * @param 
     * @return: WorkSender
     * @author: ad
     * @creed: If you can NOT explain it simply, you do NOT understand it well enough
     * @date: 2020.06.12
     */
    @Bean
    public WorkSender workSender() {
        return new WorkSender();
    }

}
