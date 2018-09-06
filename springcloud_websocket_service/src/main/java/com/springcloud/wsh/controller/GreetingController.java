package com.springcloud.wsh.controller;

import com.springcloud.wsh.entity.Greeting;
import com.springcloud.wsh.entity.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title: GreetingController
 * @ProjectName springcloud_eureka_service_a
 * @Description:
 * @Author WeiShiHuai
 * @Date 2018/9/3 11:12
 */
@RestController
public class GreetingController {

    /**
     * 表示服务端可以接收客户端通过主题“/app/hello”发送过来的消息，客户端需要在主题"/topic/hello"上监听并接收服务端发回的消息
     *
     * @param helloMessage
     * @return
     */
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage helloMessage) {
        return new Greeting("你好，通信返回的招呼内容为>>> " + helloMessage.getName());
    }

}
