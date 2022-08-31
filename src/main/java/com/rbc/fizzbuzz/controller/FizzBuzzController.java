package com.rbc.fizzbuzz.controller;

import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rbc.fizzbuzz.service.FizzBuzzService;

@RestController
public class FizzBuzzController {

	Logger logger = LoggerFactory.getLogger(FizzBuzzController.class);

	private FizzBuzzService fizzBuzzService;
	private AtomicInteger value;

	@Autowired
	public FizzBuzzController(FizzBuzzService fizzBuzzService) {
		this.fizzBuzzService = fizzBuzzService;
		this.value = new AtomicInteger(1);
	}

	@GetMapping("/next")
	public String next() {

		int question = value.getAndIncrement();
		String answer = fizzBuzzService.execute(question);

		logger.info(" " + question + ": " + answer);

		return answer;
	}

	@GetMapping("/restart")
	public void restart() {

		value.set(1);
	}
}
