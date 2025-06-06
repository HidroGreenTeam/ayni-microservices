package com.ayni.user_service.Iam.interfaces.rest.transform;

import com.ayni.user_service.Iam.domain.model.aggregates.User;
import com.ayni.user_service.Iam.interfaces.rest.resources.AuthenticatedUserResource;

public class AuthenticatedUserResourceFromEntityAssembler {
    public static AuthenticatedUserResource toResourceFromEntity(User user, String token) {
        return new AuthenticatedUserResource(
                user.getId(),
                user.getEmail(),
                token
        );
    }
}
