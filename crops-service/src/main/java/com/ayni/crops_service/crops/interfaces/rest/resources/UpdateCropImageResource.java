package com.ayni.crops_service.crops.interfaces.rest.resources;

import org.springframework.web.multipart.MultipartFile;

public record UpdateCropImageResource (
        MultipartFile cropImage
)
{
}
