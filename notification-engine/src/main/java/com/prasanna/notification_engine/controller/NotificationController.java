package com.prasanna.notification_engine.controller;


import com.prasanna.notification_engine.service.NotificationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService){
        this.notificationService = notificationService;
    }

    @GetMapping("/send")
    public String send(@RequestParam String msg){
        return notificationService.sendMessage(msg);
    }
}
