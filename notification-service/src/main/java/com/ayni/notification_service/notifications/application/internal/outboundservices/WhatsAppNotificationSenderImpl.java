package com.ayni.notification_service.notifications.application.internal.outboundservices;

import com.ayni.notification_service.notifications.infrastructure.twilio.TwilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WhatsAppNotificationSenderImpl implements WhatsAppNotificationSender {
    
    @Autowired
    private TwilioService twilioService;
    
    @Override
    public boolean send(String to, String message) {
        // Enviar usando Twilio WhatsApp
        return twilioService.sendWhatsApp(to, message);
    }
}