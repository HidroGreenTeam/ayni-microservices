package com.ayni.crops_service.crops.domain.services;

import com.ayni.crops_service.crops.domain.model.aggregates.Crop;
import com.ayni.crops_service.crops.domain.model.commands.CreateCropCommand;
import com.ayni.crops_service.crops.domain.model.commands.DeleteCropCommand;
import com.ayni.crops_service.crops.domain.model.commands.UpdateCropCommand;
import com.ayni.crops_service.crops.domain.model.commands.UpdateIrrigationTypeCommand;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

public interface CropCommandService {
    Long handle(CreateCropCommand command, MultipartFile file) throws IOException; // Long -> retorna el id creado
    Optional<Crop> handle(UpdateCropCommand command); // Optional -> almacena datos y comprueba que no sea "null"
    Optional<Crop> handle(UpdateIrrigationTypeCommand command); // Optional -> almacena datos y comprueba que no sea "null"
    void handle(DeleteCropCommand command); // void -> no retorna nada

    Optional<Crop> UpdateCropImage(MultipartFile file, Crop crop) throws IOException;
    Optional<Crop> deleteCropImage(Long cropId) throws IOException;


}
