package com.example.rabbit_mq.config;


import com.example.rabbit_mq.fanout.FanoutReceiver;
import com.example.rabbit_mq.fanout.FanoutSender;
import org.springframework.amqp.core.AnonymousQueue;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName FanoutRabbitConfig
 * @Description: 发布/订阅模式
 * @Author ad
 * @Date 2020/6/12
 * @creed: If you can NOT explain it simply, you do NOT understand it well enough
 * 发布/订阅模式是指同时向多个消费者发送消息的模式（类似广播的形式），它包含一个生产者、两个消费者、两个队列和一个交换机。
 * 两个消费者同时绑定到不同的队列上去，两个队列绑定到交换机上去，生产者通过发送消息到交换机，所有消费者接收并消费消息。
 * @Version V1.0
 **/
@Configuration
public class FanoutRabbitConfig {

    /**
     * 交换机
     * @return
     */
    @Bean
    public FanoutExchange fanout() {
        return new FanoutExchange("exchange.fanout");
    }

    /**
     * 匿名队列1
     * @return
     */
    @Bean
    public Queue fanoutQueue1() {
        return new AnonymousQueue();
    }

    /**
     * 匿名队列2
     * @return
     */
    @Bean
    public Queue fanoutQueue2() {
        return new AnonymousQueue();
    }

    /**
     * 队列绑定交换机
     * @param fanout
     * @param fanoutQueue1
     * @return
     */
    @Bean
    public Binding fanoutBinding1(FanoutExchange fanout, Queue fanoutQueue1) {
        return BindingBuilder.bind(fanoutQueue1).to(fanout);
    }

    /**
     * 队列绑定交换机
     * @param fanout
     * @param fanoutQueue2
     * @return
     */
    @Bean
    public Binding fanoutBinding2(FanoutExchange fanout, Queue fanoutQueue2) {
        return BindingBuilder.bind(fanoutQueue2).to(fanout);
    }

    /**
     * 消费者
     * @return
     */
    @Bean
    public FanoutReceiver fanoutReceiver() {
        return new FanoutReceiver();
    }

    @Bean
    public FanoutSender fanoutSender() {
        return new FanoutSender();
    }

}
