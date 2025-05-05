package com.todocodeacademy.platos.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class appConfig {

    @Bean("apiConsumir")
    public RestTemplate crearRestTemplate(){
        return new RestTemplate();
    }
}
