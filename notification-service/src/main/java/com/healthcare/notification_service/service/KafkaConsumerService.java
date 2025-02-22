package com.healthcare.notification_service.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.healthcare.notification_service.model.Notification;
import com.healthcare.notification_service.repository.NotificationRepository;

@Service
public class KafkaConsumerService {

    @Autowired
    private NotificationRepository notificationRepository;

    public KafkaConsumerService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }   
    @KafkaListener(topics = "notifications", groupId = "notification-group")
    @Transactional
    public void consumeMessage(String message) {
        Notification notification = new Notification();
        notification.setMessage(message);
        notification.setStatus("Unread");
        notification.setTimestamp(LocalDateTime.now().toString());
        notificationRepository.save(notification);
        System.out.println("Notification Received: " + message);
    }
}
