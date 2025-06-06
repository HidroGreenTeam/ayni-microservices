package com.ayni.user_service.Iam.interfaces.rest.resources;

public record SignInResource(
        String email,
        String password
) {
}
