package com.ayni.notification_service.notifications.domain.model.events;

import com.ayni.notification_service.notifications.domain.model.aggregates.Notification;

public class NotificationCreatedEvent {
    private final Notification notification;

    public NotificationCreatedEvent(Notification notification) {
        this.notification = notification;
    }

    public Notification getNotification() {
        return notification;
    }
} 