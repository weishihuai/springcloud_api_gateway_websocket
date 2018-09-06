package com.springcloud.wsh;

import com.github.mthizo247.cloud.netflix.zuul.web.socket.EnableZuulWebSocket;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;

@SpringBootApplication
@EnableZuulWebSocket
@EnableWebSocketMessageBroker
@EnableDiscoveryClient
public class SpringcloudApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudApiGatewayApplication.class, args);
	}
}
