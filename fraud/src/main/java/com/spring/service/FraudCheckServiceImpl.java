package com.spring.service;

import com.spring.model.Fraud;
import com.spring.repository.FraudCheckHistoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FraudCheckServiceImpl implements FraudCheckService {
    private final FraudCheckHistoryRepository repository;


    @Override
    public boolean isFraudulent(Integer customerId) {
        Fraud checks = Fraud.builder()
                .isFraudster(false)
                .customerId(customerId)
                .createdAt(LocalDateTime.now())
                .build();

        repository.save(checks);
        return false;
    }
}
