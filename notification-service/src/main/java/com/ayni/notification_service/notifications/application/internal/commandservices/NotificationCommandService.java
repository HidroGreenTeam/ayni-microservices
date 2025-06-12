package com.ayni.notification_service.notifications.application.internal.commandservices;

import com.ayni.notification_service.notifications.domain.model.aggregates.Notification;

public interface NotificationCommandService {
    Notification createAndSend(Notification notification);
} 