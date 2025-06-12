package com.ayni.notification_service.notifications.interfaces.rest.transform;

import com.ayni.notification_service.notifications.domain.model.aggregates.Notification;
import com.ayni.notification_service.notifications.domain.model.valueobjects.NotificationStatus;
import com.ayni.notification_service.notifications.interfaces.rest.resources.NotificationRequest;
import com.ayni.notification_service.notifications.interfaces.rest.resources.NotificationResponse;

public class NotificationMapper {
    public static Notification toEntity(NotificationRequest req) {
        Notification n = new Notification();
        n.setUserId(req.getUserId());
        n.setTitle(req.getTitle());
        n.setDescription(req.getDescription());
        n.setScheduledDate(req.getScheduledDate());
        n.setType(req.getType());
        n.setChannel(req.getChannel());
        n.setStatus(NotificationStatus.PENDING);
        return n;
    }

    public static NotificationResponse toResponse(Notification n) {
        NotificationResponse r = new NotificationResponse();
        r.setId(n.getId());
        r.setUserId(n.getUserId());
        r.setTitle(n.getTitle());
        r.setDescription(n.getDescription());
        r.setScheduledDate(n.getScheduledDate());
        r.setType(n.getType());
        r.setChannel(n.getChannel());
        r.setStatus(n.getStatus());
        return r;
    }
} 