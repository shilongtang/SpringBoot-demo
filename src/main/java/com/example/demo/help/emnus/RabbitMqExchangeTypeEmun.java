package com.example.demo.help.emnus;

/**
 * @Author: 青菜
 * @Date: 2019/5/13 下午5:44
 * @Description: rabbitmq 交换机类型枚举
 * @Version 1.0
 */
public enum RabbitMqExchangeTypeEmun {

    /** direct */
    DIRECT("direct","单播"),
    /** fanout */
    FANOUT("fanout","广播"),
    /** topic */
    TOPIC("topic","关键词");

    private String type;

    private String desc;

    RabbitMqExchangeTypeEmun(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}
