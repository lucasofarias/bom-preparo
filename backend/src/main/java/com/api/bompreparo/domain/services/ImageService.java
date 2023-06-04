package com.api.bompreparo.domain.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService {

    void create(MultipartFile obj, Long recipeId) throws IOException;
    void delete(Long id);

    void uploadImage(MultipartFile imageFile, Long recipeId) throws IOException;
    void deleteImage(Long imageId);

}
