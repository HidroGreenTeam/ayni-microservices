package com.ayni.notification_service.notifications.application.internal.outboundservices;

import com.ayni.notification_service.notifications.infrastructure.twilio.TwilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SmsNotificationSenderImpl implements SmsNotificationSender {
    
    @Autowired
    private TwilioService twilioService;
    
    @Override
    public boolean send(String to, String message) {
        // Enviar SMS usando Twilio
        return twilioService.sendSMS(to, message);
    }
}
