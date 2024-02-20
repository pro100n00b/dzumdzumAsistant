package com.example.dzumdzumAsistant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DzumdzumAsistantApplication {

	public static void main(String[] args) {
		SpringApplication.run(DzumdzumAsistantApplication.class, args);
	}

}
