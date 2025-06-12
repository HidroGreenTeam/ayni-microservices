package com.ayni.notification_service.notifications.application.internal.scheduling;

import com.ayni.notification_service.notifications.application.internal.commandservices.NotificationCommandService;
import com.ayni.notification_service.notifications.infrastructure.persistence.jpa.repositories.NotificationRepository;
import com.ayni.notification_service.notifications.domain.model.aggregates.Notification;
import com.ayni.notification_service.notifications.domain.model.valueobjects.NotificationStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ScheduledNotificationTask {

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private NotificationCommandService notificationCommandService;

    // Ejecuta cada minuto
    @Scheduled(cron = "0 * * * * *")
    public void sendScheduledNotifications() {
        LocalDateTime now = LocalDateTime.now();
        // Obtener notificaciones pendientes cuya fecha programada ya pasó
        List<Notification> due = notificationRepository.findByStatusAndScheduledDateLessThanEqual(
                NotificationStatus.PENDING, now);
        for (Notification n : due) {
            notificationCommandService.createAndSend(n);
        }
    }
}
