package com.example.property.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@PropertySource("classpath:test.properties")
public class PropertiesConfig {

    @Value("${api.serviceKey}")
    private String serviceKey;

    // Getter or methods using serviceKey

    public String getServiceKey() {
        return serviceKey;
    }

}
