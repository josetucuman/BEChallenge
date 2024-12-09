package com.josegelimergomez.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BeChallengeMasterFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeChallengeMasterFeignApplication.class, args);
	}

}
