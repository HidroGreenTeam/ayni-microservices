package com.ayni.notification_service.notifications.application.internal.outboundservices;

public interface InAppNotificationSender {
    boolean send(String userId, String title, String message);
} 