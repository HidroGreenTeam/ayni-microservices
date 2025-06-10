package com.ayni.crops_service.crops.interfaces.rest.transform;

import com.ayni.crops_service.crops.domain.model.commands.CreateCropCommand;
import com.ayni.crops_service.crops.interfaces.rest.resources.CreateCropResource;

public class CreateCropResourceCommandFromResourceAssembler {
    public static CreateCropCommand toCommandFromResource(CreateCropResource resource) {
        return new CreateCropCommand(
                resource.cropName(),
                resource.irrigationType(),
                resource.area(),
                resource.plantingDate(),
                resource.farmerId()

        );
    }
}
