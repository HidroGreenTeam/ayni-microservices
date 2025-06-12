package com.ayni.notification_service.notifications.infrastructure.twilio;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component("twilioProperties")
@ConfigurationProperties(prefix = "twilio")
public class TwilioConfig {
    
    private Account account = new Account();
    private Phone phone = new Phone();
    private String whatsappNumber;
    
    public static class Account {
        private String sid;
        private String token;
        
        // Getters y setters
        public String getSid() { return sid; }
        public void setSid(String sid) { this.sid = sid; }
        public String getToken() { return token; }
        public void setToken(String token) { this.token = token; }
    }
    
    public static class Phone {
        private String number;
        
        // Getters y setters
        public String getNumber() { return number; }
        public void setNumber(String number) { this.number = number; }
    }
    
    // Getters y setters principales
    public Account getAccount() { return account; }
    public void setAccount(Account account) { this.account = account; }
    public Phone getPhone() { return phone; }
    public void setPhone(Phone phone) { this.phone = phone; }
    public String getWhatsappNumber() { return whatsappNumber; }
    public void setWhatsappNumber(String whatsappNumber) { this.whatsappNumber = whatsappNumber; }
}
