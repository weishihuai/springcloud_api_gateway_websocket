package com.springcloud.wsh.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title: TestController
 * @ProjectName springcloud_eureka_service_a
 * @Description: 测试
 * @Author WeiShiHuai
 * @Date 2018/9/1 14:43
 */
@RestController
public class TestController {

    private static Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(@RequestParam Integer a, @RequestParam Integer b) {
        ServiceInstance instance = client.getLocalServiceInstance();
        Integer r = a + b;
        logger.info("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + r);
        return "From Eureka-Service-A, Result is " + r;
    }

}
