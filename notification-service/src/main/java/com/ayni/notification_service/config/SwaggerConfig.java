package com.ayni.notification_service.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SwaggerConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // Redirect root URL to Swagger UI
        registry.addRedirectViewController("/", "/swagger-ui/index.html");
        // Support legacy swagger-ui.html path
        registry.addRedirectViewController("/swagger-ui.html", "/swagger-ui/index.html");
    }
}
