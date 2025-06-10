package com.ayni.crops_service.crops.domain.model.commands;

import com.ayni.crops_service.crops.domain.model.valueobjects.IrrigationType;

public record UpdateIrrigationTypeCommand(
        Long id,
        IrrigationType irrigationType

) {
}
