package com.mobiquityinc.test.controller;

import com.mobiquityinc.test.service.AtmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AtmController {

    @Autowired
    private AtmService atmService;

    /**
     * @apiNote get all atms
     * @return ResponseEntity
     */
    @GetMapping("/atms")
    public ResponseEntity getAllAtms(){
        return ResponseEntity.ok(atmService.getAllAtms());
    }

    /**
     * @apiNote  get all atms based on city
     * @param city
     * @return ResponseEntity
     */
    @GetMapping("/atms/{city}")
    public ResponseEntity getAllAtmsBasedOnCity(@PathVariable  String city){
        return ResponseEntity.ok(atmService.getAllAtmsBasedOnCity(city));
    }
}
