package com.api.bompreparo.domain.services.servicesImpl;

import com.api.bompreparo.data.repositories.ImageRepository;
import com.api.bompreparo.domain.models.Image;
import com.api.bompreparo.domain.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private final ImageRepository imageRepository;

    public ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public Image create(Image obj) {
        return null;
    }

    @Override
    public Image read(UUID id) {
        return null;
    }

    @Override
    public void update(Image obj) {

    }

    @Override
    public void delete(UUID id) {

    }

    @Override
    public List<Image> list() {
        return null;
    }

    @Override
    public Image uploadImage(Image image) {
        return null;
    }

    @Override
    public Image getImage(UUID imageId) {
        return null;
    }

    @Override
    public void updateImage(Image image) {

    }

    @Override
    public void deleteImage(UUID imageId) {

    }

    @Override
    public List<Image> listImages() {
        return null;
    }

}
