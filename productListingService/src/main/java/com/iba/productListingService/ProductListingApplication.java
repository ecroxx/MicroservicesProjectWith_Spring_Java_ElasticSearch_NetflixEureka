package com.iba.productListingService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
Implemented by Egemen Ozkan / 21.10.2020
 */

@EnableDiscoveryClient
@SpringBootApplication
public class ProductListingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductListingApplication.class, args);
	}
}