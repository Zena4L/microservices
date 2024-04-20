package com.spring.controller;

import com.spring.dto.CustomerRegistrationRequest;
import com.spring.model.Customer;
import com.spring.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api/v1/customer")
public record CustomerController(CustomerService customerService) {


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void registerCustomer(@RequestBody CustomerRegistrationRequest request) {
        log.info("new customer registration {} ", request);

        customerService.registerCustomer(request);
    }
}
