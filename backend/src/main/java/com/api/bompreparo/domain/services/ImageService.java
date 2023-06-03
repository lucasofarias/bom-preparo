package com.api.bompreparo.domain.services;

import com.api.bompreparo.domain.models.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

public interface ImageService {

    void create(MultipartFile obj, UUID recipeId) throws IOException;
    void delete(UUID id);

    void uploadImage(MultipartFile imageFile, UUID recipeId) throws IOException;
    void deleteImage(UUID imageId);

}
