package com.example.demo;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.model.po.Book;
import com.example.demo.rabbitmq.RabbitmqUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: 青菜
 * @Date: 2019/5/12 下午3:13
 * @Description: rabbitmq test
 * @Version 1.0
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RabbitmqTests {

    //direct //fanout //topic
    /**
     * direct 点对点模式
     * fanout 广播模式
     * topic 关键词
     */


    @Autowired
    RabbitTemplate rabbitTemplate;

    /**
     * 创建和删除  queue 和 exchagne 以及 binding  绑定规则
     */
    @Autowired
    AmqpAdmin amqpAdmin;

    /**
     * 创建一个交换机
     * @throws Exception
     */
    @Test
    public void createExchangeTest() throws Exception {
        //amqpAdmin.declareExchange(new DirectExchange("amqp.direct"));
    }

    /**
     * 创建一个队列
     * @throws Exception
     */
    @Test
    public void createQueueTest() throws Exception {
        amqpAdmin.declareQueue(new Queue("amqp.queue"));
    }

    /**
     * 将队列 和 交换机绑定
     * @throws Exception
     */
    @Test
    public void bindingExchangeQueueTest() throws Exception {
        amqpAdmin.declareBinding(new Binding("amqp.queue",Binding.DestinationType.QUEUE,"amqp.direct","amqp.tsl",null));
    }

    /**
     * 测试 direct
     * @throws Exception
     */
    @Test
    public void directTest() throws Exception {
        //rabbitTemplate.send(exchagne,routingKsy.message);
        //obj:消息体，自动序列化发送给rabbitmq（java 序列化，java 实体类必须 implements Serializable，否则会发送失败）
        //rabbitTemplate.convertAndSend(exchagne,routingkey,obj);
        JSONObject obj = new JSONObject();
        obj.put("title","direct测试");
        obj.put("value","123123133123");


        Book book = new Book("西游记", "吴承恩");

        rabbitTemplate.convertAndSend("amqp.direct","amqp.tsl",book);

    }

    /**
     * 接收数据
     * @throws Exception
     */
    @Test
    public void receive() throws Exception{
        Object o = rabbitTemplate.receiveAndConvert("tsl.news");
        System.out.println(o.getClass());
        System.out.println(o);
    }

    /**
     * 广播
     * @throws Exception
     */
    @Test
    public void fanoutTest() throws Exception {
        JSONObject obj = new JSONObject();
        obj.put("title","fanout测试");
        obj.put("value","权威破23");
        rabbitTemplate.convertAndSend("tsl.fanout","",obj);
    }



}
