package com.codingshuttle.sandip.week1introduction.IntroductionToSpringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IntroductionToSpringbootApplication implements CommandLineRunner {

//	@Autowired
//	Apple obj;

	@Autowired
	DBService dbService;

	public static void main(String[] args) {
		SpringApplication.run(IntroductionToSpringbootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		obj.eatApple();

		System.out.println(dbService.getData());
	}
}
