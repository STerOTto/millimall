package com.millinch.mall.thrift;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * This guy is lazy, nothing left.
 *
 * @author John Zhang
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableAutoConfiguration
@ComponentScan("com.millinch.mall.account.thrift")
@Controller
public class ThriftServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThriftServerApplication.class, args);
    }


    @Autowired
    private DiscoveryClient discoveryClient;

    @ResponseBody
    @GetMapping("/")
    public String index() {
        ServiceInstance instance = discoveryClient.getLocalServiceInstance();
        return "Host:" + instance.getHost() + ", service_id:" + instance.getServiceId();
    }
}
