package com.ayni.notification_service.notifications.interfaces.rest.resources;

import com.ayni.notification_service.notifications.domain.model.valueobjects.NotificationType;
import com.ayni.notification_service.notifications.domain.model.valueobjects.NotificationChannel;
import java.time.LocalDateTime;

public class NotificationRequest {
    private String userId;
    private String title;
    private String description;
    private LocalDateTime scheduledDate;
    private NotificationType type;
    private NotificationChannel channel;

    // Getters y setters
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public LocalDateTime getScheduledDate() { return scheduledDate; }
    public void setScheduledDate(LocalDateTime scheduledDate) { this.scheduledDate = scheduledDate; }
    public NotificationType getType() { return type; }
    public void setType(NotificationType type) { this.type = type; }
    public NotificationChannel getChannel() { return channel; }
    public void setChannel(NotificationChannel channel) { this.channel = channel; }
} 