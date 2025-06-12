package com.ayni.notification_service.notifications.application.internal.outboundservices;

import org.springframework.stereotype.Service;

@Service
public class InAppNotificationSenderImpl implements InAppNotificationSender {
    @Override
    public boolean send(String userId, String title, String message) {
        // Aquí iría la lógica real para notificaciones in-app
        System.out.println("[InApp] Usuario: " + userId + " Título: " + title + " Mensaje: " + message);
        return true; // Simula éxito
    }
} 