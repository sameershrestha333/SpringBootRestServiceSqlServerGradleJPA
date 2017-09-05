package com.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;


@EnableCaching
@EnableCircuitBreaker
@SpringBootApplication
public class SpringBootRestServiceSqlServerGradleJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestServiceSqlServerGradleJpaApplication.class, args);
	}
}
