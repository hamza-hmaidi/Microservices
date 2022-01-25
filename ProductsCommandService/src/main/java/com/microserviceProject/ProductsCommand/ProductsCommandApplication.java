package com.microserviceProject.ProductsCommand;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ProductsCommandApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductsCommandApplication.class, args);
	}

}
