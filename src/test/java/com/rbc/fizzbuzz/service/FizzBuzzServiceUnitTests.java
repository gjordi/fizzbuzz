package com.rbc.fizzbuzz.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FizzBuzzServiceUnitTests {

	@Autowired
  public FizzBuzzService fizzBuzzService;

	@Test
	public void testExecute_NoFizz() throws Exception {

		// setup
		int value = 1;

		// execute
		String result = fizzBuzzService.execute(value);

		// verify
		Assertions.assertEquals("1", result);
	}

	@Test
	public void testExecute_NoFizz_OneLess() throws Exception {

		// setup
		int value = 8;

		// execute
		String result = fizzBuzzService.execute(value);

		// verify
		Assertions.assertEquals("8", result);
	}

	@Test
	public void testExecute_NoFizz_OneMore() throws Exception {

		// setup
		int value = 31;

		// execute
		String result = fizzBuzzService.execute(value);

		// verify
		Assertions.assertEquals("31", result);
	}

	@Test
	public void testExecute_Fizz() throws Exception {

		// setup
		int value = 3;

		// execute
		String result = fizzBuzzService.execute(value);

		// verify
		Assertions.assertEquals("Fizz", result);
	}

	@Test
	public void testExecute_NoBuzz() throws Exception {

		// setup
		int value = 2;

		// execute
		String result = fizzBuzzService.execute(value);

		// verify
		Assertions.assertEquals("2", result);
	}

	@Test
	public void testExecute_NoBuzz_OneLess() throws Exception {

		// setup
		int value = 49;

		// execute
		String result = fizzBuzzService.execute(value);

		// verify
		Assertions.assertEquals("49", result);
	}

	@Test
	public void testExecute_NoBuzz_OneMore() throws Exception {

		// setup
		int value = 56;

		// execute
		String result = fizzBuzzService.execute(value);

		// verify
		Assertions.assertEquals("56", result);
	}

	@Test
	public void testExecute_Buzz() throws Exception {

		// setup
		int value = 50;

		// execute
		String result = fizzBuzzService.execute(value);

		// verify
		Assertions.assertEquals("Buzz", result);
	}

	@Test
	public void testExecute_NoFizzBuzz() throws Exception {

		// setup
		int value = 4;

		// execute
		String result = fizzBuzzService.execute(value);

		// verify
		Assertions.assertEquals("4", result);
	}

	@Test
	public void testExecute_NoFizzBuzz_OneLess() throws Exception {

		// setup
		int value = 14;

		// execute
		String result = fizzBuzzService.execute(value);

		// verify
		Assertions.assertEquals("14", result);
	}

	@Test
	public void testExecute_NoFizzBuzz_OneMore() throws Exception {

		// setup
		int value = 16;

		// execute
		String result = fizzBuzzService.execute(value);

		// verify
		Assertions.assertEquals("16", result);
	}

	@Test
	public void testExecute_FizzBuzz() throws Exception {

		// setup
		int value = 3 * 5;

		// execute
		String result = fizzBuzzService.execute(value);

		// verify
		Assertions.assertEquals("FizzBuzz", result);
	}

}
