package com.ayni.user_service.Iam.application.internal.commandServices;

import com.ayni.user_service.Iam.application.internal.outboundservices.hashing.HashingService;
import com.ayni.user_service.Iam.application.internal.outboundservices.tokens.TokenService;
import com.ayni.user_service.Iam.domain.model.commands.SignInCommand;
import com.ayni.user_service.Iam.domain.model.commands.SignUpCommand;
import com.ayni.user_service.Iam.domain.model.events.UserRegisteredEvent;
import com.ayni.user_service.Iam.domain.model.valueobjects.Roles;
import com.ayni.user_service.Iam.domain.services.UserCommandService;
import com.ayni.user_service.Iam.infrastructure.persistence.jpa.repositories.RoleRepository;
import com.ayni.user_service.Iam.infrastructure.persistence.jpa.repositories.UserRepository;
import com.ayni.user_service.Iam.domain.model.aggregates.User;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;


import java.util.Optional;


@Service
public class UserCommandServiceImpl implements UserCommandService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final HashingService hashingService;
    private final TokenService tokenService;

    private final ApplicationEventPublisher applicationEventPublisher;


    public UserCommandServiceImpl(UserRepository userRepository, RoleRepository roleRepository, HashingService hashingService, TokenService tokenService, ApplicationEventPublisher applicationEventPublisher) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.hashingService = hashingService;
        this.tokenService = tokenService;
        this.applicationEventPublisher = applicationEventPublisher;
    }



    @Override
    public Optional<User> handle(SignUpCommand command) {
        if (userRepository.existsByEmail(command.email()))
            throw new RuntimeException("Username already exists");

        var roles = command.roles();
        if (roles.isEmpty()) {
            var role = roleRepository.findByName(Roles.ROLE_USER);
            if (role.isPresent()) roles.add(role.get());
        } else roles = roles.stream().map(role -> roleRepository.findByName(role.getName())
                .orElseThrow(() -> new RuntimeException("Role not found"))).toList();
        var user = new User(command.fullName(), command.email(), hashingService.encode(command.password()), roles);
        userRepository.save(user);

        // publicamos el evento de usuario registrado
        System.out.println("Publishing UserRegisteredEvent for user: " + user.getEmail());
        applicationEventPublisher.publishEvent(
                new UserRegisteredEvent(this, user.getFullName(), user.getEmail(), user.getPassword())
        );



        return userRepository.findByEmail(command.email());
    }

    @Override
    public Optional<ImmutablePair<User, String>> handle(SignInCommand command) {
        var user = userRepository.findByEmail(command.email())
                .orElseThrow(() -> new RuntimeException("User not found"));
        if (!hashingService.matches(command.password(), user.getPassword()))
            throw new RuntimeException("Invalid password");
        var token = tokenService.generateToken(user.getEmail());
        return Optional.of(new ImmutablePair<>(user, token));
    }

}
