package com.ayni.user_service.Iam.domain.services;

import com.ayni.user_service.Iam.domain.model.entities.Role;
import com.ayni.user_service.Iam.domain.model.queries.GetAllRolesQuery;
import com.ayni.user_service.Iam.domain.model.queries.GetRoleByNameQuery;

import java.util.List;
import java.util.Optional;

public interface RoleQueryService {
    List<Role> handle(GetAllRolesQuery query); // retorna todos los roles
    Optional<Role> handle(GetRoleByNameQuery query); // retorna un rol por nombre
}
