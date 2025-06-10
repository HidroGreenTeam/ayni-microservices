package com.ayni.crops_service.crops.application.internal.commandServiceImpl;


import com.ayni.crops_service.crops.domain.model.entities.CropImage;
import com.ayni.crops_service.crops.domain.services.CropImageService;
import com.ayni.crops_service.crops.infrastructure.persistence.jpa.repositories.CropImageRepository;
import com.ayni.crops_service.shared.domain.services.CloudinaryCommandService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class CropImageServiceImpl implements CropImageService {

    private final CloudinaryCommandService cloudinaryCommandService;
    private final CropImageRepository cropImageRepository;

    public CropImageServiceImpl(CloudinaryCommandService cloudinaryCommandService, CropImageRepository cropImageRepository) {
        this.cloudinaryCommandService = cloudinaryCommandService;
        this.cropImageRepository = cropImageRepository;
    }

    // This method uploads an image to the cloudinary service
    @Override
    public CropImage uploadImage(MultipartFile file) throws IOException {
        Map uploadImage = cloudinaryCommandService.uploadImage(file);
        String imageUrl = (String) uploadImage.get("url");
        String imageId = (String) uploadImage.get("public_id");
        CropImage cropImage = new CropImage(file.getOriginalFilename(), imageUrl, imageId);

        return cropImageRepository.save(cropImage);
    }

    // This method deletes an image from the cloudinary service
    @Override
    public void deleteImage(CropImage cropImage) throws IOException {
        cloudinaryCommandService.deleteImage(cropImage.getImageId());
        cropImageRepository.deleteById(cropImage.getId());
    }

}
