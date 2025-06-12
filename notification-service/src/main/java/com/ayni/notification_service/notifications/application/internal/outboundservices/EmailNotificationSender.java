package com.ayni.notification_service.notifications.application.internal.outboundservices;

public interface EmailNotificationSender {
    boolean send(String to, String subject, String body);
} 