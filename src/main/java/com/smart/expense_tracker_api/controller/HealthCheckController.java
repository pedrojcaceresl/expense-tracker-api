package com.smart.expense_tracker_api.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController()
@RequestMapping("/")
public class HealthCheckController {
    
    @GetMapping()
    public ResponseEntity<String> checkHealth() {
        return ResponseEntity.ok("Everything's up and running...");
    }

}
