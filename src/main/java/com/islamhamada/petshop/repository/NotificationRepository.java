package com.islamhamada.petshop.repository;

import com.islamhamada.petshop.document.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

public interface NotificationRepository extends MongoRepository<Notification, UUID> {
    public List<Notification> findByUserId(long userId);
}
