package com.ayni.crops_service.crops.domain.exceptions;

public class CropNameAlReadyExistsException extends IllegalArgumentException {
    public CropNameAlReadyExistsException(String message) {
        super(message);
    }
}
