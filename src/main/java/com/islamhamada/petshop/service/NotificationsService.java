package com.islamhamada.petshop.service;

import com.islamhamada.petshop.contracts.dto.NotificationDTO;
import jakarta.validation.constraints.PositiveOrZero;

import java.util.List;

public interface NotificationsService {
    List<NotificationDTO> getNotifications(long userId);
    void readNotifications(long userId);
}
