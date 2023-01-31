package com.gblanco.examples.examples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
public class RedisExample {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("start")
    public String startRedis(){

        try{
            restTemplate.exchange("https://api.publicapis.org/entries",
                    HttpMethod.PUT, null, ResponseExample.class);
        }catch (RestClientException e){
            System.out.println("ERROR: " + e);
        }


        ResponseExample exchange = restTemplate.getForObject("https://api.publicapis.org/entries", ResponseExample.class);
        System.out.println(exchange == null);
        String s = UUID.randomUUID().toString();
        System.out.println(s);
        return "start";
    }

    @GetMapping("end")
    public void endRedis(){
    }

}
