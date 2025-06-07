package com.ayni.user_service.profiles.interfaces.rest.transform;

import com.ayni.user_service.profiles.domain.model.commands.UpdateFarmerCommand;
import com.ayni.user_service.profiles.interfaces.rest.resources.UpdateFarmerResource;

public class UpdateFarmerResourceCommandFromResourceAssembler {
    public static UpdateFarmerCommand toCommandFromResource(UpdateFarmerResource resource, Long farmerId) {
        return new UpdateFarmerCommand(
                farmerId,
                resource.username(),
                resource.phoneNumber()
        );
    }

}
