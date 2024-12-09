package com.b2bSolutions.core.HTTPCLIENTS.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.http.HttpClient;
import java.time.Duration;

@Configuration
public class HttpClientConfig {

    @Bean
    public HttpClient httpClient(){
        return HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(30))
                .build();
    }
}