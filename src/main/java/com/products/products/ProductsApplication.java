package com.products.products;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
@OpenAPIDefinition(
		info = @Info(title = "Products Project API", version = "1.0.0"),
		servers = {@Server(url = "http://localhost:8080")})
public class ProductsApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProductsApplication.class, args);
	}
}
