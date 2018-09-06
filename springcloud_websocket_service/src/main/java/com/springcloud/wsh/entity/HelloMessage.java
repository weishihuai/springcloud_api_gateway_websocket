package com.springcloud.wsh.entity;

/**
 * @Title: HelloMessage
 * @ProjectName springcloud_eureka_service_a
 * @Description: 消息实体类
 * @Author WeiShiHuai
 * @Date 2018/9/3 10:40
 */
public class HelloMessage {

    /**
     * 消息名称
     */
    private String name;

    public HelloMessage(String name) {
        this.name = name;
    }

    public HelloMessage() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
