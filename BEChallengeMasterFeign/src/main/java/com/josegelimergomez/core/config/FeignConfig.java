package com.josegelimergomez.core.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.josegelimergomez.core.util.CustomDecoder;
import feign.Logger;
import feign.Retryer;
import feign.codec.Decoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {
    @Bean
    public Retryer retryer() {
        return new Retryer.Default(500, 3000, 3);// Inicialmente espera 1 segundo,
        // duplica el tiempo de espera en cada intento, y hace 3 intentos
    }

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public Decoder decoder(){
        return new CustomDecoder(new ObjectMapper());
    }
}
