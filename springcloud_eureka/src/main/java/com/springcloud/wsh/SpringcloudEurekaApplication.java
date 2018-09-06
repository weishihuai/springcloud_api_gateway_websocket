package com.springcloud.wsh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
//开启Eureka服务注册发现功能
@EnableEurekaServer
public class SpringcloudEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudEurekaApplication.class, args);
	}
}
