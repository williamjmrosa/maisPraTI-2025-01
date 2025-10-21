package com.t1.api_example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class ApiExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiExampleApplication.class, args);
	}

    @Bean
    public WebClient webClient() {
        return WebClient.builder().build();
    }

}
