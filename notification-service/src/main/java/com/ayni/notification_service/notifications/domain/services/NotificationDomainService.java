package com.ayni.notification_service.notifications.domain.services;

import com.ayni.notification_service.notifications.domain.model.aggregates.Notification;

public class NotificationDomainService {
    public boolean isValid(Notification notification) {
        // Aquí puedes poner reglas de negocio, por ejemplo:
        return notification.getUserId() != null && notification.getTitle() != null;
    }
} 