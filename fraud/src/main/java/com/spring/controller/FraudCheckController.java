package com.spring.controller;

import com.spring.fraud.FraudCheckResponse;
import com.spring.service.FraudCheckService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/fraud-check")
public record FraudCheckController(FraudCheckService fraudCheckService) {
    @GetMapping(path = "{customerId}")
    @ResponseStatus(HttpStatus.CREATED)
    public FraudCheckResponse fraudCheck(@PathVariable("customerId") Integer customerId) {
        boolean res = fraudCheckService.isFraudulent(customerId);
        return new FraudCheckResponse(res);
    }
}
