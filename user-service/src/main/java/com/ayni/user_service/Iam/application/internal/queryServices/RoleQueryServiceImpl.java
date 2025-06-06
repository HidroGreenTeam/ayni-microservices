package com.ayni.user_service.Iam.application.internal.queryServices;

import com.ayni.user_service.Iam.domain.model.entities.Role;
import com.ayni.user_service.Iam.domain.model.queries.GetAllRolesQuery;
import com.ayni.user_service.Iam.domain.model.queries.GetRoleByNameQuery;
import com.ayni.user_service.Iam.domain.services.RoleQueryService;
import com.ayni.user_service.Iam.infrastructure.persistence.jpa.repositories.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleQueryServiceImpl implements RoleQueryService {

    private final RoleRepository roleRepository;

    public RoleQueryServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    @Override
    public List<Role> handle(GetAllRolesQuery query) {
        return roleRepository.findAll();
    }

    @Override
    public Optional<Role> handle(GetRoleByNameQuery query) {
        return roleRepository.findByName(query.roleName());
    }
}
