package com.bridgelabz.bookstoreorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.bridgelabz.bookstoreorder")
@EnableJpaRepositories("com.bridgelabz.bookstoreorder.repository")
@EnableEurekaClient
public class BookStoreOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreOrderApplication.class, args);
	}

}
