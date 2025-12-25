package com.prasanna.notification_engine.service;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(prefix="app", name="mode", havingValue="email")
public class EmailNotificationService implements NotificationService{


    @Override
    public String sendMessage(String message) {
        return "Sending EMAIL:" + message;
    }
}
