package com.ayni.user_service.Iam.domain.services;

import com.ayni.user_service.Iam.domain.model.aggregates.User;
import com.ayni.user_service.Iam.domain.model.queries.GetAllUsersQuery;
import com.ayni.user_service.Iam.domain.model.queries.GetUserByEmailQuery;
import com.ayni.user_service.Iam.domain.model.queries.GetUserByIdQuery;

import java.util.List;
import java.util.Optional;

public interface UserQueryService {
    List<User> handle(GetAllUsersQuery query); // retorna todos los usuarios
    Optional<User> handle(GetUserByIdQuery query); // retorna un usuario por id
    Optional<User> handle(GetUserByEmailQuery query); // retorna un usuario por username
}
