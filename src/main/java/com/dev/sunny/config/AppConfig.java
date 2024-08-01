package com.dev.sunny.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

@Configuration
public class AppConfig {

    @Bean
    public HttpHeaders headers() {
        return new HttpHeaders();
    }

}
