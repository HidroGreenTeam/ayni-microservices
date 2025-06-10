package com.ayni.crops_service.crops.interfaces.rest.transform;

import com.ayni.crops_service.crops.domain.model.commands.UpdateCropImageCommand;
import com.ayni.crops_service.crops.interfaces.rest.resources.UpdateCropImageResource;

public class UpdateCropImageResourceFromResourceAssembler {
    public static UpdateCropImageCommand toCommandFromResource(Long id, UpdateCropImageResource resource) {
        return new UpdateCropImageCommand(
                id,
                resource.cropImage()
        );
    }
}
