package com.ayni.notification_service.notifications.domain.model.queries;

public class GetNotificationsByUserQuery {
    private String userId;

    public GetNotificationsByUserQuery(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }
} 