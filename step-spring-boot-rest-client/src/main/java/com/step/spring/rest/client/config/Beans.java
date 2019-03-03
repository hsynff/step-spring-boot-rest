package com.step.spring.rest.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Beans {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
