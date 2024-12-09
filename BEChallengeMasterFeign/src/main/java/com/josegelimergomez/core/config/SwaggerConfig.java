package com.josegelimergomez.core.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI().info(new Info().title("Movie API").description("API for fetching movie director data").version("v1.0").license(new License().name("Apache 2.0").url("http://springdoc.org"))).externalDocs(new ExternalDocumentation().description("Movie API Documentation").url("https://github.com/josegelimergomez/movies-api"));
    }

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder().group("springshop-public").pathsToMatch("/api/**").build();
    }

}
