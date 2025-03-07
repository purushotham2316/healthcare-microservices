package com.healthcare.notification_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.notification_service.service.KafkaProducerService;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private KafkaProducerService producerService;

    @PostMapping("/send")
    public String sendNotification(@RequestParam("message") String message) {
        producerService.sendNotification(message);
        return "Notification sent successfully!";
    }
}
