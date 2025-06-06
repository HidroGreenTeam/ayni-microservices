package com.ayni.user_service.Iam.interfaces.rest.resources;

public record AuthenticatedUserResource(
        Long id,
        String email,
        String token
) {
}
