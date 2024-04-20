package com.spring.dto;

import lombok.Builder;

@Builder
public record CustomerRegistrationRequest(
        String firstname,

        String lastname,
        String email
) {
}
