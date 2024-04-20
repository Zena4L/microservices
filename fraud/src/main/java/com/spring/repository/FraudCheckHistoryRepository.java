package com.spring.repository;

import com.spring.model.Fraud;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FraudCheckHistoryRepository extends JpaRepository<Fraud,Integer> {
}
