package com.ayni.crops_service.crops.domain.model.commands;

import com.ayni.crops_service.crops.domain.model.valueobjects.IrrigationType;

import java.time.LocalDate;

public record UpdateCropCommand(
        Long id,
        String cropName,
        IrrigationType irrigationType,
        Long area, LocalDate plantingDate,
        Long farmerId
) {
}
