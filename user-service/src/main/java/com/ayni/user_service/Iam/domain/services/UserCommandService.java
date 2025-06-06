package com.ayni.user_service.Iam.domain.services;

import com.ayni.user_service.Iam.domain.model.aggregates.User;
import com.ayni.user_service.Iam.domain.model.commands.SignInCommand;
import com.ayni.user_service.Iam.domain.model.commands.SignUpCommand;
import org.apache.commons.lang3.tuple.ImmutablePair;

import java.util.Optional;

public interface UserCommandService {
    Optional<User> handle(SignUpCommand command); // comando para registrar un usuario

    Optional<ImmutablePair<User, String>> handle(SignInCommand command); // comando para iniciar sesión, devuelve un par de usuario y token
}
