package com.islamhamada.petshop.controller;

import com.islamhamada.petshop.contracts.dto.NotificationDTO;
import com.islamhamada.petshop.service.NotificationsService;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notifications")
public class NotificationsController {

    @Autowired
    private NotificationsService notificationsService;

    @PreAuthorize("hasAnyRole('Customer')")
    @GetMapping("/protected/{userId}")
    public List<NotificationDTO> getNotifications(@PositiveOrZero @PathVariable long userId) {
        return notificationsService.getNotifications(userId);
    }

    @PreAuthorize("hasAnyRole('Customer')")
    @PutMapping("/protected/{userId}")
    public void readNotifications(@PositiveOrZero @PathVariable long userId) {
        notificationsService.readNotifications(userId);
    }
}
