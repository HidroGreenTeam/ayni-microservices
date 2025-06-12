package com.ayni.notification_service.notifications.application.internal.outboundservices;

import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class ConsoleNotificationSender {
    
    private static final String BORDER = "═".repeat(60);
    private static final String LINE = "─".repeat(60);
    
    public boolean sendToConsole(String userId, String title, String message, String channel) {
        try {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            
            System.out.println("\n" + BORDER);
            System.out.println("📬 NOTIFICACIÓN AYNI - " + channel.toUpperCase());
            System.out.println(LINE);
            System.out.println("🕒 Fecha: " + timestamp);
            System.out.println("👤 Usuario: " + userId);
            System.out.println("📝 Título: " + title);
            System.out.println("💬 Mensaje: " + message);
            System.out.println("📡 Canal: " + channel);
            System.out.println(BORDER + "\n");
            
            return true;
        } catch (Exception e) {
            System.err.println("❌ Error mostrando notificación en consola: " + e.getMessage());
            return false;
        }
    }
}
