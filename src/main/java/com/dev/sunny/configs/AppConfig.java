package com.dev.sunny.configs;

import com.dev.sunny.mappers.ProductMapper;
import com.dev.sunny.mappers.ProductMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    ProductMapper productMapper() {
        return new ProductMapperImpl();
    }

}
