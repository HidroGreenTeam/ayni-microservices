package com.ayni.user_service.Iam.domain.model.commands;

import com.ayni.user_service.Iam.domain.model.entities.Role;

import java.util.List;

public record SignUpCommand(String fullName, String email, String password, List<Role> roles) {
}
