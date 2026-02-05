package com.islamhamada.petshop.service;

import com.islamhamada.petshop.contracts.dto.NotificationDTO;
import com.islamhamada.petshop.document.Notification;
import com.islamhamada.petshop.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotificationsServiceImpl implements NotificationsService {

    @Autowired
    NotificationRepository notificationRepository;

    @Override
    public List<NotificationDTO> getNotifications(long userId) {
        List<Notification> notifications = notificationRepository.findByUserId(userId);
        List<NotificationDTO> rv = new ArrayList<>();
        for(Notification notification : notifications){
            NotificationDTO notificationDTO = NotificationDTO.builder()
                            .message(notification.getMessage())
                            .read(notification.isRead())
                            .createdAt(notification.getCreatedAt())
                            .build();
            rv.add(notificationDTO);
        }
        return rv;
    }

    @Override
    public void readNotifications(long userId) {
        List<Notification> notifications = notificationRepository.findByUserId(userId);
        notifications.stream()
            .filter(n -> !n.isRead())
            .forEach(n -> {
                n.setRead(true);
                notificationRepository.save(n);
            });
    }
}
