package com.marcskow.spring.bootstrap.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringBootAuditSwagger {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAuditSwagger.class, args);
	}

}
