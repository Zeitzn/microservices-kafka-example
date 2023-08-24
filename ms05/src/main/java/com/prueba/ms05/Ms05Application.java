package com.prueba.ms05;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableKafka
@EnableScheduling
@SpringBootApplication
public class Ms05Application implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(Ms05Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}
}
