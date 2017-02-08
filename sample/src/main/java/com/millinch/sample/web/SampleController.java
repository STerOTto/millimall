package com.millinch.sample.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This guy is lazy, nothing left.
 *
 * @author John Zhang
 */
@RefreshScope
@RestController
public class SampleController {

    @Value("${message}")
    private String message;

    @RequestMapping("/message")
    String message() {
        return message;
    }

}
