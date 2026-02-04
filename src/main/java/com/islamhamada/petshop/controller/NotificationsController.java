package com.islamhamada.petshop.controller;

import com.islamhamada.petshop.contracts.dto.NotificationDTO;
import com.islamhamada.petshop.service.NotificationsService;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/notifications/protected")
public class NotificationsController {

    @Autowired
    private NotificationsService notificationsService;

    @PreAuthorize("hasAnyRole('Customer')")
    @GetMapping("/{userId}")
    public List<NotificationDTO> getNotifications(@PositiveOrZero @PathVariable long userId) {
        return notificationsService.getNotifications(userId);
    }
}
