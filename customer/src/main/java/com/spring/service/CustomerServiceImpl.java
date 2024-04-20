package com.spring.service;

import com.spring.dto.CustomerRegistrationRequest;
import com.spring.fraud.FraudCheckResponse;
import com.spring.fraud.FraudClient;
import com.spring.model.Customer;
import com.spring.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;
    private final RestTemplate restTemplate;
    private final FraudClient client;

    @Override
    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstname(request.firstname())
                .lastname(request.lastname())
                .email(request.email())
                .build();

        repository.saveAndFlush(customer);

        //todo: check if email is valid
        //todo: check if email is not takend
        //todo : check if fraudster
//        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
//                "http://FRAUD/api/v1/fraud-check/{customerId}",
//                FraudCheckResponse.class,
//                customer.getId()
//        );

        FraudCheckResponse fraudCheckResponse = client.fraudCheck(customer.getId());

        assert fraudCheckResponse != null;
        if (fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("Fraudster");
        }
        //send notification
    }
}
