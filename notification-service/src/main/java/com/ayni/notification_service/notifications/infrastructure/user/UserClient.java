package com.ayni.notification_service.notifications.infrastructure.user;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service", path = "/users")
public interface UserClient {
    @GetMapping("/{userId}/email")
    String getEmail(@PathVariable("userId") String userId);
}
