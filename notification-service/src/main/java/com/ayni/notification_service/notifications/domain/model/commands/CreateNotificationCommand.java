package com.ayni.notification_service.notifications.domain.model.commands;

import com.ayni.notification_service.notifications.domain.model.valueobjects.NotificationType;
import com.ayni.notification_service.notifications.domain.model.valueobjects.NotificationChannel;
import java.time.LocalDateTime;

public class CreateNotificationCommand {
    private String userId;
    private String title;
    private String description;
    private LocalDateTime scheduledDate;
    private NotificationType type;
    private NotificationChannel channel;

    public CreateNotificationCommand(String userId, String title, String description, LocalDateTime scheduledDate, NotificationType type, NotificationChannel channel) {
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.scheduledDate = scheduledDate;
        this.type = type;
        this.channel = channel;
    }

    // Getters
    public String getUserId() { return userId; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public LocalDateTime getScheduledDate() { return scheduledDate; }
    public NotificationType getType() { return type; }
    public NotificationChannel getChannel() { return channel; }
} 