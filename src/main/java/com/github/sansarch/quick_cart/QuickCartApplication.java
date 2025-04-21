package com.github.sansarch.quick_cart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class QuickCartApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuickCartApplication.class, args);
	}

}
