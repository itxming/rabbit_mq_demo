package com.example.rabbit_mq.controller;

import com.example.rabbit_mq.direct.DirectSender;
import com.example.rabbit_mq.fanout.FanoutSender;
import com.example.rabbit_mq.simple.SimpleSender;
import com.example.rabbit_mq.topic.TopicSender;
import com.example.rabbit_mq.work.WorkSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName RabbitController
 * @Description: TODO
 * @Author ad
 * @Date 2020/6/12
 * @creed: If you can NOT explain it simply, you do NOT understand it well enough
 * @Version V1.0
 **/
@RestController
public class RabbitController {

    @Autowired
    private SimpleSender simpleSender;

    @Autowired
    private WorkSender workSender;

    @Autowired
    private FanoutSender fanoutSender;

    @Autowired
    private DirectSender directSender;
    
    @Autowired
    private TopicSender topicSender;


    /**
     * 简单模式
     *
     * @param
     * @Description: TODO
     * @return: java.lang.String
     * @author: ad
     * @creed: If you can NOT explain it simply, you do NOT understand it well enough
     * @date: 2020.06.12
     */
    @GetMapping("/rabbit/simple")
    public String simpleTest() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            simpleSender.send();
            Thread.sleep(1000);
        }
        return "成功";
    }


   /**
    * 工作模式
    * @Description: TODO
    * @param 
    * @return: java.lang.String
    * @author: ad
    * @creed: If you can NOT explain it simply, you do NOT understand it well enough
    * @date: 2020.06.12
    */
    @GetMapping("/rabbit/work")
    public String workTest() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            workSender.send(i);
            Thread.sleep(1000);
        }
        return "成功";
    }

   /**
    * 发布订阅模式
    * @Description: TODO
    * @param 
    * @return: java.lang.String
    * @author: ad
    * @creed: If you can NOT explain it simply, you do NOT understand it well enough
    * @date: 2020.06.12
    */
    @GetMapping("/rabbit/fanout")
    public String fanoutTest() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            fanoutSender.send(i);
            Thread.sleep(1000);
        }
        return "成功";
    }

   /**
    * 路由模式
    * @Description: TODO
    * @param 
    * @return: java.lang.String
    * @author: ad
    * @creed: If you can NOT explain it simply, you do NOT understand it well enough
    * @date: 2020.06.12
    */
    @GetMapping("/rabbit/direct")
    public String directTest() throws InterruptedException {
        for(int i=0;i<10;i++){
            directSender.send(i);
            Thread.sleep(1000);
        }
        return "成功";
    }


    /**
     * 通配符模式
     * @Description: TODO
     * @param 
     * @return: java.lang.String
     * @author: ad
     * @creed: If you can NOT explain it simply, you do NOT understand it well enough
     * @date: 2020.06.12
     */
    @GetMapping("/rabbit/topic")
    public String topicTest() throws InterruptedException {
        for(int i=0;i<10;i++){
            topicSender.send(i);
            Thread.sleep(1000);
        }
        return "成功";
    }



}
