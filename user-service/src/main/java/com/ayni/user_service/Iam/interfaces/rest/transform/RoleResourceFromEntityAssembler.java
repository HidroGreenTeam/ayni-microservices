package com.ayni.user_service.Iam.interfaces.rest.transform;

import com.ayni.user_service.Iam.domain.model.entities.Role;
import com.ayni.user_service.Iam.interfaces.rest.resources.RoleResource;

public class RoleResourceFromEntityAssembler {
    public static RoleResource toRoleResourceFromEntity(Role role) {
        return new RoleResource(role.getId(), role.getStringName());
    }
}
