package com.healthcare.notification_service.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.healthcare.notification_service.model.Notification;

public interface NotificationRepository extends MongoRepository<Notification, String> {
    List<Notification> findByUserId(String userId);
}
