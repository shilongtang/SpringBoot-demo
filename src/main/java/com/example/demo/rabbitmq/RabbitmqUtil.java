package com.example.demo.rabbitmq;

import com.example.demo.help.emnus.RabbitMqExchangeTypeEmun;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * @Author: 青菜
 * @Date: 2019/5/13 下午5:12
 * @Description: rabbitmq util
 * @Version 1.0
 */
@Component
public class RabbitmqUtil {

    @Autowired
    AmqpAdmin autoAmqpAdmin;

    private static AmqpAdmin amqpAdmin;

    /**
     *   @PostConstruct :依赖注入完成后被自动调用
     */
    @PostConstruct
    public void beforeInit() {
        amqpAdmin = autoAmqpAdmin;
    }


    /**
     * 创建绑定规则
     * @param destination 目标队列
     * @param exchange 交换机
     * @param routingKey 路由key
     * @param arguments 参数头信息
     */
    public static void createBinding(String destination, String exchange, String routingKey, Map<String, Object> arguments) {
        amqpAdmin.declareBinding(new Binding(destination, Binding.DestinationType.QUEUE, exchange, routingKey, arguments));
    }

    /**
     * 创建队列
     * @param name
     */
    public static void createQueue(String name){
        amqpAdmin.declareQueue(new Queue(name));
    }


    /**
     * 创建队列
     * @param name
     * @param isDurable
     */
    public static void createQueue(String name, boolean isDurable){
        amqpAdmin.declareQueue(new Queue(name,isDurable));
    }


    /**
     * 创建队列
     * @param name
     * @param isDurable
     * @param isExclusive
     * @param isAutoDelete
     */
    public static void createQueue(String name, boolean isDurable, boolean isExclusive, boolean isAutoDelete){
        amqpAdmin.declareQueue(new Queue(name,isDurable,isExclusive,isAutoDelete));
    }


    /**
     * 创建交换机
     * @param type
     * @param name
     */
    public static void createExchange(String type, String name){
        if(type.equals(RabbitMqExchangeTypeEmun.DIRECT.getType())){
            amqpAdmin.declareExchange(new DirectExchange(name));
        }

        if(type.equals(RabbitMqExchangeTypeEmun.FANOUT.getType())){
            amqpAdmin.declareExchange(new FanoutExchange(name));
        }

        if(type.equals(RabbitMqExchangeTypeEmun.TOPIC.getType())){
            amqpAdmin.declareExchange(new TopicExchange(name));
        }
    }


    /**
     * 创建交换机
     * @param type
     * @param name
     * @param isAutoDelete
     * @param isDurable
     */
    public static void createExchange(String type, String name, boolean isDurable, boolean isAutoDelete){
        if(type.equals(RabbitMqExchangeTypeEmun.DIRECT.getType())){
            amqpAdmin.declareExchange(new DirectExchange(name,isDurable,isAutoDelete));
        }

        if(type.equals(RabbitMqExchangeTypeEmun.FANOUT.getType())){
            amqpAdmin.declareExchange(new FanoutExchange(name,isDurable,isAutoDelete));
        }

        if(type.equals(RabbitMqExchangeTypeEmun.TOPIC.getType())){
            amqpAdmin.declareExchange(new TopicExchange(name,isDurable,isAutoDelete));
        }
    }

    /**
     * 创建交换机
     * @param type
     * @param name
     * @param isAutoDelete
     * @param arguments
     * @param isDurable
     */
    public static void createExchange(String type, String name, boolean isDurable, boolean isAutoDelete,  Map<String, Object> arguments){
        if(type.equals(RabbitMqExchangeTypeEmun.DIRECT.getType())){
            amqpAdmin.declareExchange(new DirectExchange(name,isDurable,isAutoDelete,arguments));
        }

        if(type.equals(RabbitMqExchangeTypeEmun.FANOUT.getType())){
            amqpAdmin.declareExchange(new FanoutExchange(name,isDurable,isAutoDelete,arguments));
        }

        if(type.equals(RabbitMqExchangeTypeEmun.TOPIC.getType())){
            amqpAdmin.declareExchange(new TopicExchange(name,isDurable,isAutoDelete,arguments));
        }
    }






}
