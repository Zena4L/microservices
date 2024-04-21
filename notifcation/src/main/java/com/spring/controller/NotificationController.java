package com.spring.controller;

import com.spring.service.NotifcationService;
import com.spring.service.NotificationRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/notification")
public record NotificationController(NotifcationService notifcationService) {

    @GetMapping(path = "/{customerId}")
    public void sendNotification(@PathVariable("customerId") Integer customerId) {
        String message = "notification send";
        var request = NotificationRequest.builder()
                .customerId(customerId)
                .message(message)
                .build();
    }
}
