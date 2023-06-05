package com.api.bompreparo.domain.services;

import com.api.bompreparo.domain.models.Image;

import java.io.IOException;
import java.sql.SQLException;

public interface ImageService {

    void uploadImage(Image image, Long recipeId) throws IOException, SQLException;
    Image viewImage(Long imageId);
    void deleteImage(Long imageId);

}
