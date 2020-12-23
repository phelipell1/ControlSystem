package com.prs.systemcontrolapi.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.prs.systemcontrolapi.rest.controller"})
@EntityScan(basePackages = { "com.prs.systemcontrolapi.rest.model"})
@EnableJpaRepositories(basePackages = { "com.prs.systemcontrolapi.rest.repository" })
public class RestApplication{

	
	public static void main(String[] args) {
		SpringApplication.run(RestApplication.class, args);
	}
	
}
