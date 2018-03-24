package com.assesment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class GPSLocationLogsService {

	public static void main(String[] args) {
		SpringApplication.run(GPSLocationLogsService.class, args);
	}
}
