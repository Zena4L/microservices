package com.spring.service;

import lombok.Builder;

@Builder
public record NotificationRequest(Integer customerId, String message) {
}
