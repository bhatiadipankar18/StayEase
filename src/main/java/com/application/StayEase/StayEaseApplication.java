package com.application.StayEase;

import com.application.StayEase.entity.Hotel;
import com.application.StayEase.repository.HotelRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EntityScan(basePackages = "com.application.StayEase.entity")
public class StayEaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(StayEaseApplication.class, args);
	}

}
