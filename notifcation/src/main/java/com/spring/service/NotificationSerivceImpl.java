package com.spring.service;

import com.spring.model.Notification;
import com.spring.repository.NotificationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NotificationSerivceImpl implements NotifcationService {

    private final NotificationRepository repository;

    @Override
    public void notify(NotificationRequest request) {
        var notiftifation = Notification.builder()
                .customerId(request.customerId())
                .message(request.message())
                .build();

        repository.save(notiftifation);
    }
}
