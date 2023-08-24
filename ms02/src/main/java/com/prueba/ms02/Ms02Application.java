package com.prueba.ms02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class Ms02Application {

	public static void main(String[] args) {
		SpringApplication.run(Ms02Application.class, args);
	}

}
