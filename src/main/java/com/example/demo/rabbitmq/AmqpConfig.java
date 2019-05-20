package com.example.demo.rabbitmq;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: 青菜
 * @Date: 2019/5/13 下午3:51
 * @Description: Amqp config
 * @Version 1.0
 */
@Configuration
public class AmqpConfig {

    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }
}
