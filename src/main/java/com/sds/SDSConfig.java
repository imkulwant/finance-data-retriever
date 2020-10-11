package com.sds;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan({"com.sds.rest", "com.sds.service"})
public class SDSConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
