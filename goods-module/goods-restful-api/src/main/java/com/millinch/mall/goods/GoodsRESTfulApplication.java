package com.millinch.mall.goods;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * This guy is lazy, nothing left.
 *
 * @author John Zhang
 */
@EnableResourceServer
@EnableDiscoveryClient
@SpringBootApplication
public class GoodsRESTfulApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoodsRESTfulApplication.class, args);
    }
}
