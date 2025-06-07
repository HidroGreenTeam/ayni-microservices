package com.ayni.user_service.profiles.domain.services;

import com.ayni.user_service.profiles.domain.model.entities.FarmerImage;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FarmerImageService {

    FarmerImage uploadImage(MultipartFile multipartFile) throws IOException;
    void deleteImage(FarmerImage farmerImage) throws IOException;
}
