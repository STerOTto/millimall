package com.millinch.web.socket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

@Controller
public class GreetingController {

    @Autowired SimpMessagingTemplate template;

    public GreetingController() throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
    }

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Greeting("Hello, " + message.getName() + "!");
    }

    @ResponseBody
    @RequestMapping("/test")
    public String test() {
        template.convertAndSend("/topic/greetings", new Greeting("test - " + new Date()));
        return "success";
    }

}
