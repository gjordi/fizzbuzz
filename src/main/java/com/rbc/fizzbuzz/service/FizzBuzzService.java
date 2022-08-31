package com.rbc.fizzbuzz.service;

import org.springframework.stereotype.Service;

@Service
public class FizzBuzzService {
  
  public String execute(int value) {
		boolean fizz = (value % 3 == 0);
		boolean buzz = (value % 5 == 0);

		if (fizz && buzz)
			return "FizzBuzz";

		if (fizz)
			return "Fizz";

		if (buzz)
			return "Buzz";

		return String.valueOf(value);
	}
}
