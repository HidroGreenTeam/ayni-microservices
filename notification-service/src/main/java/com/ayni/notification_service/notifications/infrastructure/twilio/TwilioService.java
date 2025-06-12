package com.ayni.notification_service.notifications.infrastructure.twilio;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
public class TwilioService {
    
    @Value("${twilio.account.sid:}")
    private String accountSid;
    
    @Value("${twilio.auth.token:}")
    private String authToken;
    
    @Value("${twilio.phone.number:}")
    private String twilioPhoneNumber;
    
    @Value("${twilio.whatsapp.number:}")
    private String twilioWhatsAppNumber;
    
    @PostConstruct
    public void initTwilio() {
        if (!accountSid.isBlank() && !authToken.isBlank()) {
            Twilio.init(accountSid, authToken);
        } else {
            System.out.println("[Twilio] Initialization skipped: no credentials provided");
        }
    }
    
    /**
     * Envía SMS usando Twilio
     */
    public boolean sendSMS(String toPhoneNumber, String messageBody) {
        if (accountSid.isBlank()) {
            System.out.println("[Twilio SMS Stub] to=" + toPhoneNumber + " msg=" + messageBody);
            return false;
        }
        try {
            Message message = Message.creator(
                new PhoneNumber(toPhoneNumber),
                new PhoneNumber(twilioPhoneNumber),
                messageBody
            ).create();
            System.out.println("[Twilio SMS] Mensaje enviado: " + message.getSid());
            return true;
        } catch (Exception e) {
            System.err.println("[Twilio SMS] Error: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * Envía mensaje de WhatsApp usando Twilio
     */
    public boolean sendWhatsApp(String toWhatsAppNumber, String messageBody) {
        if (accountSid.isBlank()) {
            System.out.println("[Twilio WhatsApp Stub] to=" + toWhatsAppNumber + " msg=" + messageBody);
            return false;
        }
        try {
            Message message = Message.creator(
                new PhoneNumber("whatsapp:" + toWhatsAppNumber),
                new PhoneNumber(twilioWhatsAppNumber),
                messageBody
            ).create();
            System.out.println("[Twilio WhatsApp] Mensaje enviado: " + message.getSid());
            return true;
        } catch (Exception e) {
            System.err.println("[Twilio WhatsApp] Error: " + e.getMessage());
            return false;
        }
    }
}
