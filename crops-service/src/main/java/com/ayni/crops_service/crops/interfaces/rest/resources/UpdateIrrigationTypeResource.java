package com.ayni.crops_service.crops.interfaces.rest.resources;

import com.ayni.crops_service.crops.domain.model.valueobjects.IrrigationType;
import jakarta.validation.constraints.NotNull;

public record UpdateIrrigationTypeResource(
        @NotNull(message = "irrigationType is required")
        IrrigationType irrigationType
) {
}
