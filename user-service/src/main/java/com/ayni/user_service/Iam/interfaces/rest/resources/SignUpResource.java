package com.ayni.user_service.Iam.interfaces.rest.resources;

import java.util.List;

public record SignUpResource(
        String fullName,
        String email,
        String password,
        List<String> roles
) {
}
