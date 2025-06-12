package com.ayni.notification_service.notifications.application.internal.outboundservices;

public interface WhatsAppNotificationSender {
    boolean send(String to, String message);
} 