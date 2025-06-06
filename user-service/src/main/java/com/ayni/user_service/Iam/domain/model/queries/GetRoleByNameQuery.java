package com.ayni.user_service.Iam.domain.model.queries;

import com.ayni.user_service.Iam.domain.model.valueobjects.Roles;

public record GetRoleByNameQuery(Roles roleName) {
}
