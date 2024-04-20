package com.spring.service;

import com.spring.dto.CustomerRegistrationRequest;
import com.spring.model.Customer;

public interface CustomerService {
    void registerCustomer(CustomerRegistrationRequest request);
}
