package com.ayni.user_service.profiles.interfaces.rest.resources;

public record FarmerResource(Long id,
                             String username,
                             String email,
                             String phoneNumber,
                             String password,
                             String imageUrl) {
}
