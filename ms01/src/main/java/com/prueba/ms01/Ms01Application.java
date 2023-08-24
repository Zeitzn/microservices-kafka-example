package com.prueba.ms01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class Ms01Application {

	public static void main(String[] args) {
		SpringApplication.run(Ms01Application.class, args);
	}

}
