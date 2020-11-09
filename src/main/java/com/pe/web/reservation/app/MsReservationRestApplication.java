package com.pe.web.reservation.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MsReservationRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsReservationRestApplication.class, args);
	}

}
