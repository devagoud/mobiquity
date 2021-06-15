package com.mobiquityinc.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mobiquityinc.test.controller.dto.Atms;
import com.mobiquityinc.test.domain.Atm;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author Deva Goud
 */
@SpringBootTest
@ContextConfiguration(classes = TestApplication.class)
@Slf4j
class TestApplicationTests {
	
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private ObjectMapper objectMapper;


	/**
	 * @apiNote get all atms information
	 * @throws JsonProcessingException
	 */
	@Test
	void getAllAtmsTest() throws JsonProcessingException {
		String response = restTemplate.getForObject("https://www.ing.nl/api/locator/atms/", String.class);
		String formatResponse = response.substring( response.indexOf(",", 1)+1);
		Atm[] atm = objectMapper.readValue(formatResponse, Atm[].class);
		List<Atm> atms = Stream.of(atm).collect(Collectors.toList());
		Assertions.assertNotEquals(0,atms.size());
	}

	/**
	 * @apiNote get Atms based on city
	 */
	@Test
	void getAllAtmsBasedOnCityTest() throws JsonProcessingException {
		String city="Zuidhorn";
		String response = restTemplate.getForObject("https://www.ing.nl/api/locator/atms/", String.class);
		String formatResponse = response.substring( response.indexOf(",", 1)+1);
		Atm[] atm = objectMapper.readValue(formatResponse, Atm[].class);
		List<Atm> atms = Stream.of(atm).collect(Collectors.toList());
		List<Atm> cityAtms = atms.stream().filter(atm1 -> atm1.getAddress().getCity().equals(city)).collect(Collectors.toList());
		Assertions.assertEquals(cityAtms.get(0).getAddress().getCity(),city);
	}
}
