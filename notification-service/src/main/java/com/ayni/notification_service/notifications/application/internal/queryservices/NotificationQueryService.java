package com.ayni.notification_service.notifications.application.internal.queryservices;

import com.ayni.notification_service.notifications.domain.model.aggregates.Notification;
import java.util.List;

public interface NotificationQueryService {
    List<Notification> getByUser(String userId);
} 