package com.mobiquityinc.test.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AtmService {
    /**
     * @apiNote get all atms
     * @return ResponseEntity
     */
    List getAllAtms();

    /**
     * @apiNote  get all atms based on city
     * @param city
     * @return ResponseEntity
     */
    List getAllAtmsBasedOnCity(String city);
}
