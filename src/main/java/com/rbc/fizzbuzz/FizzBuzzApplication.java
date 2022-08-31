package com.rbc.fizzbuzz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rbc.fizzbuzz.service.FizzBuzzService;

@SpringBootApplication
public class FizzBuzzApplication {

	public static Logger logger = LoggerFactory.getLogger(FizzBuzzApplication.class);

	@Autowired
	public FizzBuzzService fizzBuzzService;

	public static void main(String[] args) {
		SpringApplication.run(FizzBuzzApplication.class, args);

		logger.info("================================================================================");
		logger.info(" Welcome to Fizz Buzz");
		logger.info("--------------------------------------------------------------------------------");
		logger.info(" Point your browser to http://localhost:8080/next to start.");
		logger.info("================================================================================");
	}

	/*
	@PostConstruct
	public void outputToScreen() {
		logger.info("----------------------------------------");
		logger.info(" Game results for values 1..100");
		logger.info("----------------------------------------");
		for (int i = 1; i <= 100; i++) {
			logger.info(" " + i + ": " + fizzBuzzService.execute(i));
		}
		logger.info("----------------------------------------");
	}
	*/
}
