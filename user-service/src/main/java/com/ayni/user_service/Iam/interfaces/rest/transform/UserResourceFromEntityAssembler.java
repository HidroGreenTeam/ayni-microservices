package com.ayni.user_service.Iam.interfaces.rest.transform;

import com.ayni.user_service.Iam.domain.model.aggregates.User;
import com.ayni.user_service.Iam.interfaces.rest.resources.UserResource;

public class UserResourceFromEntityAssembler {
    public static UserResource toUserResourceFromEntity(User entity) {
        var roles = entity.getRoles().stream().map(role -> role.getStringName()).toList();

        return new UserResource(
                entity.getId(),
                entity.getEmail(),
                roles
        );
    }
}
