package com.springcloud.wsh;

import com.springcloud.wsh.entity.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
//@EnableEurekaClient 表示注册一个服务到Eureka上，成为Eureka的一个客户端
@EnableEurekaClient
//开启定时器功能
@EnableScheduling
public class SpringcloudWebsocketServiceApplication {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudWebsocketServiceApplication.class, args);
    }

    @Scheduled(fixedDelay = 1000L)
    public void time() {
        Greeting greeting = new Greeting(new Date().toString());
        messagingTemplate.convertAndSend("/topic/time", greeting);
    }

    @Scheduled(cron = "0/3 * * * * *")
    public void messageTip() {
        //实时消息
        Greeting greeting = new Greeting("正在识别....." + UUID.randomUUID().toString());
        messagingTemplate.convertAndSend("/topic/message", greeting);
    }

}
