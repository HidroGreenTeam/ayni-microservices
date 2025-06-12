package com.ayni.notification_service.notifications.application.internal.commandservices;

import com.ayni.notification_service.notifications.domain.model.aggregates.Notification;
import com.ayni.notification_service.notifications.domain.model.valueobjects.NotificationStatus;
import com.ayni.notification_service.notifications.infrastructure.persistence.jpa.repositories.NotificationRepository;
import com.ayni.notification_service.notifications.application.internal.outboundservices.EmailNotificationSender;
import com.ayni.notification_service.notifications.application.internal.outboundservices.WhatsAppNotificationSender;
import com.ayni.notification_service.notifications.application.internal.outboundservices.SmsNotificationSender;
import com.ayni.notification_service.notifications.application.internal.outboundservices.InAppNotificationSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class NotificationCommandServiceImpl implements NotificationCommandService {
    @Autowired
    private NotificationRepository notificationRepository;
    @Autowired
    private WhatsAppNotificationSender whatsAppSender;
    @Autowired
    private SmsNotificationSender smsSender;
    @Autowired
    private EmailNotificationSender emailSender;
    @Autowired
    private InAppNotificationSender inAppSender;

    @Override
    public Notification createAndSend(Notification notification) {
        LocalDateTime now = LocalDateTime.now();
        // If scheduledDate is in the future, schedule only
        if (notification.getScheduledDate() != null && notification.getScheduledDate().isAfter(now)) {
            notification.setStatus(NotificationStatus.PENDING);
            return notificationRepository.save(notification);
        }
        // Immediate send: set scheduledDate to now
        notification.setScheduledDate(now);
        notificationRepository.save(notification);
        boolean sent = false;
        switch (notification.getChannel()) {
            case WHATSAPP:
                sent = whatsAppSender.send(notification.getUserId(), notification.getDescription());
                break;
            case SMS:
                sent = smsSender.send(notification.getUserId(), notification.getDescription());
                break;
            case EMAIL:
                sent = emailSender.send(notification.getUserId(), notification.getTitle(), notification.getDescription());
                break;
            case IN_APP:
                sent = inAppSender.send(notification.getUserId(), notification.getTitle(), notification.getDescription());
                break;
        }
        notification.setStatus(sent ? NotificationStatus.SENT : NotificationStatus.FAILED);
        notification.setSentDate(LocalDateTime.now());
        return notificationRepository.save(notification);
    }
}