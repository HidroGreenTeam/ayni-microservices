package com.ayni.user_service.Iam.interfaces.rest.transform;

import com.ayni.user_service.Iam.domain.model.commands.SignInCommand;
import com.ayni.user_service.Iam.interfaces.rest.resources.SignInResource;

public class SignInCommandFromResourceAssembler {
    public static SignInCommand toCommandFromResource(SignInResource signInResource) {
        return new SignInCommand(signInResource.email(), signInResource.password());
    }
}
