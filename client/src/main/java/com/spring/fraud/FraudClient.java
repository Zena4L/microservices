package com.spring.fraud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("fraud")
public interface FraudClient {
    @GetMapping(path = "api/v1/fraud-check/{customerId}")
    FraudCheckResponse fraudCheck(@PathVariable("customerId") Integer customerId);

    @GetMapping(path = "/{customerId}")
    void sendNotification(@PathVariable("customerId") Integer customerId);

}
