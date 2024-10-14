package com.example.property.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class RestClientConfig {
    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();

        // XML 메시지 변환기를 추가
/*        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        messageConverters.add(new Jaxb2RootElementHttpMessageConverter()); // XML 변환기 추가
        restTemplate.setMessageConverters(messageConverters);*/
// Get the default message converters
        List<HttpMessageConverter<?>> messageConverters = restTemplate.getMessageConverters();

        // Add Jaxb2RootElementHttpMessageConverter to support XML response
        messageConverters.add(new Jaxb2RootElementHttpMessageConverter());

        return restTemplate;
    }
}