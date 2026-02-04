package com.islamhamada.petshop.config;

import com.islamhamada.petshop.contracts.model.KafkaUserMessage;
import com.islamhamada.petshop.document.Notification;
import com.islamhamada.petshop.repository.NotificationRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

import java.time.Instant;
import java.util.UUID;

@Log4j2
@Configuration
public class KafkaConfig {

    @Autowired
    NotificationRepository notificationRepository;

    @KafkaListener(id = "1", topics = "notification")
    public void listen(KafkaUserMessage message){
        log.info("Kafka: " + message);
        notificationRepository.save(Notification.builder()
                        .id(UUID.randomUUID())
                        .userId(message.getUserId())
                        .message(message.getMessage())
                        .createdAt(Instant.now())
                        .read(false)
                        .build());
    }
}
