package com.ayni.notification_service.notifications.application.internal.outboundservices;

public interface SmsNotificationSender {
    boolean send(String to, String message);
}
