package com.rbc.fizzbuzz.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.ContentResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class FizzBuzzControllerIntegrationTests {

	@Autowired
	private MockMvc mvc;

	@Test
	public void testNext_Fizz() throws Exception {
		// setup
		MockHttpServletRequestBuilder restartRequestBuilder = MockMvcRequestBuilders.get("/restart");
		MockHttpServletRequestBuilder nextRequestBuilder = MockMvcRequestBuilders.get("/next");
		ContentResultMatchers content = MockMvcResultMatchers.content();

		// execute
		mvc.perform(restartRequestBuilder);
		ResultActions one = mvc.perform(nextRequestBuilder);
		ResultActions two = mvc.perform(nextRequestBuilder);
		ResultActions fizz = mvc.perform(nextRequestBuilder);

		// verify
		one.andExpect(content.string("1"));
		two.andExpect(content.string("2"));
		fizz.andExpect(content.string("Fizz"));
	}

	@Test
	public void testNext_Buzz() throws Exception {
		// setup
		MockHttpServletRequestBuilder restartRequestBuilder = MockMvcRequestBuilders.get("/restart");
		MockHttpServletRequestBuilder nextRequestBuilder = MockMvcRequestBuilders.get("/next");
		ContentResultMatchers content = MockMvcResultMatchers.content();

		// execute
		mvc.perform(restartRequestBuilder);

		ResultActions one = mvc.perform(nextRequestBuilder);
		ResultActions two = mvc.perform(nextRequestBuilder);
		ResultActions fizz = mvc.perform(nextRequestBuilder);
		ResultActions four = mvc.perform(nextRequestBuilder);
		ResultActions buzz = mvc.perform(nextRequestBuilder);

		// verify
		one.andExpect(content.string("1"));
		two.andExpect(content.string("2"));
		fizz.andExpect(content.string("Fizz"));
		four.andExpect(content.string("4"));
		buzz.andExpect(content.string("Buzz"));
	}

	@Test
	public void testNext_FizzBuzz() throws Exception {
		// setup
		MockHttpServletRequestBuilder restartRequestBuilder = MockMvcRequestBuilders.get("/restart");
		MockHttpServletRequestBuilder nextRequestBuilder = MockMvcRequestBuilders.get("/next");
		ContentResultMatchers content = MockMvcResultMatchers.content();

		// execute
		mvc.perform(restartRequestBuilder);

		// throw away requests 1 through 14 to get us to a FizzBuzz
		for (int i = 1; i < 15; i++)
			mvc.perform(nextRequestBuilder);

		ResultActions fizzBuzz = mvc.perform(nextRequestBuilder);

		// verify
		fizzBuzz.andExpect(content.string("FizzBuzz"));
	}

	@Test
	public void testRestart() throws Exception {
		// setup
		MockHttpServletRequestBuilder restartRequestBuilder = MockMvcRequestBuilders.get("/restart");
		MockHttpServletRequestBuilder nextRequestBuilder = MockMvcRequestBuilders.get("/next");
		ContentResultMatchers content = MockMvcResultMatchers.content();

		// execute
		for (int i = 0; i < 100; i++)
			mvc.perform(nextRequestBuilder);

		mvc.perform(restartRequestBuilder);

		ResultActions one = mvc.perform(nextRequestBuilder);

		// verify
		one.andExpect(content.string("1"));
	}
}
