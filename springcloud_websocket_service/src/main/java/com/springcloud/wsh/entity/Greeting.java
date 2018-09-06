package com.springcloud.wsh.entity;

/**
 * @Title: Greeting
 * @ProjectName springcloud_eureka_service_a
 * @Description: 问候实体类
 * @Author WeiShiHuai
 * @Date 2018/9/3 10:41
 */
public class Greeting {

    /**
     * 问候内容
     */
    private String content;

    public Greeting() {

    }

    public Greeting(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
