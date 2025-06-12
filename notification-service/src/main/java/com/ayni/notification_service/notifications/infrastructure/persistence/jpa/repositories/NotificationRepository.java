package com.ayni.notification_service.notifications.infrastructure.persistence.jpa.repositories;

import com.ayni.notification_service.notifications.domain.model.aggregates.Notification;
import com.ayni.notification_service.notifications.domain.model.valueobjects.NotificationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByUserId(String userId);
    List<Notification> findByUserIdAndStatus(String userId, NotificationStatus status);
    List<Notification> findByStatusAndScheduledDateLessThanEqual(NotificationStatus status, java.time.LocalDateTime dateTime);
}