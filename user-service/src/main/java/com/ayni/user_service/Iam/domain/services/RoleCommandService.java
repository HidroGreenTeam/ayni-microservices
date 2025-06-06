package com.ayni.user_service.Iam.domain.services;

import com.ayni.user_service.Iam.domain.model.commands.SeedRolesCommand;

public interface RoleCommandService {
    void handle(SeedRolesCommand command);
}
