package com.ayni.user_service.profiles.domain.services;

import com.ayni.user_service.profiles.domain.model.aggregates.Farmer;
import com.ayni.user_service.profiles.domain.model.queries.GetAllFarmersQuery;
import com.ayni.user_service.profiles.domain.model.queries.GetFarmerByIdQuery;

import java.util.List;
import java.util.Optional;

public interface FarmerQueryService {

    List<Farmer> getAllFarmers(GetAllFarmersQuery query);
    Optional<Farmer> getFarmerById(GetFarmerByIdQuery query);
}
