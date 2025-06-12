package com.ayni.notification_service.notifications.application.internal.outboundservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailNotificationSenderImpl implements EmailNotificationSender {
    
    @Autowired
    private JavaMailSender mailSender;
    
    @Value("${email.from.address:noreply@ayni.com}")
    private String fromAddress;
    
    @Value("${email.from.name:Ayni Notifications}")
    private String fromName;
    
    @Override
    public boolean send(String to, String subject, String body) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(fromAddress);
            message.setTo(to);
            message.setSubject(subject);
            message.setText(body);
            
            mailSender.send(message);
            
            System.out.println("✅ [Email] Enviado exitosamente a: " + to + " | Asunto: " + subject);
            return true;
            
        } catch (Exception e) {
            System.err.println("❌ [Email] Error enviando a: " + to + " | Error: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}