package com.ayni.user_service.Iam.application.internal.commandServices;

import com.ayni.user_service.Iam.domain.model.commands.SeedRolesCommand;
import com.ayni.user_service.Iam.domain.model.entities.Role;
import com.ayni.user_service.Iam.domain.model.valueobjects.Roles;
import com.ayni.user_service.Iam.domain.services.RoleCommandService;
import com.ayni.user_service.Iam.infrastructure.persistence.jpa.repositories.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class RoleCommandServiceImpl implements RoleCommandService {

    private final RoleRepository roleRepository;

    public RoleCommandServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void handle(SeedRolesCommand command) {
        Arrays.stream(Roles.values()).forEach(role -> {
            if(!roleRepository.existsByName(role)) {
                roleRepository.save(new Role(Roles.valueOf(role.name())));
            }
        });
    }
}
