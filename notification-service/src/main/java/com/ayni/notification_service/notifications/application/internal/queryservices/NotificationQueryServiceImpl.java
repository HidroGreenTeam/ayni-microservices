package com.ayni.notification_service.notifications.application.internal.queryservices;

import com.ayni.notification_service.notifications.domain.model.aggregates.Notification;
import com.ayni.notification_service.notifications.infrastructure.persistence.jpa.repositories.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NotificationQueryServiceImpl implements NotificationQueryService {
    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    public List<Notification> getByUser(String userId) {
        return notificationRepository.findByUserId(userId);
    }
} 