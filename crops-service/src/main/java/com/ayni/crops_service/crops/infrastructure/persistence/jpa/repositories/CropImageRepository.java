package com.ayni.crops_service.crops.infrastructure.persistence.jpa.repositories;

import com.ayni.crops_service.crops.domain.model.entities.CropImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CropImageRepository extends JpaRepository<CropImage, Long> {
}
