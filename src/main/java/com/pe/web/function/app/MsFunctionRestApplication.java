package com.pe.web.function.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MsFunctionRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsFunctionRestApplication.class, args);
	}

}
