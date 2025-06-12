package com.ayni.notification_service.notifications.interfaces.rest;

import com.ayni.notification_service.notifications.application.internal.commandservices.NotificationCommandService;
import com.ayni.notification_service.notifications.application.internal.queryservices.NotificationQueryService;
import com.ayni.notification_service.notifications.interfaces.rest.resources.NotificationRequest;
import com.ayni.notification_service.notifications.interfaces.rest.resources.NotificationResponse;
import com.ayni.notification_service.notifications.interfaces.rest.transform.NotificationMapper;
import com.ayni.notification_service.notifications.domain.model.aggregates.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/notifications")
public class NotificationResource {
    @Autowired
    private NotificationCommandService commandService;
    @Autowired
    private NotificationQueryService queryService;

    @PostMapping
    public ResponseEntity<NotificationResponse> create(@RequestBody NotificationRequest req) {
        Notification notification = NotificationMapper.toEntity(req);
        Notification saved = commandService.createAndSend(notification);
        return ResponseEntity.ok(NotificationMapper.toResponse(saved));
    }

    @GetMapping("/user/{userId}")
    public List<NotificationResponse> getByUser(@PathVariable String userId) {
        return queryService.getByUser(userId)
            .stream()
            .map(NotificationMapper::toResponse)
            .collect(Collectors.toList());
    }
} 