package com.mobiquityinc.test.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mobiquityinc.test.domain.Atm;
import com.mobiquityinc.test.service.AtmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class AtmServiceImpl implements AtmService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Value("${rest.url}")
   private String restUrl;


    /**
     * @apiNote get all atms
     * @return ResponseEntity
     */
    @Override
    public List getAllAtms() {
        String response = restTemplate.getForObject(restUrl, String.class);
        String formatResponse = response.substring( response.indexOf(",", 1)+1);
        Atm[] atm = new Atm[0];
        try {
            atm = objectMapper.readValue(formatResponse, Atm[].class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return Stream.of(atm).collect(Collectors.toList());
    }

    /**
     * @apiNote  get all atms based on city
     * @param city
     * @return ResponseEntity
     */
    @Override
    public List getAllAtmsBasedOnCity(String city)  {
        String response = restTemplate.getForObject(restUrl, String.class);
        String formatResponse = response.substring( response.indexOf(",", 1)+1);
        Atm[] atm = new Atm[0];
        try {
            atm = objectMapper.readValue(formatResponse, Atm[].class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return Stream.of(atm).collect(Collectors.toList());
    }
}
