package com.api.bompreparo.domain.services;

import com.api.bompreparo.domain.models.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public interface ImageService {

    Image create(Image obj);
    Image read(UUID id);
    void update(Image obj);
    void delete(UUID id);
    List<Image> list();

    void uploadImage(MultipartFile imageFile, UUID recipeId) throws IOException;
    Image getImage(UUID imageId);
    void updateImage(Image image);
    void deleteImage(UUID imageId);
    List<Image> listImages();

}
