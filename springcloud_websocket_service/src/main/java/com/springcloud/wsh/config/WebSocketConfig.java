package com.springcloud.wsh.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * @Title: WebSocketConfig
 * @ProjectName springcloud_websocket_service
 * @Description: WebSocket配置类
 * @Author WeiShiHuai
 * @Date 2018/9/3 10:48
 * registry.enableSimpleBroker("/topic");这句话表示在topic这个域上可以向客户端发消息。
 * registry.setApplicationDestinationPrefixes("/app");这句话表示客户单向服务器端发送时的主题上面需要加"/app"作为前缀。
 * stompEndpointRegistry.addEndpoint("/websocket-test").setAllowedOrigins("*").withSokJS();这个和客户端创建连接时的url有关，其中setAllowedOrigins()方法表示允许连接的域名，withSockJS()方法表示支持以SockJS方式连接服务器。
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

    /**
     * 配置端点
     * 将"/websocket-test"路径注册为STOMP端点，这个路径与发送和接收消息的目的路径有所不同，这是一个端点，客户端在订阅或发布消息到目的地址前，要连接该端点，
     * 即用户发送请求url="/applicationName/websocket-test"与STOMP server进行连接。之后再转发到订阅url；
     * 注意：端点的作用 —— 客户端在订阅或发布消息到目的地址前，要连接该端点。
     *
     * @param stompEndpointRegistry 端点注册对象
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        //在网页上可以通过"/applicationName/websocket-test"来和服务器的WebSocket连接
        stompEndpointRegistry.addEndpoint("/websocket-test").setAllowedOrigins("*").withSockJS();
    }

    /**
     * 配置了一个简单的消息代理，如果不重载，默认情况下回自动配置一个简单的内存消息代理，用来处理以"/topic"为前缀的消息。这里重载configureMessageBroker()方法，
     * 消息代理将会处理前缀为"/topic"和"/queue"的消息。
     *
     * @param registry 消息代理注册对象
     */

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //应用程序以/app为前缀，代理目的地以/topic为前缀
        // 配置消息代理目的地的前缀
        registry.enableSimpleBroker("/topic");
        // 配置应用程序的前缀
        registry.setApplicationDestinationPrefixes("/app");
    }

}
